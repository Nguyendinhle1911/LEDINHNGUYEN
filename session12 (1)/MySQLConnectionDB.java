package session12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnectionDB {

    public static Connection getMyConnection() throws SQLException {
        Connection conn = null;
        String hostName = "localhost";//url truy cập vào server
        String dbName = "fptsodiachi";//tên db
        String userName = "root";
        String password = "";

        //String connection(chuỗi kết nối)
        // câu thần chú jdbc: + cgi đó, nếu kết nối mysql thì mysql
        //jdbc:mysql://localhost:port/dbname
        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;

        //bắt buộc phải kiểm soát tính an toàn( bắt lỗi)
        conn = DriverManager.getConnection(connectionURL, userName, password);
        return conn;
    }

    public static void main(String[] args) throws SQLException {
        //gọi hàm kiểm soát ngoại lệ => cũng phải kiểm soát ngoại lệ
        Connection cn = getMyConnection();
        if(cn != null) {
            System.out.println("connect success!");
        }
    }
}
