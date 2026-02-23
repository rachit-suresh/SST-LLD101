public class OutputUtil {
  public OutputUtil() {
    
  }

  void displayInvoice(String printable) {
    System.out.println(printable);
  }

  void displaySavedInvoice(String invId, PersistenceInterface store) {
    System.out.println("Saved invoice: " + invId + " (lines=" + store.countLines(invId) + ")");
  }
}
