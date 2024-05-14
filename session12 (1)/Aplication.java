package session12;

import session12.view.View;

import java.sql.SQLException;

public class Aplication {
    public static void main(String[] args) throws SQLException {
        View view = new View();
        view.start();
    }
}
