package SESSION.session10;

import SESSION.session10.view.ProductConsoleUI;

import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException {
        ProductConsoleUI productConsoleUI = new ProductConsoleUI();
        productConsoleUI.start();

    }
}
