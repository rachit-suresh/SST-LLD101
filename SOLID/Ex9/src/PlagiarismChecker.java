public class PlagiarismChecker implements PlagiarismCheckerInterface {
    @Override
    public int check(Submission s) {
        return (s.code.contains("class") ? 12 : 40);
    }
}
