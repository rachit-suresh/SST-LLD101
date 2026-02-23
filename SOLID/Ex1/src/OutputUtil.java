
import java.util.List;

public class OutputUtil {
  void displayInput(String raw) {
    System.out.println("INPUT: " + raw);
  }

  void displayValidationError(List<String> errors) {
    System.out.println("ERROR: cannot register");
    for (String e : errors)
      System.out.println("- " + e);
  }
  
  void displaySuccess(String id, PersistenceInterface db, StudentRecord rec) {
    System.out.println("OK: created student " + id);
        System.out.println("Saved. Total students: " + db.count());
        System.out.println("CONFIRMATION:");
        System.out.println(rec);
  }
}
