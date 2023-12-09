package design.zykus.zykus.clothing.Entity;

import design.zykus.zykus.clothing.Utils.OrderStatus;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "order_items")
public class OrderItems {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderItemId;
    private int productId;
    private int orderId;
    private OrderStatus orderItemStatusCode;
    private int orderItemQuantity;
    private int orderItemPrice;
    private int rmaNumber;
    private String rmaIssuedBy;
    private LocalDate rmaIssuedDate;
    private String otherOrderItemDetail;

    public OrderItems(){};

    public OrderItems(int orderItemId, int productId, int orderId, OrderStatus orderItemStatusCode, int orderItemQuantity, int orderItemPrice, int rmaNumber, String rmaIssuedBy, LocalDate rmaIssuedDate, String otherOrderItemDetail) {
        this.orderItemId = orderItemId;
        this.productId = productId;
        this.orderId = orderId;
        this.orderItemStatusCode = orderItemStatusCode;
        this.orderItemQuantity = orderItemQuantity;
        this.orderItemPrice = orderItemPrice;
        this.rmaNumber = rmaNumber;
        this.rmaIssuedBy = rmaIssuedBy;
        this.rmaIssuedDate = rmaIssuedDate;
        this.otherOrderItemDetail = otherOrderItemDetail;
    }

    public int getOrderItemId() {
        return orderItemId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public OrderStatus getOrderItemStatusCode() {
        return orderItemStatusCode;
    }

    public void setOrderItemStatusCode(OrderStatus orderItemStatusCode) {
        this.orderItemStatusCode = orderItemStatusCode;
    }

    public int getOrderItemQuantity() {
        return orderItemQuantity;
    }

    public void setOrderItemQuantity(int orderItemQuantity) {
        this.orderItemQuantity = orderItemQuantity;
    }

    public int getOrderItemPrice() {
        return orderItemPrice;
    }

    public void setOrderItemPrice(int orderItemPrice) {
        this.orderItemPrice = orderItemPrice;
    }

    public int getRmaNumber() {
        return rmaNumber;
    }

    public void setRmaNumber(int rmaNumber) {
        this.rmaNumber = rmaNumber;
    }

    public String getRmaIssuedBy() {
        return rmaIssuedBy;
    }

    public void setRmaIssuedBy(String rmaIssuedBy) {
        this.rmaIssuedBy = rmaIssuedBy;
    }

    public LocalDate getRmaIssuedDate() {
        return rmaIssuedDate;
    }

    public void setRmaIssuedDate(LocalDate rmaIssuedDate) {
        this.rmaIssuedDate = rmaIssuedDate;
    }

    public String getOtherOrderItemDetail() {
        return otherOrderItemDetail;
    }

    public void setOtherOrderItemDetail(String otherOrderItemDetail) {
        this.otherOrderItemDetail = otherOrderItemDetail;
    }

    @Override
    public String toString() {
        return "OrderItems{" +
                "orderItemId=" + orderItemId +
                ", productId=" + productId +
                ", orderId=" + orderId +
                ", orderItemStatusCode='" + orderItemStatusCode + '\'' +
                ", orderItemQuantity=" + orderItemQuantity +
                ", orderItemPrice=" + orderItemPrice +
                ", rmaNumber=" + rmaNumber +
                ", rmaIssuedBy='" + rmaIssuedBy + '\'' +
                ", rmaIssuedDate=" + rmaIssuedDate +
                ", otherOrderItemDetail='" + otherOrderItemDetail + '\'' +
                '}';
    }
}
