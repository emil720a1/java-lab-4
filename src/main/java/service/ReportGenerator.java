package service;

import interfaces.DataSource;
import interfaces.ReportFormatter;

public class ReportGenerator {
    private final DataSource dataSource;
    private final ReportFormatter formatter;

    public ReportGenerator(
            DataSource dataSource,
            ReportFormatter formatter
    )
    {
        this.dataSource = dataSource;
        this.formatter = formatter;
    }
    public String generateReport() {
        var data = dataSource.loadData();
        return formatter.format(data);
    }
}
