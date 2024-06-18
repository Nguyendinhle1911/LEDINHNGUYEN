using System;
using MySql.Data.MySqlClient;

class Contact
{
    public string Name { get; set; }
    public string PhoneNumber { get; set; }

    public Contact(string name, string phoneNumber)
    {
        Name = name;
        PhoneNumber = phoneNumber;
    }
}

class ContactManager
{
    static MySqlConnection connection = new MySqlConnection("Server=localhost;Port=3306;Database=CSharpTest;User=root;Password=;");

    static void AddContact()
{
    Console.Write("Enter contact name: ");
    string name = Console.ReadLine();
    Console.Write("Enter contact phone number: ");
    string phoneNumber = Console.ReadLine();

    using (MySqlConnection connection = new MySqlConnection("Server=localhost;Port=3306;Database=CSharpTest;User=root;Password=;"))
    {
        string query = "INSERT INTO contacts (Name, PhoneNumber) VALUES (@Name, @PhoneNumber)";
        MySqlCommand command = new MySqlCommand(query, connection);
        command.Parameters.AddWithValue("@Name", name);
        command.Parameters.AddWithValue("@PhoneNumber", phoneNumber);

        connection.Open();
        int result = command.ExecuteNonQuery();

        if (result > 0)
        {
            Console.WriteLine("Contact added successfully!\n");
        }
        else
        {
            Console.WriteLine("Failed to add contact.\n");
        }
    }
}

static void DisplayContacts()
{
    using (MySqlConnection connection = new MySqlConnection("Server=localhost;Port=3306;Database=CSharpTest;User=root;Password=;"))
    {
        string query = "SELECT Name, PhoneNumber FROM contacts";
        MySqlCommand command = new MySqlCommand(query, connection);

        connection.Open();
        using (MySqlDataReader reader = command.ExecuteReader())
        {
            Console.WriteLine("\tAddress Book\n");
            Console.WriteLine("Contact Name\tPhone Number");

            while (reader.Read())
            {
                Console.WriteLine($"{reader["Name"]}\t{reader["PhoneNumber"]}\n");
            }
        }
    }
}

static void FindContact()
{
    Console.Write("Enter name to find: ");
    string searchName = Console.ReadLine();

    using (MySqlConnection connection = new MySqlConnection("Server=localhost;Port=3306;Database=CSharpTest;User=root;Password=;"))
    {
        string query = "SELECT PhoneNumber FROM contacts WHERE Name = @Name";
        MySqlCommand command = new MySqlCommand(query, connection);
        command.Parameters.AddWithValue("@Name", searchName);

        connection.Open();
        var result = command.ExecuteScalar();

        if (result != null)
        {
            Console.WriteLine($"Phone number for {searchName}: {result}\n");
        }
        else
        {
            Console.WriteLine("Contact not found!\n");
        }
    }
}

    static void Main()
    {
        try
        {
            connection.Open();
            Console.WriteLine("Connected to MySQL Database");

            int option = 0;

            while (option != 4)
            {
                Console.WriteLine("Contact Manager Menu:");
                Console.WriteLine("1. Add new contact");
                Console.WriteLine("2. Find a contact by name");
                Console.WriteLine("3. Address book");
                Console.WriteLine("4. Exit");

                Console.Write("Enter your choice: ");
                option = Convert.ToInt32(Console.ReadLine());

                switch (option)
                {
                    case 1:
                        AddContact();
                        break;

                    case 2:
                        FindContact();
                        break;

                    case 3:
                        DisplayContacts();
                        break;

                    case 4:
                        Console.WriteLine("Exiting Contact Manager. Goodbye!");
                        break;

                    default:
                        Console.WriteLine("Invalid option. Please try again.\n");
                        break;
                }
            }
        }
        catch (Exception ex)
        {
            Console.WriteLine("Error: " + ex.Message);
        }
        finally
        {
            connection.Close();
        }
    }
}
// database

//CREATE DATABASE CSharpTest
//CREATE TABLE contacts (
 // id int(11) NOT NULL auto_increment,
 // Name varchar(50) NOT NULL,
//  PhoneNumber varchar(20) NOT NULL,
 // PRIMARY KEY (id)
//)
