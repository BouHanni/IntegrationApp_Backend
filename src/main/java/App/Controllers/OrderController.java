package App.Controllers;

import App.Dao.OrderRepository;
import App.Services.OrderService;
import App.models.Order;
import App.models.Product;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderService orderService;


    @GetMapping("/{id}/save")
    public ResponseEntity saveOrder(@PathVariable String id, @RequestParam("email") String email, @RequestParam("product")List <Product> products) {
        return ResponseEntity.ok(orderRepository.save(new Order(Long.parseLong(id),products,email)));
    }


    /*@GetMapping("/{id}")
    public ResponseEntity getDetails(@PathVariable String id) throws UnirestException {
        return ResponseEntity.ok(OrderService.getDetails(Long.parseLong(id)));
    }

    @GetMapping("/{orderId}/remove/{productId}")
    public ResponseEntity removeProduct(@PathVariable String orderId,@PathVariable String productId) throws UnirestException {
        orderService.deleteProduct(Long.parseLong(orderId),Integer.parseInt(productId));
        return ResponseEntity.ok("product successfully removed from your cart");
    }*/


}

