
import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== Placement Eligibility ===");
        StudentProfile s = new StudentProfile("23BCS1001", "Ayaan", 8.10, 72, 18, LegacyFlags.NONE);
        RuleInput config = new RuleInput();

        List<EligibilityRule> rules = new ArrayList<>();
        rules.add(new DisciplinaryRule());
        rules.add(new CgrRule(config.minCgr));
        rules.add(new AttendanceRule(config.minAttendance));
        rules.add(new CreditsRule(config.minCredits));

        EligibilityService service = new EligibilityService(new FakeEligibilityStore(), rules);
        service.checkAndProcess(s);
    }
}
