package formatters;

import interfaces.ReportFormatter;
import java.util.List;

public class CsvReportFormatter implements
        ReportFormatter {

    @Override
    public String format(List<String> data) {
        return String.join(",", data);
    }
}
