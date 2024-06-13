using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using ProjectManagement.model;

namespace ProjectManagement.service{

    public interface ICustomerService
    {
        void AddCustomer(Customer customer);
        List<Customer> customers();
        Customer GetCustomerById(int id);
        void UpdateCustomer(Customer customer);
        void DeleteCustomer(int id);

        
    }
}