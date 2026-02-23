
import java.util.List;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Export Demo ===");

        ExportRequest req = new ExportRequest("Weekly Report", SampleData.longBody());
        List<Exporter> exporters = List.of(new PdfExporter(), new CsvExporter(), new JsonExporter());




        for (Exporter e : exporters) {
            try {
                ExportResult out = e.export(req);
                String prefix = e instanceof PdfExporter ? "PDF" : 
                                e instanceof CsvExporter ? "CSV" : "JSON";
                System.out.println(prefix + ": OK bytes=" + out.bytes.length);
            } catch (Exception ex) {
                String prefix = e instanceof PdfExporter ? "PDF" : 
                                e instanceof CsvExporter ? "CSV" : "JSON";
                System.out.println(prefix + ": ERROR: " + ex.getMessage());
            }
        }
    }
}
