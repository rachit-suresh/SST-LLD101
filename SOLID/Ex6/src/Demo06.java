
import java.util.List;
import java.util.ArrayList;

public class Demo06 {
    public static void main(String[] args) {
        System.out.println("=== Notification Demo ===");
        AuditLog audit = new AuditLog();
        Notification n = new Notification("Welcome", "Hello and welcome to SST!", "riya@sst.edu", "9876543210");

        List<NotificationChannel> channels = new ArrayList<>();
        channels.add(new EmailChannel());
        channels.add(new SmsChannel());
        channels.add(new WhatsAppChannel());

        NotificationService service = new NotificationService(audit, channels);
        service.broadcast(n);

        System.out.println("AUDIT entries=" + audit.size());
    }
}
