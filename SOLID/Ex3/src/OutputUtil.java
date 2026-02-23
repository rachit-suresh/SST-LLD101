public class OutputUtil {
    public static void printReport(StudentProfile s, EligibilityEngineResult r) {
        System.out.printf("Student: %s (CGR=%.2f, attendance=%d, credits=%d, flag=%s)%n",
            s.name, s.cgr, s.attendancePct, s.earnedCredits, LegacyFlags.nameOf(s.disciplinaryFlag));
        System.out.println("RESULT: " + r.status);
        if (!r.reasons.isEmpty()) {
            for (String reason : r.reasons) {
                System.out.println("- " + reason);
            }
        }
    }
}
