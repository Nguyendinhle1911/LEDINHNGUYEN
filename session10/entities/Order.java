package SESSION.session10.entities;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderId;
    private Customer customer;
    private List<OrderDetai> orderDetails;

    public Order(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.orderDetails = new ArrayList<>();
    }

    // Getters and Setters
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderDetai> getOrderDetails() {
        return orderDetails;
    }

    public void addOrderDetail(OrderDetai orderDetail) {
        this.orderDetails.add(orderDetail);
    }

    public void removeOrderDetail(OrderDetai orderDetail) {
        this.orderDetails.remove(orderDetail);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customer=" + customer +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
