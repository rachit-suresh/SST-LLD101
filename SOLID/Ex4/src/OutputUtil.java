

public class OutputUtil {
    public static void printReceipt(BookingRequest req, Money fee, Money deposit) {
        System.out.println("Room: " + LegacyRoomTypes.nameOf(req.roomType) + " | AddOns: " + req.addOns);
        System.out.println("Monthly: " + fee);
        System.out.println("Deposit: " + deposit);
        System.out.println("TOTAL DUE NOW: " + fee.plus(deposit));
    }
}
