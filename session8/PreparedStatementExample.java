package SESSION.session8;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementExample {
    public static void main(String[]args) throws SQLException {
        Connection connection = MySQLConnectionDB.getMyConnection();
        String query = "SELECT * FROM customer WHERE customer_id =? AND first_name like ?";
        PreparedStatement pstm = connection.prepareStatement(query);
        // gan gia tri cho tham so theo thu tun
        pstm.setInt(1,1);
        pstm.setString(2,"truong");

        ResultSet rs = pstm.getResultSet();
        while (rs.next()){
            System.out.println("===============");
            System.out.println("ID: " + rs.getInt(1));
            System.out.println("First Name: " + rs.getString(2));
            System.out.println("Last Name: " + rs.getString(3));
            System.out.println("email: " + rs.getString(4));
        }
        connection.close();


    }
}
