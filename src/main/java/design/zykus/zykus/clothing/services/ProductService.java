package design.zykus.zykus.clothing.services;

import design.zykus.zykus.clothing.entities.Product;
import design.zykus.zykus.clothing.utils.ProductSize;
import design.zykus.zykus.clothing.utils.ProductType;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

    ResponseEntity<List<Product>> filter(String type, String size, Float minPrice, Float maxPrice);
    List<Product> sortByPrice();
    List<Product> sortByRating();
}
