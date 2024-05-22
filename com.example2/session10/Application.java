package com.example2.session10;

import com.example2.session10.view.ProductConsoleUI;

import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException {
        ProductConsoleUI productConsoleUI = new ProductConsoleUI();
        productConsoleUI.start();

    }
}
