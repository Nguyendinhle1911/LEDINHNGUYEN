package SESSION.session10.view;


import SESSION.session10.entity.Customer;
import SESSION.session10.entity.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
  public class Main {
        public static void main(String[] args) {
            List<Object> orders = new ArrayList<>().reversed();
            Scanner scanner = new Scanner(System.in);


            boolean isRunning = true;

            while (isRunning) {
                System.out.println("1. Thêm đơn hàng");
                System.out.println("2. Hiển thị danh sách đơn hàng");
                System.out.println("3. Thoát");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Nhập thông tin đơn hàng:");
                        System.out.print("ID: ");
                        int id = scanner.nextInt();
                        System.out.print("Tên khách hàng: ");
                        String customerName = scanner.next();
                        System.out.print("Địa chỉ: ");
                        String address = scanner.next();
                        System.out.print("Số điện thoại: ");
                        String phone = scanner.next();

                        Customer customer = new Customer(id, customerName, address, phone);
                        Order order = new Order(orders.size() + 1, customer);
                        orders.add(order);
                        System.out.println("Đơn hàng đã được thêm vào hệ thống.");
                        break;

                    case 2:
                        System.out.println("Danh sách đơn hàng:");
                        for (Object o : orders) {
                            System.out.println(o);
                        }
                        break;

                    case 3:
                        isRunning = false;
                        break;

                    default:
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                        break;
                }
            }

            scanner.close();
        }
    }

