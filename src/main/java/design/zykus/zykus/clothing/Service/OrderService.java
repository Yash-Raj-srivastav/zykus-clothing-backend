package design.zykus.zykus.clothing.Service;

import design.zykus.zykus.clothing.Model.OrdersRepository;
import design.zykus.zykus.clothing.Entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrdersRepository ordersRepository;

    // Get request for all orders
    public Iterable<Order> getAllOrders(){
        return ordersRepository.findAll();
    }

    // Get Request for single order
    public ResponseEntity<Order> getSingleOrder(int orderId){
        return ordersRepository.findById(orderId)
                .map(existingOrder -> ResponseEntity.ok(existingOrder))
                .orElse(ResponseEntity.notFound().build());
    }

    // Post Request for adding an order
    public Order addNewOrder(Order order){
        return ordersRepository.save(order);
    }

    public Iterable<Order> addMultipleNewUsers(Iterable<Order> orders){
        return ordersRepository.saveAll(orders);
    }

    // Put Request for modifying an existing order
    public ResponseEntity<Order> updateExistingOrder(Order order, int id){
        return ordersRepository.findById(id)
                .map(existingOrder -> {
                    if(order.getOrderDetails() != null) {
                        existingOrder.setOrderDetails(order.getOrderDetails());
                    }
                    if(order.getOrderStatusCode() != null){
                        existingOrder.setOrderStatusCode(order.getOrderStatusCode());
                    }
                    Order savedOrderDetails = ordersRepository.save(existingOrder);
                    return ResponseEntity.ok(savedOrderDetails);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Order> deleteExistingOrder(int orderId){
        return ordersRepository.findById(orderId)
                .map(existingOrder -> {
                    Order deletedOrder = null;
                    if(existingOrder.getOrderId() == orderId){
                        deletedOrder = existingOrder;
                        ordersRepository.deleteById(orderId);
                    }
                    return ResponseEntity.ok(deletedOrder);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
