
import java.util.ArrayList;
import java.util.List;

public class EligibilityService {
    private final PersistenceInterface store;
    private final List<EligibilityRule> rules;

    public EligibilityService(PersistenceInterface store, List<EligibilityRule> rules) {
        this.store = store;
        this.rules = rules;
    }

    public void checkAndProcess(StudentProfile student) {
        List<String> violations = new ArrayList<>();
        String status = "ELIGIBLE";



        for (EligibilityRule rule : rules) {
            if (rule.isViolated(student)) {
                status = "NOT_ELIGIBLE";
                violations.add(rule.getReason());
                break;
            }
        }

        EligibilityEngineResult result = new EligibilityEngineResult(status, violations);
        
        OutputUtil.printReport(student, result);
        store.save(student.rollNo, status);
    }
}
