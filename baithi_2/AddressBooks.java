package baithi_2;

    import java.util.ArrayList;
import java.util.Scanner;

    public class AddressBooks {
        private ArrayList<Contact> contacts;
        private Scanner scanner;

        public AddressBooks() {
            contacts = new ArrayList<>();
            scanner = new Scanner(System.in);
        }

        public void addContact() {
            System.out.println("Enter contact details:");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Company: ");
            String company = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Phone Number: ");
            String phoneNumber = scanner.nextLine();

            Contact newContact = new Contact(name, company, email, phoneNumber);
            contacts.add(newContact);
            System.out.println("Contact added successfully!");
        }

        public void findContactByName() {
            System.out.print("Enter name to find: ");
            String searchName = scanner.nextLine();
            boolean found = false;

            for (Contact contact : contacts) {
                if (contact.getName().equalsIgnoreCase(searchName)) {
                    System.out.println("Contact found:");
                    System.out.println(contact);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Contact not found.");
            }
        }

        public void displayContacts() {
            System.out.println("Address Book");
            System.out.println("------------------------------------------------------------------------");
            System.out.printf("%-20s%-20s%-20s%-15s\n", "Contact Name", "Company", "Email", "Phone number");
            System.out.println("------------------------------------------------------------------------");

            for (Contact contact : contacts) {
                System.out.println(contact);
            }

            System.out.println("------------------------------------------------------------------------");
        }

        public void run() {
            int choice = 0;

            while (choice != 4) {
                System.out.println("\nMenu:");
                System.out.println("1. Add new contact");
                System.out.println("2. Find a contact by name");
                System.out.println("3. Display contacts");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");

                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                switch (choice) {
                    case 1:
                        addContact();
                        break;
                    case 2:
                        findContactByName();
                        break;
                    case 3:
                        displayContacts();
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }

            scanner.close();
        }

    }

