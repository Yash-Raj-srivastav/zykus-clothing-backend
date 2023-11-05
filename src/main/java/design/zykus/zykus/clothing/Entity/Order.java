package design.zykus.zykus.clothing.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;
    private int userId;
    private String orderStatusCode;
    private LocalDate dateOrderPlaced;
    private String orderDetails;

    public Order(){

    }
    public Order(int orderId, int userId, String orderStatusCode, LocalDate dateOrderPlaced, String orderDetails) {
        this.orderId = orderId;
        this.userId = userId;
        this.orderStatusCode = orderStatusCode;
        this.dateOrderPlaced = dateOrderPlaced;
        this.orderDetails = orderDetails;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getOrderStatusCode() {
        return orderStatusCode;
    }

    public void setOrderStatusCode(String orderStatusCode) {
        this.orderStatusCode = orderStatusCode;
    }

    public LocalDate getDateOrderPlaced() {
        return dateOrderPlaced;
    }

    public void setDateOrderPlaced(LocalDate dateOrderPlaced) {
        this.dateOrderPlaced = dateOrderPlaced;
    }

    public String getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", orderStatusCode='" + orderStatusCode + '\'' +
                ", dateOrderPlaced=" + dateOrderPlaced +
                ", orderDetails='" + orderDetails + '\'' +
                '}';
    }
}
