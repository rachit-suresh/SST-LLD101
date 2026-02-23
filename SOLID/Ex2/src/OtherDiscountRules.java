public class OtherDiscountRules implements DiscountRules {
  @Override
  public boolean isApplicable(String customerType) {
    return !"staff".equalsIgnoreCase(customerType) && !"student".equalsIgnoreCase(customerType);
  }
  @Override
  public double discountAmount(double subtotal, int distinctLines) {
    return 0;
  }
}
