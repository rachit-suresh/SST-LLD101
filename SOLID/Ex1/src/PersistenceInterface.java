import java.util.List;

public interface PersistenceInterface {
  public void save(StudentRecord r);

  public int count();

  public List<StudentRecord> all();
}
