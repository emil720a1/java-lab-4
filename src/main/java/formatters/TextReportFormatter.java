package formatters;

import interfaces.ReportFormatter;

import java.util.List;

public class TextReportFormatter implements
        ReportFormatter {
    @Override
    public String format(List<String> data) {
        return String.join("\n", data);
    }
}
