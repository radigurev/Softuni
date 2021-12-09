package restaurant.repositories.interfaces;

import java.util.Collection;

public interface TableRepository<T> extends Repository<T> {
    T byNumber(int number);

}
