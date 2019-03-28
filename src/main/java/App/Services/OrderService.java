package App.Services;

import App.Dao.OrderRepository;
import App.models.Order;
import App.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;


    private static List<Order> orders;

/*
   @PostConstruct
    public void init(){

        OrderService.orders= (List<Order>) orderRepository.findAll();

    }

    public static List<Product> getDetails(long id) {
        return  orders.stream().filter(order -> id==order.getId()).findFirst().get().getProductList();
    }

    public static void deleteProduct(long orderId, int productId) {
        getDetails(orderId).removeIf(product -> product.getId()==productId);

    }*/

}
