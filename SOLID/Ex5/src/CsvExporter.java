import java.nio.charset.StandardCharsets;
public class CsvExporter implements Exporter {
    @Override
    public ExportResult export(ExportRequest req) {
        String title = csvField(req.title);
        String body  = csvField(req.body);
        String csv = "title,body\n" + title + "," + body + "\n";
        return new ExportResult("text/csv", csv.getBytes(StandardCharsets.UTF_8));
    }

    private String csvField(String s) {
        if (s == null) return "";
        if (s.contains(",") || s.contains("\"") || s.contains("\n")) {
            return "\"" + s.replace("\"", "\"\"") + "\"";
        }
        return s;
    }
}
