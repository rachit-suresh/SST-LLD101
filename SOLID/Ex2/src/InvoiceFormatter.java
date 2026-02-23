import java.util.List;

public class InvoiceFormatter {
  String invId;
  List<String> itemName;
  List<Integer> qty;
  List<Double> lineTotal;
  double subtotal;
  double taxPct;
  double tax;
  double discount;
  double total;
  
  String formatInvoice() {
    StringBuilder out = new StringBuilder();
    out.append("Invoice# ").append(this.invId).append("\n");
     for (int i = 0; i < this.itemName.size(); i++) {
        String item = this.itemName.get(i);
        int q = this.qty.get(i);
        double line = this.lineTotal.get(i);
        out.append((String.format("- %s x%d = %.2f", item, q, line))).append("\n");
    }
    out.append(String.format("Subtotal: %.2f\n", this.subtotal));
    out.append(String.format("Tax(%.0f%%): %.2f\n", this.taxPct, this.tax));
    out.append(String.format("Discount: -%.2f\n", this.discount));
    out.append(String.format("TOTAL: %.2f", this.total));

    return out.toString();
  }
}
