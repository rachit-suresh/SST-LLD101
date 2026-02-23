public class OtherTaxRules implements TaxRules {
  static double percent = 8.0;

  @Override
  public double getPercent() {
    return percent;
  }
    
  @Override
    public boolean isApplicable(String userType) {
        return !"student".equalsIgnoreCase(userType) && !"staff".equalsIgnoreCase(userType);
    }

    @Override
    public double calculateTax(double itemsTotal) {
        return (percent/100)*itemsTotal;
    }
}
