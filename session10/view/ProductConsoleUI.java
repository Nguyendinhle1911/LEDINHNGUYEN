package session10.view;

import session10.controller.ProductController;
import session10.entities.Product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductConsoleUI {
    //Step 1 call controller
    ProductController productController = new ProductController();
    //Fields
    private final Scanner sc;
    public ProductConsoleUI() throws SQLException {
        this.sc = new Scanner(System.in);
    }
    private int menu(){
        System.out.println("====Product Management====");
        System.out.println("1. All product");
        System.out.println("2. Create product");
        System.out.println("0. Exit product");
        int choice = Integer.parseInt(sc.nextLine());
        return choice;
    }
    public void getAllProductUI() throws SQLException{
        //Step 4
        ArrayList<Product> allProduct = productController.getAllProductController();
        allProduct.forEach((product)->{
            System.out.println("=====Product Details=====");
            System.out.println(product.getProductId());
            System.out.println(product.getProductName());
            System.out.println(product.getProductDesc());
            System.out.println(product.getPrice());
        });
    }
    public void createProduct() throws SQLException{
        System.out.println("Enter id: ");
        int prod_id = Integer.parseInt(sc.nextLine());
        System.out.println("Enter product name : ");
        String name = sc.nextLine();
        System.out.println("Enter product desc : ");
        String product_desc = sc.nextLine();
        System.out.println("Enter price: ");
        double price = Double.parseDouble(sc.nextLine());
        Product product = new Product(prod_id,name,product_desc,price);
        productController.createProductController(product);
    }
    public void start() throws SQLException{
        while (true){
            int choice = menu();
            switch (choice){
                case 0: System.exit(0);break;
                case 1: getAllProductUI();break;
                case 2: createProduct();break;
                default: throw new AssertionError();
            }
        }
    }
}
