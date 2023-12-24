package design.zykus.zykus.clothing.repository;

import design.zykus.zykus.clothing.entities.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Integer> {

}
