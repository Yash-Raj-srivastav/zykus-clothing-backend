package design.zykus.zykus.clothing.DAO;

import design.zykus.zykus.clothing.Entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {
}
