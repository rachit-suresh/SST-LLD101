

public class FakeBookingRepo implements PersistenceInterface {
    @Override
    public void save(String bookingId, BookingRequest req, Money monthlyFee, Money deposit) {
        System.out.println("Saved booking: " + bookingId);
    }
}
