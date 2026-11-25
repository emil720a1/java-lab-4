package formatters;

import interfaces.ReportFormatter;
import interfaces.PaginatedReport;
import java.util.List;

public class HtmlReportFormatter
        implements ReportFormatter, PaginatedReport {
    @Override
    public String format(List<String> data) {
        return "<html><body>"
                + String.join("<br>", data)
                + "</body></html>";
    }

    @Override
    public String formatPages(List<String> data, int pageSize) {
        if (pageSize <= 0) {
            throw new IllegalArgumentException("Розмір сторінки має бути більшим за нуль");
        }

        StringBuilder result = new StringBuilder("<html><body>");

        for (int start = 0; start < data.size(); start += pageSize) {
            int end = Math.min(start + pageSize, data.size());
            result.append("<section class=\"page\">");
            result.append(String.join("<br>", data.subList(start, end)));
            result.append("</section>");
        }

        result.append("</body></html>");
        return result.toString();
    }
}
