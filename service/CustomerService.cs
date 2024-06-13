using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using ProjectManagement.model;
using MySql.Data.MySqlClient;

namespace ProjectManagement.service
{
    public class CustomerService : ICustomerService
    {
        private MySqlConnection connection;
        public CustomerService(string connectionString){
            connection = new MySqlConnection(connectionString);
        }
        void AddCustomer(Customer customer){}
        List<Customer> customers(){
            return null;
        }
        Customer GetCustomerById(int id){
            return null;
        }
        void UpdateCustomer(Customer customer){}
        void DeleteCustomer(int id){}
        
    }
}