package session12.controller;


import session12.entity.Entity;
import session12.model.Model;

import java.sql.SQLException;
import java.util.ArrayList;

public class Controller {
    Model model = new Model();

    public Controller() throws SQLException {
    }

    public ArrayList<Entity> getAllController() throws SQLException{
        //call model step 2
        ArrayList<Entity> entitys = model.getAll();
        //Step 3
        return entitys;
    }

    public void createController(Entity entity) throws SQLException{
        model.createEntity(entity);
    }
    public Entity getNaneController(String name) throws SQLException{
        model.getAllEntityByname(name);
        return null;
    }
}
