package session20.model;

import session20.model.MySQLConnectionDB;
import session20.entity.Contact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactDAOImpl implements GenericDAO<Contact>{
    private final Connection conn = MySQLConnectionDB.getMyConnection();
    private final String SQL_CREATE_CONTACT = "INSERT INTO contact (name, company, email, phone) VALUES (?, ?, ?, ?)";
    private final String SQL_GET_CONTACT_BY_NAME = "select * from contact where name like ?";
    private final String SQL_GET_ALL_CONTACTS = "select * from contact";
    PreparedStatement pstm = null;


    public ContactDAOImpl() throws SQLException {
    }

    @Override
    public void create(Contact entity) throws SQLException {
        pstm = conn.prepareStatement(SQL_CREATE_CONTACT);
        pstm.setString(1, entity.getName());
        pstm.setString(2, entity.getCompany());
        pstm.setString(3, entity.getEmail());
        pstm.setInt(4, entity.getPhone());
        pstm.executeUpdate();
        System.out.println("Contact created");
    }

    @Override
    public List<Contact> getAll() throws SQLException {
        pstm = conn.prepareStatement(SQL_GET_ALL_CONTACTS);
        ResultSet rs = pstm.executeQuery();
        List<Contact> contacts = new ArrayList<Contact>();
        while (rs.next()) {
            Contact contact = new Contact();
            contact.setName(rs.getString("name"));
            contact.setCompany(rs.getString("company"));
            contact.setEmail(rs.getString("email"));
            contact.setPhone(rs.getInt("phone"));
            contacts.add(contact);
        }
        return contacts;
    }

    @Override
    public Contact getByName(String name) throws SQLException {
        pstm = conn.prepareStatement(SQL_GET_CONTACT_BY_NAME);
        pstm.setString(1, name);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            Contact contact = new Contact();
            contact.setName(rs.getString("name"));
            contact.setCompany(rs.getString("company"));
            contact.setEmail(rs.getString("email"));
            contact.setPhone(rs.getInt("phone"));
            return contact;
        }
        return null;
    }
}
