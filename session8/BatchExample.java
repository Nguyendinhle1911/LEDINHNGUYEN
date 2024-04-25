package SESSION.session8;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchExample {
    public static void main(String[] args) throws SQLException {
        Connection connection = MySQLConnectionDB.getMyConnection();
        // su ly theo batch, cung 1 luc nhieu cau lenh
        // update , insert
        Statement stm = connection.createStatement();
        // query1
        String query1 = "update customer set first_name ='tran' Where customer_id=1";
        stm.addBatch(query1);
        // query2
        String query2 = "update customer set first-name ='ngo' Where customer_id=2";
        stm.addBatch(query2);
        int[]count = stm.executeBatch();
        System.out.println("query 1:" + count[0]);
        System.out.println("query 2:" + count[1]);
        connection.commit();
    }
}
