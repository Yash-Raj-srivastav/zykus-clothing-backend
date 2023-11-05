package design.zykus.zykus.clothing.DAO;

import design.zykus.zykus.clothing.Entity.Product;
import design.zykus.zykus.clothing.Entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Integer> {

}
