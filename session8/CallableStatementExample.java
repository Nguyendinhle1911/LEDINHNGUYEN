package SESSION.session8;

import java.lang.reflect.Type;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

public class CallableStatementExample {
    public static void main(String[] args) throws Exception {
        Connection connection = MySQLConnectionDB.getMyConnection();
        // che day an di cac Sql engine
        String sql = "{call getCustomer(?,?,?,?)}";
        CallableStatement cstm = connection.prepareCall(sql);

        cstm.setInt(1, 10);
        cstm.registerOutParameter(2, Types.VARCHAR);
        cstm.registerOutParameter(3, Types.VARCHAR);
        cstm.registerOutParameter(4, Types.VARCHAR);

        cstm.executeUpdate();
//System.out.println("customer ID :" + cstm.getInt(1));
        System.out.println("first name:" +cstm.getString(2));
        System.out.println("last name:" +cstm.getString(3));
        System.out.println("email:" +cstm.getString(4));

    }
}
