package session12.model;

import session12.MySQLConnectionDB;
import session12.entity.Entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Model implements ModelDAO {
    private Connection conn = MySQLConnectionDB.getMyConnection();
    private final  String SQL_CREATE_THONGTIN = "insert into thongtinlienhe values(?,?,?,?) ";
    private final String SQL_ALL_THONGTIN = "SELECT * FROM thongtinlienhe";
    private  final  String SQL_BY_NAME  = "select * from thongtinlienhe WHERE name like ?";

    PreparedStatement pstm = null;

    public Model() throws SQLException {
    }

    @Override
    public void createEntity(Entity entity) throws SQLException {
    pstm = conn.prepareStatement(SQL_CREATE_THONGTIN);
    pstm.setString(1, entity.getName());
    pstm.setString(2,entity.getCompany());
    pstm.setString(3,entity.getEmail());
    pstm.setInt(4,entity.getPhone());
    pstm.executeUpdate();
        System.out.println("them thanh cong");
    }

    @Override
    public ArrayList<Entity> getAll() throws SQLException {
        ArrayList<Entity> allentity = new ArrayList<>();
        pstm = conn.prepareStatement(SQL_ALL_THONGTIN);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Entity entity = new Entity();
            entity.setName(rs.getString("name"));
            entity.setCompany(rs.getString("company"));
            entity.setEmail(rs.getString("email"));
            entity.setPhone(rs.getInt("phone"));
            allentity.add(entity);
        }
        return allentity;
    }

    @Override
    public Entity getAllEntityByname(String name) throws SQLException {
        pstm = conn.prepareStatement(SQL_BY_NAME);
        pstm.setString(1, name);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            Entity entity = new Entity();
            entity.setName(rs.getString("name"));
            entity.setCompany(rs.getString("company"));
            entity.setEmail(rs.getString("email"));
            entity.setPhone(rs.getInt("phone"));
            return entity;
        }
        return null;
    }
}
