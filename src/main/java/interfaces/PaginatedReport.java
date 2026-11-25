package interfaces;

import java.util.List;

public interface PaginatedReport {
    String formatPages(List<String> data, int pageSize);
}
