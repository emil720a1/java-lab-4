package sources;

import interfaces.DataSource;

import java.util.List;

public class FileDataSource implements DataSource {
    @Override
    public List<String> loadData() {
        return List.of(
                "Файл: Замовлення №101; Статус: виконано",
                "Файл: Замовлення №102; Статус: у процесі",
                "Файл: Замовлення №103; Статус: очікує оплату"
        );
    }
}
