package baithi_XMLandJSON;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConnectionDB {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/ecommercefpt";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static List<Student> getConnection() throws SQLException {
        List<Student> Students = new ArrayList<>();

        String query = "SELECT * FROM student";
        Connection connection = DriverManager.getConnection(JDBC_URL,USER,PASSWORD);
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String address = resultSet.getString("address");
            String email = resultSet.getString("email");
            int phone = resultSet.getInt("phone");
            Date DOD = resultSet.getDate("DOD");

            Students.add(new Student(id,name,address,email,phone,DOD));
        }
        return Students;
    }

    public static List<Student> searchStudentByName(List<Student> students, String name) {
        List<Student> result = new ArrayList<>();

        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                result.add(student);
            }
        }

        return result;
    }


    public static List<Student> searchStudentByEmail(List<Student> students, String email) {
        List<Student> result1 = new ArrayList<>();

        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(email)) {
                result1.add(student);
            }
        }

        return result1;
    }

}
