package session20.controller;

import session20.entity.Entity;
import session20.model.GenericDAO;

import java.sql.SQLException;
import java.util.List;

public class Controller<T extends Entity<?>> {
    private GenericDAO<T> model;
    public Controller(GenericDAO<T> model) throws SQLException {
        this.model = model;
    }
    public void addEntity(T entity) throws SQLException {
        model.create(entity);
    }
    public List<T> getAllEntities() throws SQLException{
        List<T> entities = model.getAll();
        return entities;
    }
    public T getEntityByName(String name) throws SQLException {
        return model.getByName(name);
    }
}
