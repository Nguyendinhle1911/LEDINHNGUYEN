using System;
using System.Globalization;
using MySql.Data.MySqlClient;

namespace ProjectManagement
{
    class Program
    {
        static string connectionString = "Server=127.0.0.1;Database=prodb;User Id=root;Password=;";

        public static void Main(string[] args)
        {
            while (true)
            {
                Console.WriteLine("Product Management");
                Console.WriteLine("1. Add Product");
                Console.WriteLine("2. Display All Products");
                Console.WriteLine("3. Update Product");
                Console.WriteLine("4. Delete Product");
                Console.WriteLine("5. Exit");
                Console.WriteLine("Choose an option: ");
                string choice = Console.ReadLine();
                switch (choice)
                {
                    case "1":
                        AddProduct();
                        break;
                    case "2":
                        DisplayAllProducts();
                        break;
                    case "3":
                        UpdateProduct();
                        break;
                    case "4":
                        DeleteProduct();
                        break;
                    case "5":
                        return;
                    default:
                        Console.WriteLine("Invalid choice, please try again");
                        break;
                }
            }
        }

        static void AddProduct()
        {
            Product product = new Product();
            Console.WriteLine("Enter Product Name: ");
            product.Name = Console.ReadLine();
            Console.WriteLine("Enter Product Price: ");
            product.Price = Convert.ToDecimal(Console.ReadLine());
            Console.WriteLine("Enter Product Description: ");
            product.Description = Console.ReadLine();

            using (MySqlConnection db = new MySqlConnection(connectionString))
            {
                db.Open();
                string sqlQuery = "INSERT INTO products(name, price, description) VALUES(@Name, @Price, @Description)";
                using (MySqlCommand cmd = new MySqlCommand(sqlQuery, db))
                {
                    cmd.Parameters.AddWithValue("@Name", product.Name);
                    cmd.Parameters.AddWithValue("@Price", product.Price);
                    cmd.Parameters.AddWithValue("@Description", product.Description);
                    cmd.ExecuteNonQuery();
                    Console.WriteLine("Product added successfully!");
                }
            }
        }

        static void DisplayAllProducts()
        {
            using (MySqlConnection db = new MySqlConnection(connectionString))
            {
                db.Open();
                string sqlQuery = "SELECT * FROM products";
                using (MySqlCommand cmd = new MySqlCommand(sqlQuery, db))
                {
                    using (MySqlDataReader reader = cmd.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            Console.WriteLine($"ID: {reader["id"]}, Name: {reader["name"]}, Price: {reader["price"]}, Description: {reader["description"]}");
                        }
                    }
                }
            }
        }

        static void UpdateProduct()
        {
            Console.WriteLine("Enter Product ID to update: ");
            int productId = Convert.ToInt32(Console.ReadLine());

            Console.WriteLine("Enter New Product Name: ");
            string newName = Console.ReadLine();
            Console.WriteLine("Enter New Product Price: ");
            decimal newPrice = Convert.ToDecimal(Console.ReadLine());
            Console.WriteLine("Enter New Product Description: ");
            string newDescription = Console.ReadLine();

            using (MySqlConnection db = new MySqlConnection(connectionString))
            {
                db.Open();
                string sqlQuery = "UPDATE products SET name = @Name, price = @Price, description = @Description WHERE id = @Id";
                using (MySqlCommand cmd = new MySqlCommand(sqlQuery, db))
                {
                    cmd.Parameters.AddWithValue("@Name", newName);
                    cmd.Parameters.AddWithValue("@Price", newPrice);
                    cmd.Parameters.AddWithValue("@Description", newDescription);
                    cmd.Parameters.AddWithValue("@Id", productId);
                    int rowsAffected = cmd.ExecuteNonQuery();
                    if (rowsAffected > 0)
                    {
                        Console.WriteLine("Product updated successfully!");
                    }
                    else
                    {
                        Console.WriteLine("Product not found!");
                    }
                }
            }
        }

        static void DeleteProduct()
        {
            Console.WriteLine("Enter Product ID to delete: ");
            int productId = Convert.ToInt32(Console.ReadLine());

            using (MySqlConnection db = new MySqlConnection(connectionString))
            {
                db.Open();
                string sqlQuery = "DELETE FROM products WHERE id = @ProductId";
                using (MySqlCommand cmd = new MySqlCommand(sqlQuery, db))
                {
                    cmd.Parameters.AddWithValue("@ProductId", productId);
                    int rowsAffected = cmd.ExecuteNonQuery();
                    if (rowsAffected > 0)
                    {
                        Console.WriteLine("Product deleted successfully!");
                    }
                    else
                    {
                        Console.WriteLine("Product not found!");
                    }
                }
            }
        }
    }

    public class Product
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public decimal Price { get; set; }
        public string Description { get; set; }
    }
}
