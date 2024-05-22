package com.example2.session10.model;

import com.example2.session10.entities.Product;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ProductDAO {
    void createProduct(Product product) throws SQLException;
    Product getProductById(int prodId) throws SQLException;
    ArrayList<Product> getAllProduct() throws SQLException;
    void updateProduct(Product product) throws SQLException;
    boolean deleteProduct(int prodId) throws SQLException;
    ArrayList<Product> findByName(String name) throws SQLException;

}
