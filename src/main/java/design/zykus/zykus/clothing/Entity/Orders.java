package design.zykus.zykus.clothing.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;
    private int userId;
    private String order_status_code;
    private LocalDate date_order_placed;
    private String order_details;

    public Orders(int orderId, int userId, String order_status_code, LocalDate date_order_placed, String order_details) {
        this.orderId = orderId;
        this.userId = userId;
        this.order_status_code = order_status_code;
        this.date_order_placed = date_order_placed;
        this.order_details = order_details;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getUserId() {
        return userId;
    }

    public String getOrder_status_code() {
        return order_status_code;
    }

    public void setOrder_status_code(String order_status_code) {
        this.order_status_code = order_status_code;
    }

    public LocalDate getDate_order_placed() {
        return date_order_placed;
    }

    public void setDate_order_placed(LocalDate date_order_placed) {
        this.date_order_placed = date_order_placed;
    }

    public String getOrder_details() {
        return order_details;
    }

    public void setOrder_details(String order_details) {
        this.order_details = order_details;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", order_status_code='" + order_status_code + '\'' +
                ", date_order_placed=" + date_order_placed +
                ", order_details='" + order_details + '\'' +
                '}';
    }
}
