package session20.view;

import session20.controller.Controller;
import session20.entity.Contact;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class View {
    Controller<Contact> contactController;
    public View(Controller<Contact> contactController) throws SQLException {
        this.contactController = contactController;
    }
    private final Scanner sc = new Scanner(System.in);

    public void viewAllContactUI() throws SQLException {
        List<Contact> allContacts = contactController.getAllEntities();
        System.out.println("=====All Contact=====");
        allContacts.forEach((contact)->{
            System.out.println("======================");
            System.out.println("Name: " + contact.getName());
            System.out.println("Company: " + contact.getCompany());
            System.out.println("Email: " + contact.getEmail());
            System.out.println("Phone: " + contact.getPhone());
        });
    }

    public void addContactUI() throws SQLException {
        System.out.println("Enter Name: ");
        String name = sc.nextLine();
        System.out.println("Enter Company: ");
        String company = sc.nextLine();
        System.out.println("Enter Email: ");
        String email = sc.nextLine();
        System.out.println("Enter Phone: ");
        int phone = Integer.parseInt(sc.nextLine());
        Contact contact = new Contact(name, company, email, phone);
        contactController.addEntity(contact);
    }

    public void searchContactUI() throws SQLException {
        System.out.println("Enter Name: ");
        String name = sc.nextLine();
        Contact contact = contactController.getEntityByName(name);
        if (contact != null) {
            System.out.println("Name: " + contact.getName());
            System.out.println("Company: " + contact.getCompany());
            System.out.println("Email: " + contact.getEmail());
            System.out.println("Phone: " + contact.getPhone());
        }else {
            System.out.println("Contact not found");
        }
    }
    private int menu(){
        System.out.println("=====Contact=====");
        System.out.println("1. Add new contact");
        System.out.println("2. Find a contact by name");
        System.out.println("3. Display contacts");
        System.out.println("4. Exit");
        int choice = Integer.parseInt(sc.nextLine());
        return choice;
    }

    public void start() throws SQLException {
        while (true){
            int choice = menu();
            switch (choice) {
                case 1: addContactUI();break;
                case 2: searchContactUI();break;
                case 3: viewAllContactUI();break;
                case 4: System.exit(0);break;
                default: throw new AssertionError();
            }
        }
    }
}
