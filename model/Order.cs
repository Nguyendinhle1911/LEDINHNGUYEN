using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ProjectManagement.model.OrderDetail
{
    public class Order
    {
        public int Id { get; set; }
        public int CustomerId { get; set; }
        public DateTime OrderDate { get; set; }
        public List<OrderDetail> OrderDetails { get; set; }

        public Order()
        {
            OrderDetails = new List<OrderDetail>();
        }
    }

    public class OrderDetail
    {
        public int ProductId { get; set; }
        public int Quantity { get; set; }
        public decimal UnitPrice { get; set; }
    }
}