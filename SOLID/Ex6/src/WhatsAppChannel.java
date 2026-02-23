

public class WhatsAppChannel implements NotificationChannel {
    @Override
    public void send(Notification n) {
        throw new RuntimeException("WA: phone must start with + and country code");
    }
}
