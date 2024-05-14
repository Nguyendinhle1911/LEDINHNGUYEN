package session20.model;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO<T> {
    void create(T entity) throws SQLException;
    List<T> getAll() throws SQLException;
    T getByName(String name) throws SQLException;
}
