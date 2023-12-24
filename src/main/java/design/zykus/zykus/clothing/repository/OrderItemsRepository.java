package design.zykus.zykus.clothing.repository;

import design.zykus.zykus.clothing.entities.OrderItems;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItems, Integer> {
}
