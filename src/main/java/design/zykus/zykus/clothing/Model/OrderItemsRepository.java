package design.zykus.zykus.clothing.Model;

import design.zykus.zykus.clothing.Entity.OrderItems;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItems, Integer> {
}
