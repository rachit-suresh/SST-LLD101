public class StaffTaxRules implements TaxRules {
  static double percent = 2.0;
  @Override
  public double getPercent() {
    return percent;
  }
    
  @Override
    public boolean isApplicable(String userType) {
        return "staff".equalsIgnoreCase(userType);
    }

    @Override
    public double calculateTax(double itemsTotal) {
        return (percent/100)*itemsTotal;
    }
}
