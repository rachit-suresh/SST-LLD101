
import java.util.Random;

public class HostelFeeService {
    private final PersistenceInterface repo;
    private final RoomPriceStrategy roomStrategy;
    private final AddOnCostStrategy addOnStrategy;

    public HostelFeeService(PersistenceInterface repo, RoomPriceStrategy roomStrategy, AddOnCostStrategy addOnStrategy) {
        this.repo = repo;
        this.roomStrategy = roomStrategy;
        this.addOnStrategy = addOnStrategy;
    }

    public void process(BookingRequest req) {
        double base = roomStrategy.getPrice(req.roomType);
        double addOnTotal = 0.0;
        for (AddOn a : req.addOns) {
            addOnTotal += addOnStrategy.getCost(a);
        }

        Money monthly = new Money(base + addOnTotal);

        Money deposit = new Money(5000.00);


        OutputUtil.printReceipt(req, monthly, deposit);

        String bookingId = IdUtil.getBookingId();
        repo.save(bookingId, req, monthly, deposit);
    }
}
