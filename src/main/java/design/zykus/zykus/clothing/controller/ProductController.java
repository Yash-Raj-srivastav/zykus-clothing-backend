package design.zykus.zykus.clothing.controller;

import design.zykus.zykus.clothing.entities.Product;
import design.zykus.zykus.clothing.services.impl.ProductServiceImpl;
import design.zykus.zykus.clothing.utils.ProductSize;
import design.zykus.zykus.clothing.utils.ProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

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
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") Long id){
        return this.productService.getSingleProduct(id);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Product>> filter(
            @RequestParam(required = false) ProductType type,
            @RequestParam(required = false) ProductSize size,
            @RequestParam(required = false) Float minPrice,
            @RequestParam(required = false) Float maxPrice
    ){
        return productService.filter(type.toString(), size.toString(), minPrice, maxPrice);
    }

    @GetMapping("/sort_by_price")
    public List<Product> sortByPrice(){
        return productService.sortByPrice();
    }

    @GetMapping("/sort_by_rating")
    public List<Product> sortByRating(){
        return productService.sortByRating();
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
    public ResponseEntity<Product> updateExistingProduct(@RequestBody Product product, @PathVariable("id") Long id){
        return this.productService.updateExistingProduct(product, id);
    }
}
