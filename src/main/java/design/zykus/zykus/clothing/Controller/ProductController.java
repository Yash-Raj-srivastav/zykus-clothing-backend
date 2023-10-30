package design.zykus.zykus.clothing.Controller;

import design.zykus.zykus.clothing.Entity.Product;
import design.zykus.zykus.clothing.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public Iterable<Product> getAllProducts(){
        return this.productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") int id){
        return this.productService.getSingleProduct(id);
    }

    @PostMapping("/")
    public Product addNewProduct(@RequestBody Product product){
        return this.productService.addNewProduct(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateExistingProduct(@RequestBody Product product, @PathVariable("id") int id){
        return this.productService.updateExistingProduct(product, id);
    }
}
