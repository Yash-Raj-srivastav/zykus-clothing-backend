package design.zykus.zykus.clothing.controller;

import design.zykus.zykus.clothing.entities.Product;
import design.zykus.zykus.clothing.services.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/products")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

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

    @PostMapping("/add_multiple")
    public Iterable<Product> addMultipleNewUsers(@RequestBody Iterable<Product> products){
        return this.productService.addMultipleNewProducts(products);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateExistingProduct(@RequestBody Product product, @PathVariable("id") int id){
        return this.productService.updateExistingProduct(product, id);
    }
}
