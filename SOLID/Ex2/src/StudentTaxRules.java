public class StudentTaxRules implements TaxRules{
    static double percent = 5.0;

    @Override
    public double getPercent() {
        return percent;
    }

    @Override
    public boolean isApplicable(String userType) {
        return "student".equalsIgnoreCase(userType);
    }

    @Override
    public double calculateTax(double itemsTotal) {
        return (percent/100)*itemsTotal;
    }
}
