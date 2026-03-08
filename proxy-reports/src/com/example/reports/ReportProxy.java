package com.example.reports;


public class ReportProxy implements Report {

    private final String reportId;
    private final String title;
    private final String classification;
    private final AccessControl accessControl = new AccessControl();
    private Report report;

    public ReportProxy(String reportId, String title, String classification) {
        this.reportId = reportId;
        this.title = title;
        this.classification = classification;
    }

    @Override
    public void display(User user) {
        // Starter placeholder: intentionally incorrect.
        // Students should remove direct real loading on every call.
        if (!accessControl.canAccess(user, classification)) {
        System.out.println("ACCESS DENIED: " + user.getName() + " cannot view [" + classification + "] report: " + title);
        return;
        }
        this.getReal().display(user);
    }
    
    public Report getReal() {
        if (report == null) {
            report = new RealReport(reportId, title, classification);
        }
        return report;
    }
}
