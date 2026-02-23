public class StudentDiscountRules implements DiscountRules {
  @Override
  public boolean isApplicable(String customerType) {
    return "student".equalsIgnoreCase(customerType);
  }
  @Override
  public double discountAmount(double subtotal, int distinctLines){
            if (subtotal >= 180.0) return 10.0;
            return 0.0;
    }
}
