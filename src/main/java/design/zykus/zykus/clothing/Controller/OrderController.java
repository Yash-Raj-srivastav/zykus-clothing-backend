package design.zykus.zykus.clothing.Controller;

import design.zykus.zykus.clothing.Entity.Order;
import design.zykus.zykus.clothing.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/")
    public Iterable<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getSingleOrder(@PathVariable("id") int orderId){
        return orderService.getSingleOrder(orderId);
    }

    @PostMapping("/")
    public Order addNewOrder(@RequestBody Order order){
        return orderService.addNewOrder(order);
    }

    @PostMapping("/add_multiple")
    public Iterable<Order> addMultipleNewOrders(@RequestBody Iterable<Order> orders){
        return this.orderService.addMultipleNewUsers(orders);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateExistingOrder(@RequestBody Order order, @PathVariable("id") int orderId){
        return orderService.updateExistingOrder(order, orderId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Order> deleteExistingOrder(@PathVariable("id") int orderId){
        return orderService.deleteExistingOrder(orderId);
    }
}
