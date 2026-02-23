public interface TaxRules {
    public boolean isApplicable(String customerType);

    public double calculateTax(double itemsTotal);

    double getPercent();
}
