package SESSION.session8;


import java.sql.*;

public class MyApplication {
    public static void main(String[] args) throws SQLException{
//        createCustomer();
        getAllCustomer();
        getCustomerVsPreparedStatement();

    }
    public static void getAllCustomer() throws SQLException{
        //Goi doi tuong connection (nhac object connection dat vao class nay)
        Connection connection = MySQLConnectionDB.getMyConnection();
        //Tao Statement(Lenh thuc thi voi csdl)
        Statement stm = connection.createStatement();
        //Truy van trong csdl
        String query = "select * from customers";
        //thuc thi truy van, tra ket qua ve cho doi tuong ResultSet
        //ResultSet chua ket qua tra ve tu csdl
        ResultSet rs = stm.executeQuery(query);

        //Doc ban ghi tren resultSet
        while (rs.next()) {
            //Doc customer_id
            int cusId = rs.getInt(1);
            String first_name = rs.getString(2);
            String last_name = rs.getString(3);
            String email = rs.getString(4);
            System.out.println("=================");
            System.out.println("Customer ID: " + cusId);
            System.out.println("First Name: " + first_name);
            System.out.println("Last Name: " + last_name);
            System.out.println("Email: " + email);
        }
        connection.close();
    }
    public static void createCustomer() throws SQLException{
        Connection connection = MySQLConnectionDB.getMyConnection();
        Statement stm = connection.createStatement();
        String query = "INSERT INTO customers(customer_id, first_name, last_name, email)" + "VALUES(3, 'NGUYEN', 'TU ANH', 'anh@fpt.edu.vn')";

        //Ham executeUpdate()  dung cho muc dich: INSERT, UPDATE, DELETE
        int count = stm.executeUpdate(query);
        System.out.println(count);

    }
    public static void getCustomerVsPreparedStatement() throws SQLException{
        Connection connection = MySQLConnectionDB.getMyConnection();
        //Truy van
        String query = "select * from customers where customer_id = ? and last_name like ?";
        //Tao doi tuong preparestatement
        PreparedStatement pstm = connection.prepareStatement(query);
        //Thiet lap tham so cho preparestatement (dau hoi cham dau tien (so 1))
        pstm.setInt(1, 3);
        //Thiet lap tham so cho dau ? thu 2 (so 2)
        pstm.setString(2, "TU ANH");

        // Ket qua tra ve doi tuong resultset
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            System.out.println("=======Use Prepared Statement=======");
            System.out.println("Customer ID: " + rs.getInt("customer_id"));
            System.out.println("First Name: " + rs.getString("first_name"));
            System.out.println("Last Name: " + rs.getString("last_name"));
            System.out.println("Email: " + rs.getString("email"));
        }
        connection.close();
    }
}
