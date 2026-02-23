
import java.util.List;

public class NotificationService {
    private final AuditLog audit;
    private final List<NotificationChannel> channels;

    public NotificationService(AuditLog audit, List<NotificationChannel> channels) {
        this.audit = audit;
        this.channels = channels;
    }

    public void broadcast(Notification n) {
        for (NotificationChannel channel : channels) {
            try {
                channel.send(n);
                audit.add(channel.getClass().getSimpleName() + " sent");

            } catch (Exception e) {
                if (e.getMessage().contains(":")) {
                    System.out.println(e.getMessage().replace("WA:", "WA ERROR:"));
                } else {
                    System.out.println(channel.getClass().getSimpleName() + " ERROR: " + e.getMessage());
                }
                audit.add(channel.getClass().getSimpleName() + " failed");
            }
        }
    }
}
