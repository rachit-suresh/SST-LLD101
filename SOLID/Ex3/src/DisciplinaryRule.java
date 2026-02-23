
public class DisciplinaryRule implements EligibilityRule {
    @Override
    public boolean isViolated(StudentProfile student) {
        return student.disciplinaryFlag != LegacyFlags.NONE;
    }

    @Override
    public String getReason() {
        return "disciplinary flag present";
    }
}
