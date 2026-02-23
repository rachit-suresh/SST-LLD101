public class IdUtil {
  static int invoiceSeq=1000;

  static String getId() {
    String invId = "INV-" + (++invoiceSeq);
    return invId;
  }
}
