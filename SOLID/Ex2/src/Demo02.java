import java.util.*;

public class Demo02 {
    public static void main(String[] args) {
        System.out.println("=== Cafeteria Billing ===");

        List<TaxRules> taxes = new ArrayList<>();
        taxes.add(new StudentTaxRules());
        taxes.add(new StaffTaxRules());
        taxes.add(new OtherTaxRules());

        List<DiscountRules> discounts = new ArrayList<>();
        discounts.add(new StudentDiscountRules());
        discounts.add(new StaffDiscountRules());
        discounts.add(new OtherDiscountRules());

        CafeteriaSystem sys = new CafeteriaSystem(taxes, discounts);
        sys.addToMenu(new MenuItem("M1", "Veg Thali", 80.00));
        sys.addToMenu(new MenuItem("C1", "Coffee", 30.00));
        sys.addToMenu(new MenuItem("S1", "Sandwich", 60.00));

        List<OrderLine> order = List.of(
                new OrderLine("M1", 2),
                new OrderLine("C1", 1)
        );

        sys.checkout("student", order);
    }
}
