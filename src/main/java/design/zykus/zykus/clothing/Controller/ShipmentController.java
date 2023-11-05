package design.zykus.zykus.clothing.Controller;


import design.zykus.zykus.clothing.Entity.Shipment;
import design.zykus.zykus.clothing.Service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/shipments")
public class ShipmentController {

    @Autowired
    private ShipmentService shipmentService;

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

    @PutMapping("/{id}")
    public ResponseEntity<Shipment> updateExistingProduct(@RequestBody Shipment shipment, @PathVariable("id") int id){
        return this.shipmentService.updateExistingShipment(shipment, id);
    }
}
