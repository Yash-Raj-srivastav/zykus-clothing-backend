package design.zykus.zykus.clothing.services.impl;

import design.zykus.zykus.clothing.repository.ShipmentRepository;
import design.zykus.zykus.clothing.entities.Shipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class ShipmentServiceImpl {
    @Autowired
    private ShipmentRepository shipmentRepository;

    public Iterable<Shipment> getAllShipment() {
        return this.shipmentRepository.findAll();
    }

    public ResponseEntity<Shipment> getSingleShipment(int id){
        return this.shipmentRepository.findById(id).
                map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    public Shipment addNewShipment(Shipment shipment){
        return shipmentRepository.save(shipment);
    }

    public Iterable<Shipment> addMultipleNewShipments(Iterable<Shipment> shipments){
        return shipmentRepository.saveAll(shipments);
    }

    public ResponseEntity<Shipment> updateExistingShipment(Shipment shipment, int id) {
        return shipmentRepository.findById(id)
                .map(existingShipment -> {
                    if (shipment.getShipment_tracking_number() != 0) existingShipment.setShipment_tracking_number(shipment.getShipment_tracking_number());
                    if (shipment.getOther_shipment_details() != null) existingShipment.setOther_shipment_details(shipment.getOther_shipment_details());
                    return ResponseEntity.ok(shipmentRepository.save(existingShipment));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Shipment> deleteExistingShipment(@PathVariable("shipmentId") int shipmentId){
        return shipmentRepository.findById(shipmentId)
                .map(existingProduct -> {
                    Shipment deletedProduct = null;
                    if(existingProduct.getShipment_id() == shipmentId){
                        deletedProduct = existingProduct;
                        shipmentRepository.deleteById(shipmentId);
                    }
                    return ResponseEntity.ok(deletedProduct);
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
