package design.zykus.zykus.clothing.controller;


import design.zykus.zykus.clothing.entities.Shipment;
import design.zykus.zykus.clothing.services.impl.ShipmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/shipments")
public class ShipmentController {

    @Autowired
    private ShipmentServiceImpl shipmentService;

    @GetMapping("/")
    public Iterable<Shipment> getAllShipments(){
        return this.shipmentService.getAllShipment();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Shipment> getSingleProduct(@PathVariable("id") int id){
        return this.shipmentService.getSingleShipment(id);
    }

    @PostMapping("/")
    public Shipment addNewProduct(@RequestBody Shipment shipment){
        return this.shipmentService.addNewShipment(shipment);
    }

    @PostMapping("/add_multiple")
    public Iterable<Shipment> addMultipleNewShipments(@RequestBody Iterable<Shipment> shipments){
        return this.shipmentService.addMultipleNewShipments(shipments);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Shipment> updateExistingProduct(@RequestBody Shipment shipment, @PathVariable("id") int id){
        return this.shipmentService.updateExistingShipment(shipment, id);
    }
}
