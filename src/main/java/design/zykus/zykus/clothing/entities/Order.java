package design.zykus.zykus.clothing.entities;

import design.zykus.zykus.clothing.utils.OrderStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@RequiredArgsConstructor
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
}
