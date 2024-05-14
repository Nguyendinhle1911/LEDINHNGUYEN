package session20;

import session20.view.View;
import session20.controller.Controller;
import session20.entity.Contact;
import session20.model.ContactDAOImpl;
import session20.model.GenericDAO;

import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException {
        GenericDAO<Contact> contactDAO = new ContactDAOImpl();
        Controller<Contact> contactController = new Controller<>(contactDAO);
        View view = new View(contactController);
        view.start();
    }
}
