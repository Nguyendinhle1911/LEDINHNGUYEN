using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using MySql.Data.MySqlClient;
using ProjectManagement.model;

namespace ProjectManagement.service
{
    public class ProductService : IProductService
    {
        private MySqlConnection connection;
        public ProductService(string connectionString){
            connection = new MySqlConnection(connectionString);
        }
        public void AddProduct(Product product){
            connection.Open();
            MySqlCommand cmd = connection.CreateCommand();
            cmd.CommandText = "insert into products(name,price,description) values(@Name,@Price,@Description)";
            cmd.Parameters.AddWithValue("@Name",product.Name);
            cmd.Parameters.AddWithValue("@Price",product.Price);
            cmd.Parameters.AddWithValue("@Description",product.Description);
            cmd.ExecuteNonQuery();
            connection.Close();

        }
        public List<Product> GetAllProducts(){
            return null;
        }
        public Product GetProductById(int id){
            return null;
        }
        public void UpdateProduct(Product product){}
        public void DeleteProduct(int id){}
    }
}