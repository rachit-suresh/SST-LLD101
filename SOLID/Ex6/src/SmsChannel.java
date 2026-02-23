

public class SmsChannel implements NotificationChannel {
    @Override
    public void send(Notification n) {
        System.out.println("SMS -> to=" + n.phone + " body=" + n.body);
    }
}
