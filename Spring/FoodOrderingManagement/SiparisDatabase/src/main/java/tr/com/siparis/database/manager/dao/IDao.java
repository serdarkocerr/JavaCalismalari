package tr.com.siparis.database.manager.dao;

import java.util.Collection;
import java.util.Optional;

public interface IDao<T, I> {
    Optional<T> get(int id);
    Collection<T> getAll();
    Optional<I> save(T t);
    boolean update(T t);
    boolean  delete(T t);
}
