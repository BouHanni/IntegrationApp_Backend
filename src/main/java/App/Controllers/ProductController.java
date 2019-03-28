package App.Controllers;

import App.Services.ProductService;
import App.models.Product;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products/{id}")
    public ResponseEntity getProduct(@PathVariable("id") String qr )throws UnirestException {
        Product p=productService.getProductSummary(qr);
        return ResponseEntity.ok(productService.getProductSummary(qr));
    }

}
