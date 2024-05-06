package session10.controller;

import session10.entities.Product;
import session10.model.ProductDaoImpl;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProductController {
    //Step 2: Gọi thể hiện của Model
    ProductDaoImpl productDaoImpl = new ProductDaoImpl();

    public ProductController() throws SQLException {
    }
    public ArrayList<Product> getAllProductController() throws SQLException{
        //call model step 2
        ArrayList<Product> products = productDaoImpl.getAllProduct();
        //Step 3
        return products;
    }
    public void createProductController(Product product) throws SQLException{
        productDaoImpl.createProduct(product);
    }
    //code tiep cac controller method khac ben duoi
}
