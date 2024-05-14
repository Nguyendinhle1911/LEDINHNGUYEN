package session12.view;

import session10.session10.entities.Product;
import session12.controller.Controller;
import session12.entity.Entity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class View {
    Controller controller = new Controller();

    private final Scanner sc;
    public View() throws SQLException {
        this.sc = new Scanner(System.in);
    }
    private int menu(){
        System.out.println("====Product Management====");
        System.out.println("1. All");
        System.out.println("2. Create");
        System.out.println("3. search name");
        System.out.println("0. Exit");
        int choice = Integer.parseInt(sc.nextLine());
        return choice;
    }

    public void createEntity() throws SQLException{
        System.out.println("Enter name: ");
        String name = sc.nextLine();
        System.out.println("enter company:");
        String company = sc.nextLine();
        System.out.println("enter email:");
        String email = sc.nextLine();
        System.out.println("enter phone:");
        int phone = Integer.parseInt(sc.nextLine());

        Entity entity = new Entity(name,company,email,phone);
        controller.createController(entity);
    }

    public void  getAll() throws SQLException{
        ArrayList<Entity> all = controller.getAllController();
        all.forEach((entity) -> {
            System.out.println("======thong tin =====");
            System.out.println(entity.getName());
            System.out.println(entity.getCompany());
            System.out.println(entity.getEmail());
            System.out.println(entity.getPhone());

        });
    }


    public void getByName() throws SQLException {
        System.out.println("Enter the name you want to view: ");
        String name = sc.nextLine();
        ArrayList<Entity> all = controller.getAllController();
        boolean productExists = false;
        for (Entity entity : all) {
            if (entity.getName().equals(name)) {
                productExists = true;
                System.out.println("name: " + entity.getName());
                System.out.println("company: " + entity.getCompany());
                System.out.println("email: " + entity.getEmail());
                System.out.println("phone: " + entity.getPhone());
                // Hiển thị thông tin sản phẩm ra màn hình
                break;
            }
        }
        if (!productExists) {
            System.out.println(name + " does not exist.");
        }
        Entity entity = controller.getNaneController(name);
        if (entity != null) {
            System.out.println("name: " + entity.getName());
            System.out.println("company: " + entity.getCompany());
            System.out.println("email: " + entity.getEmail());
            System.out.println("phone: " + entity.getPhone());
        }
    }
    public void start() throws SQLException{
        while (true){
            int choice = menu();
            switch (choice){
                case 0: System.exit(0);break;
                case 1: getAll();break;
                case 2: createEntity();break;
                case 3: getByName();break;
                default: throw new AssertionError();
            }
        }
    }
}
