import com.example.tickets.IncidentTicket;
import com.example.tickets.TicketService;
import java.util.List;

public class TryIt {

    public static void main(String[] args) {
        TicketService service = new TicketService();

        IncidentTicket t = service.createTicket("TCK-1001", "reporter@example.com", "Payment failing on checkout");
        System.out.println("Created: " + t);

        IncidentTicket assigned = service.assign(t, "agent@example.com");
        IncidentTicket critical = service.escalateToCritical(assigned);
        System.out.println("\nAfter assign + escalate (new objects): " + critical);
        System.out.println("\nOriginal is unchanged: " + t);

        List<String> tags = critical.getTags();
        System.out.println("\nAttempting external tag mutation...");
        try {
            tags.add("HACKED_FROM_OUTSIDE");
            System.out.println("FAIL: mutation succeeded!");
        } catch (UnsupportedOperationException e) {
            System.out.println("OK: external mutation blocked — UnsupportedOperationException");
        }
    }
}
