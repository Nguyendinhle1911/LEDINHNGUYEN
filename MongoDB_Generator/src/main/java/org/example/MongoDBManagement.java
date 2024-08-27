package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.AggregateIterable;
import org.bson.Document;

import java.util.Arrays;
import java.util.Scanner;

public class MongoDBManagement {

    public static MongoDatabase connectToDatabase() {
        try {
            MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
            MongoDatabase database = mongoClient.getDatabase("ShopQA");
            System.out.println("Kết nối thành công tới cơ sở dữ liệu: " + database.getName());
            return database;
        } catch (Exception e) {
            System.out.println("Kết nối thất bại: " + e.getMessage());
            return null;
        }
    }

    public static void insertOrderDocuments(MongoCollection<Document> collection) {
        Document order = new Document("orderid", 1)
                .append("products", Arrays.asList(
                        new Document("product_id", "quanau")
                                .append("product_name", "quan au")
                                .append("size", "XL")
                                .append("price", 10)
                                .append("quantity", 1),
                        new Document("product_id", "somi")
                                .append("product_name", "ao so mi")
                                .append("size", "XL")
                                .append("price", 10.5)
                                .append("quantity", 2)
                ))
                .append("total_amount", 31)
                .append("delivery_address", "Hanoi");

        collection.insertOne(order);
        System.out.println("Tài liệu đã được chèn thành công.");
    }

    public static void updateOrderAddress(MongoCollection<Document> collection, int orderId, String newAddress) {
        Document filter = new Document("orderid", orderId);
        Document update = new Document("$set", new Document("delivery_address", newAddress));
        collection.updateOne(filter, update);
        System.out.println("Địa chỉ giao hàng đã được cập nhật thành công.");
    }

    public static void deleteOrderById(MongoCollection<Document> collection, int orderId) {
        Document filter = new Document("orderid", orderId);
        collection.deleteOne(filter);
        System.out.println("Đơn hàng đã được xóa thành công.");
    }

    public static void readAllOrders(MongoCollection<Document> collection) {
        try (var cursor = collection.find().iterator()) {
            System.out.println("Tất cả các đơn hàng:");
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                System.out.println("Order ID: " + doc.getInteger("orderid"));
                int no = 1;
                for (Document product : (Iterable<Document>) doc.get("products")) {
                    String productName = product.getString("product_name");

                    // Retrieve price as Number to handle both Integer and Double types
                    Number priceNumber = product.get("price", Number.class);
                    double price = priceNumber != null ? priceNumber.doubleValue() : 0;

                    int quantity = product.getInteger("quantity");
                    double total = price * quantity;

                    System.out.printf("%d %s %.2f %d %.2f%n", no++, productName, price, quantity, total);
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("Đọc đơn hàng thất bại: " + e.getMessage());
        }
    }

    public static void calculateOrderTotal(MongoCollection<Document> collection, int orderId) {
        Document order = collection.find(new Document("orderid", orderId)).first();
        if (order != null) {
            Number totalAmount = order.get("total_amount", Number.class);
            double total = totalAmount != null ? totalAmount.doubleValue() : 0;
            System.out.println("Tổng số tiền của đơn hàng ID " + orderId + " là: " + total);
        } else {
            System.out.println("Không tìm thấy đơn hàng với ID: " + orderId);
        }
    }

    public static void countProductById(MongoCollection<Document> collection, String productId) {
        var pipeline = Arrays.asList(
                new Document("$unwind", "$products"),
                new Document("$match", new Document("products.product_id", productId)),
                new Document("$group", new Document("_id", "$products.product_id")
                        .append("totalQuantity", new Document("$sum", "$products.quantity")))
        );

        AggregateIterable<Document> result = collection.aggregate(pipeline);
        Document countResult = result.first();
        if (countResult != null) {
            int totalQuantity = countResult.getInteger("totalQuantity");
            System.out.println("Tổng số sản phẩm với product_id '" + productId + "': " + totalQuantity);
        } else {
            System.out.println("Không tìm thấy sản phẩm với product_id '" + productId + "'.");
        }
    }

    public static void main(String[] args) {
        MongoDatabase database = connectToDatabase();
        if (database != null) {
            MongoCollection<Document> collection = database.getCollection("OrderCollection");
            Scanner scanner = new Scanner(System.in);

            boolean running = true;

            while (running) {
                System.out.println("Chọn một thao tác:");
                System.out.println("1: Chèn đơn hàng");
                System.out.println("2: Cập nhật địa chỉ giao hàng");
                System.out.println("3: Xóa đơn hàng");
                System.out.println("4: Đọc tất cả đơn hàng");
                System.out.println("5: Tính tổng số tiền của đơn hàng");
                System.out.println("6: Đếm số lượng sản phẩm theo ID");
                System.out.println("7: Rời khỏi");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        insertOrderDocuments(collection);
                        break;
                    case 2:
                        System.out.print("Nhập ID đơn hàng: ");
                        int updateOrderId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Nhập địa chỉ giao hàng mới: ");
                        String newAddress = scanner.nextLine();
                        updateOrderAddress(collection, updateOrderId, newAddress);
                        break;
                    case 3:
                        System.out.print("Nhập ID đơn hàng để xóa: ");
                        int deleteOrderId = scanner.nextInt();
                        deleteOrderById(collection, deleteOrderId);
                        break;
                    case 4:
                        readAllOrders(collection);
                        break;
                    case 5:
                        System.out.print("Nhập ID đơn hàng để tính tổng số tiền: ");
                        int totalOrderId = scanner.nextInt();
                        calculateOrderTotal(collection, totalOrderId);
                        break;
                    case 6:
                        System.out.print("Nhập ID sản phẩm để đếm: ");
                        String productId = scanner.next();
                        countProductById(collection, productId);
                        break;
                    case 7:
                        System.out.println("Rời khỏi");
                        running = false;
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn một thao tác hợp lệ.");
                }
            }
            scanner.close();
        }
    }
}
