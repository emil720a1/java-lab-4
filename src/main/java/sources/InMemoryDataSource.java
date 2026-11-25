package sources;

import interfaces.DataSource;

import java.util.List;

public class InMemoryDataSource implements DataSource {
    @Override
    public List<String> loadData() {
        return List.of(
                "Товар: Ноутбук; Кількість: 2; Сума: 40000",
                "Товар: Мишка; Кількість: 5; Сума: 2500",
                "Товар: Клавіатура; Кількість: 3; Сума: 4500"
        );
    }
}
