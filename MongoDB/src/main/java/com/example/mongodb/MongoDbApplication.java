package com.example.mongodb;

import java.util.Scanner;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class MongoDBSwitchExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Hiển thị menu tùy chọn
        System.out.println("Chọn một hành động:");
        System.out.println("1. Chèn một document");
        System.out.println("2. Đọc tất cả các document");
        System.out.println("3. Cập nhật một document");
        System.out.println("4. Xóa một document");
        System.out.print("Nhập lựa chọn của bạn (1-4): ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Đọc dòng trống còn lại sau khi nhập số

        // Kết nối đến MongoDB
        String connectionString = "mongodb://<username>:<password>@<host>:<port>/<database>";
        MongoClient mongoClient = MongoClients.create(connectionString);
        MongoDatabase database = mongoClient.getDatabase("myDatabase");
        MongoCollection<Document> collection = database.getCollection("myCollection");

        switch (choice) {
            case 1:
                // Chèn một document mới
                System.out.print("Nhập tên: ");
                String name = scanner.nextLine();
                System.out.print("Nhập tuổi: ");
                int age = scanner.nextInt();
                Document insertDocument = new Document("name", name)
                        .append("age", age);
                collection.insertOne(insertDocument);
                System.out.println("Document đã được chèn.");
                break;

            case 2:
                // Đọc tất cả các document
                System.out.println("Danh sách tất cả các document:");
                for (Document doc : collection.find()) {
                    System.out.println(doc.toJson());
                }
                break;

            case 3:
                // Cập nhật một document
                System.out.print("Nhập tên của document cần cập nhật: ");
                String updateName = scanner.nextLine();
                System.out.print("Nhập tuổi mới: ");
                int newAge = scanner.nextInt();
                Document query = new Document("name", updateName);
                Document update = new Document("$set", new Document("age", newAge));
                collection.updateOne(query, update);
                System.out.println("Document đã được cập nhật.");
                break;

            case 4:
                // Xóa một document
                System.out.print("Nhập tên của document cần xóa: ");
                String deleteName = scanner.nextLine();
                Document deleteQuery = new Document("name", deleteName);
                collection.deleteOne(deleteQuery);
                System.out.println("Document đã được xóa.");
                break;

            default:
                System.out.println("Lựa chọn không hợp lệ.");
                break;
        }

        // Đóng kết nối
        mongoClient.close();
        scanner.close();
    }
}
