
public interface PersistenceInterface {
    void save(String bookingId, BookingRequest req, Money monthlyFee, Money deposit);
}
