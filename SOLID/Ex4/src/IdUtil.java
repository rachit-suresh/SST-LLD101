import java.util.Random;

public class IdUtil {
    public static String getBookingId() {
        return "H-" + (7000 + new Random().nextInt(1000));
    }
}
