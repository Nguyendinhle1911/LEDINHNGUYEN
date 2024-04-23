package SESSION.session8;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLOutput;

public class MySQLConnectionDB {

    public static Connection getMyConnection() throws SQLException {
        Connection conn = null ;
        String hostName = "localhost";// url truy cap vao sever
        String dbName ="ecomerceFPT";// database
        String userName ="root";
        String password ="";

        // String connection( chuoi ket noi)
        String connectionURL = "jdbc:mysql://"+hostName+":3306/"+dbName;
        conn = DriverManager.getConnection(connectionURL,userName,password);
        return conn;
    }
    public static void main(String[]args) throws SQLException{
        Connection cn = getMyConnection();
        if(cn!=null){
           System.out.println("ket noi thanh cong!");
       }
   }
}
