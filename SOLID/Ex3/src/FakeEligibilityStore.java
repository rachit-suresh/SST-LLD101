
import java.util.*;

public class FakeEligibilityStore implements PersistenceInterface {
    private final Map<String, String> db = new HashMap<>();


    @Override
    public void save(String id, String status) {
        db.put(id, status);
        System.out.println("Saved evaluation for roll=" + id);
    }
    
    public String get(String id) { return db.get(id); }
}
