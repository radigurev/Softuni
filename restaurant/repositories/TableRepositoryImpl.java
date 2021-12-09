package restaurant.repositories;

import restaurant.entities.tables.interfaces.Table;
import restaurant.repositories.interfaces.TableRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class TableRepositoryImpl implements TableRepository<Table> {
    private Collection<Table> models;

    public TableRepositoryImpl() {
        this.models = new ArrayList<>();
    }

    @Override
    public Collection<Table> getAllEntities() {
        return Collections.unmodifiableCollection(this.models);
    }

    @Override
    public void add(Table t) {
        this.models.add(t);
    }

    @Override
    public Table byNumber(int number) {
        return this.models
                .stream()
                .filter(t -> t.getTableNumber() == number)
                .findFirst()
                .orElse(null);
    }
}
