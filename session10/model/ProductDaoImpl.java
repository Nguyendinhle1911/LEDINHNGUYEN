package session10.model;

import session10.entities.Product;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDaoImpl implements ProductDAO {
    private final Connection conn = MySQLConnectionDB.getMyConnection();
    private final String SQL_CREATE_PRODUCT = "insert into products values(?,?,?,?)";
    private final String SQL_GET_By_ID= "select * from products where product_id = ?";
    private final String SQL_GET_All_PRODUCT= "select * from products";
    private final String SQL_DELETE_PRODUCT = "delete from products where product_id = ?";
    private final String SQL_UPDATE_PRODUCT = "update products where product_id = ?";
    PreparedStatement pstm = null;

    public ProductDaoImpl() throws SQLException {
    }


    @Override
    public void createProduct(Product product) throws SQLException {
        pstm = conn.prepareStatement(SQL_CREATE_PRODUCT);
        pstm.setInt(1,product.getProductId());
        pstm.setString(2,product.getProductName());
        pstm.setString(3,product.getProductDesc());
        pstm.setDouble(4,product.getPrice());
        pstm.executeUpdate();
        System.out.println("Insert success");

    }

    @Override
    public Product getProductById(int prodId) throws SQLException {
        return null;
    }

    @Override
    public ArrayList<Product> getAllProduct() throws SQLException {
        ArrayList<Product> allProducts = new ArrayList<>();
        pstm = conn.prepareStatement(SQL_GET_All_PRODUCT);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()){
            Product product = new Product();
            product.setProductId(rs.getInt(1));
            product.setProductName(rs.getString(2));
            product.setProductDesc(rs.getString(3));
            product.setPrice(rs.getDouble(4));
            allProducts.add(product);
        }
        return allProducts;
    }

    @Override
    public void updateProduct(Product product) throws SQLException {

    }

    @Override
    public boolean deleteProduct(int prodId) throws SQLException {
        return false;
    }

    @Override
    public ArrayList<Product> findByName(String name) throws SQLException {
        return null;
    }
}
