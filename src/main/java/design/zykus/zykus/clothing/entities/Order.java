package design.zykus.zykus.clothing.entities;

import design.zykus.zykus.clothing.utils.OrderStatus;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;
    @JoinTable(
            name = "orders",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "userId"),
            inverseJoinColumns = @JoinColumn(
                    name = "order_id", referencedColumnName = "orderId"
            )
    )
    private int userId;
    private OrderStatus orderStatusCode;
    private LocalDate dateOrderPlaced;
    private String orderDetails;

    public Order(){

    }
    public Order(int orderId, int userId, OrderStatus orderStatusCode, LocalDate dateOrderPlaced, String orderDetails) {
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

    public OrderStatus getOrderStatusCode() {
        return orderStatusCode;
    }

    public void setOrderStatusCode(OrderStatus orderStatusCode) {
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
