package session12.model;

import session12.entity.Entity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ModelDAO {

    void  createEntity(Entity entity) throws SQLException;
    ArrayList<Entity> getAll() throws SQLException;
    Entity getAllEntityByname(String name) throws SQLException;

}
