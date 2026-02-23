
public class SimpleAddOnCostStrategy implements AddOnCostStrategy {
    @Override
    public double getCost(AddOn addOn) {
        if (addOn == AddOn.MESS) return 1000.0;
        if (addOn == AddOn.LAUNDRY) return 500.0;
        if (addOn == AddOn.GYM) return 300.0;
        return 0.0;
    }
}
