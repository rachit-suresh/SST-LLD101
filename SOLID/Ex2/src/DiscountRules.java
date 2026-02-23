public interface DiscountRules {
    public double discountAmount(double subtotal, int distinctLines);

    public boolean isApplicable(String customerType);
}
