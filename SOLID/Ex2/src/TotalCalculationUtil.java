public class TotalCalculationUtil {
  static double calculate(double subtotal, double tax, double discount) {
    double total = subtotal + tax - discount;
    return total;
  }
}
