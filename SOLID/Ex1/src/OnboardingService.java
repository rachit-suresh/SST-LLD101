import java.util.*;

public class OnboardingService {
    private final FakeDb db;

    public OnboardingService(FakeDb db) { this.db = db; }

    // Intentionally violates SRP: parses + validates + creates ID + saves + prints.
    public void registerFromRawInput(String raw) {
        OutputUtil display = new OutputUtil();
        ParsingUtil parser = new ParsingUtil();
        ValidationUtil validate = new ValidationUtil();
        
        display.displayInput(raw);

       
        Map<String, String> kv = parser.parseInput(raw);
        String name = kv.getOrDefault("name", "");
        String email = kv.getOrDefault("email", "");
        String phone = kv.getOrDefault("phone", "");
        String program = kv.getOrDefault("program", "");

        List<String> errors = validate.validate(name, email, phone, program);

        if (!errors.isEmpty()) {
            display.displayValidationError(errors);
            return;
        }

        String id = IdUtil.nextStudentId(db.count());
        StudentRecord rec = new StudentRecord(id, name, email, phone, program);

        db.save(rec);

        display.displaySuccess(id, db, rec);
    }
}
