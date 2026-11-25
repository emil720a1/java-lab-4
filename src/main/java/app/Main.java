package app;

import formatters.CsvReportFormatter;
import formatters.HtmlReportFormatter;
import formatters.TextReportFormatter;
import interfaces.DataSource;
import interfaces.PaginatedReport;
import interfaces.ReportFormatter;
import service.ReportGenerator;
import sources.FileDataSource;
import sources.InMemoryDataSource;

public class Main {
    public static void main(String[] args) {
        DataSource memorySource = new InMemoryDataSource();
        ReportFormatter textFormatter = new TextReportFormatter();
        ReportGenerator textGenerator = new ReportGenerator(memorySource, textFormatter);

        System.out.println("=== TEXT REPORT ===");

        System.out.println(textGenerator.generateReport());

        ReportFormatter csvFormatter = new CsvReportFormatter();

        ReportGenerator csvGenerator = new ReportGenerator(memorySource, csvFormatter);

        System.out.println("\n=== CSV REPORT ===");

        System.out.println(csvGenerator.generateReport());

        DataSource fileSource = new FileDataSource();
        ReportFormatter htmlFormatter = new HtmlReportFormatter();

        ReportGenerator htmlGenerator =
                new ReportGenerator(fileSource, htmlFormatter);

        System.out.println("\n=== HTML REPORT ===");

        System.out.println(htmlGenerator.generateReport());

        System.out.println("\n=== PAGINATED HTML REPORT ===");
        PaginatedReport paginatedFormatter = new HtmlReportFormatter();
        System.out.println(
                paginatedFormatter.formatPages(fileSource.loadData(), 2)
        );
    }
}
