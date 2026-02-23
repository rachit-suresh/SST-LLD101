import java.util.*;

public class CafeteriaSystem {
    private final Map<String, MenuItem> menu;
    private final PersistenceInterface store;
    private final List<TaxRules> taxStrategies;
    private final List<DiscountRules> discountStrategies;

    public CafeteriaSystem(List<TaxRules> taxes, List<DiscountRules> discounts) {
        menu = new LinkedHashMap<>();
        store = new FileStore();
        this.taxStrategies = taxes;
        this.discountStrategies = discounts;
    }

    

    public void addToMenu(MenuItem i) { menu.put(i.id, i); }

    // Intentionally SRP-violating: menu mgmt + tax + discount + format + persistence.
    public void checkout(String customerType, List<OrderLine> lines) {
        OutputUtil display = new OutputUtil();
        InvoiceFormatter invoice = new InvoiceFormatter();
        String invId = IdUtil.getId();
        invoice.invId = invId;

        double subtotal = 0.0;
        List<String> itemName =new ArrayList<>();
        List<Integer> qty = new ArrayList<>();
        List<Double> lineTotal = new ArrayList<>();
        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);
            double lineTot = item.price * l.qty;
            subtotal += lineTot;

            itemName.add(item.name);
            qty.add(l.qty);
            lineTotal.add(lineTot);

        }
        invoice.itemName = itemName;
        invoice.qty = qty;
        invoice.lineTotal = lineTotal;
        invoice.subtotal=subtotal;

        double tax = 0.0;
        double taxPct=0.0;
        for (TaxRules rule : taxStrategies) {
            if (rule.isApplicable(customerType)) {
                tax = rule.calculateTax(subtotal);
                taxPct = rule.getPercent();
                break;
            }
        }

        double discount = 0.0;
        for (DiscountRules rule : discountStrategies) {
            if (rule.isApplicable(customerType)) {
                discount = rule.discountAmount(subtotal, lines.size());
                break;
            }
        }
       

        double total = TotalCalculationUtil.calculate(subtotal, tax, discount);

        invoice.taxPct = taxPct;
        invoice.tax = tax;
        invoice.discount = discount;
        invoice.total = total;


        String printable = invoice.formatInvoice();
        display.displayInvoice(printable);

        store.save(invId, printable);
        display.displaySavedInvoice(invId, store);
    }
}
