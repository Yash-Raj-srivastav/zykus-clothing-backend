package design.zykus.zykus.clothing.controller;

import design.zykus.zykus.clothing.entities.OrderItems;
import design.zykus.zykus.clothing.services.impl.OrderItemsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/order_items")
public class OrderItemsController {
    @Autowired
    private OrderItemsServiceImpl orderItemsService;

    @GetMapping("/")
    public Iterable<OrderItems> getAllOrderItems(){
        return this.orderItemsService.getAllOrderItems();
    }


    @GetMapping("/{id}")
    public ResponseEntity<OrderItems> getSingleOrderItems(@PathVariable("id") int id){
        return this.orderItemsService.getSingleOrderItems(id);
    }

    @PostMapping("/")
    public OrderItems addNewOrderItems(@RequestBody OrderItems orderItems){
        return this.orderItemsService.addNewOrderItems(orderItems);
    }

    @PostMapping("/add_multiple")
    public Iterable<OrderItems> addMultipleNewOrderItems(@RequestBody Iterable<OrderItems> multipleOrderItems){
        return this.orderItemsService.addMultipleNewUsers(multipleOrderItems);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderItems> updateExistingOrderItems(@RequestBody OrderItems orderItems, @PathVariable("id") int id){
        return this.orderItemsService.updateExistingOrderItems(orderItems, id);
    }
}
