package SESSION.session8;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchExample {
    public static void main(String[] args) throws SQLException {
        Connection conn = openConnection();
        Statement stmt = openStatement();

        // kiem tra giao dich tu dong
        conn.setAutoCommit(false);

        // thuc hien dong thoi 3 cau lenh query vao 1 lo
        String query1 = "insert into orders values(3,1,'25/04/25')";
        stmt.addBatch(query1);
        String query2 = "insert into order_detail values(3,1,1)";
        stmt.addBatch(query2);
        String query3 = "update products set price = 500 where product_id = 1";
        stmt.addBatch(query3);

        int [] counts = stmt.executeBatch();
        System.out.println(counts[0]);
        System.out.println(counts[1]);
        System.out.println(counts[2]);

        conn.commit();

        // Đóng kết nối và câu lệnh sau khi hoàn thành
        stmt.close();
        conn.close();
    }

    private static Statement openStatement() {
        return null;
    }

    private static Connection openConnection() {
        return null;
    }
}