using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Mysqlx.Crud;
using ProjectManagement.model;

namespace ProjectManagement.service
{
    public interface IOderService
    {
        void AddOrder(Order order);
        List<Order> GetAllOrder();
        Order GetOrderById(int id);
    }
}