using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using MySql.Data.MySqlClient;
using ProjectManagement.model;

namespace ProjectManagement.service
{
    public class OrderService : IOderService
    {
        private MySqlConnection connection;
        public OrderService(string connectionString){
            connection = new MySqlConnection(connectionString);
        }
         void AddOrder(Order order){
            connection.Open();
            MySqlCommand cmd = connection.CreateCommand();
            //Tao giao dich moi
            MySqlTransaction transaction = connection.BeginTransaction();
            //Thuc hien code them don hang moi
            //...
            cmd.CommandText="insert into orders(customer_idm order_date) values(@CustomerId,@OrderDate)"; 
            cmd.Parameters.AddWithValue("@CustomerId",order.CustomerId);
            cmd.Parameters.AddWithValue("@OderDate",order.OrderDate);
            cmd.ExecuteNonQuery();
            int orderId = (int)cmd.LastInsertedId;//lay ra id moi nhat vua duoc Add o cau lenh insert tren
            foreach(var detail in order.OrderDetails){
                cmd.CommandText = "insert into order_details(order_id,product_id,quantity) values(@OrderId,ProductId,@Quantity)";
                cmd.Parameters.AddWithValue("@OrderId",orderId);
                cmd.Parameters.AddWithValue("@ProductId",detail.ProductId);
                cmd.Parameters.AddWithValue("@Quantity",detail.Quantity);
                cmd.ExecuteNonQuery();
            }

            //Ket thuc giao dich
            transaction.Commit();
            connection.Close();

         }
        List<Order> GetAllOrder(){
            return null;
        }
        Order GetOrderById(int id){
            return null;
        }
        
    }
}