
import java.util.List;


public class Main {
    public static void main(String[] args) {
        System.out.println("=== Hostel Fee Calculator ===");
        BookingRequest req = new BookingRequest(LegacyRoomTypes.DOUBLE, List.of(AddOn.LAUNDRY, AddOn.MESS));
        
        HostelFeeService service = new HostelFeeService(
            new FakeBookingRepo(),
            new LegacyRoomPriceStrategy(),
            new SimpleAddOnCostStrategy()
        );
        
        service.process(req);
    }
}
