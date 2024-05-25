package baithi_XMLandJSON;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import static baithi_XMLandJSON.StudentToJsonFileWrite.writeStudentToJsonFile;

public class Application {
    public static void main(String[] args) throws SQLException, IOException {
        // Load data
        List<Student> students = ConnectionDB.getConnection();

        // Ghi file JSON
        String filePath = "students.json";
        writeStudentToJsonFile(students, filePath);
        System.out.println("Data has been written to file " + filePath);


        // Search by name
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter student name to search: ");
        String nameToSearch = scanner.nextLine();

        List<Student> searchResult = ConnectionDB.searchStudentByName(students, nameToSearch);
        if (searchResult.isEmpty()) {
            System.out.println("No student found with the name: " + nameToSearch);
        } else {
            System.out.println("Students found with the name " + nameToSearch + ": ");
            for (Student student : searchResult) {
                System.out.println(student);
            }
        }


        // search email
        System.out.println("Enter student email to search: ");
        String emailToSearch = scanner.nextLine();

        List<Student> emailResult = ConnectionDB.searchStudentByEmail(students, emailToSearch);
        if (searchResult.isEmpty()) {
            System.out.println("No student found with the name: " + emailToSearch);
        } else {
            System.out.println("Students found with the name " + emailToSearch + ": ");
            for (Student student : searchResult) {
                System.out.println(student);
            }
        }

        scanner.close();
    }

}