package design.zykus.zykus.clothing.services.impl;

import design.zykus.zykus.clothing.repository.ProductRepository;
import design.zykus.zykus.clothing.entities.Product;
import design.zykus.zykus.clothing.services.ProductService;
import design.zykus.zykus.clothing.utils.ProductSize;
import design.zykus.zykus.clothing.utils.ProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    HashMap<Integer, ProductType> productTypeMap = new HashMap<>();

    public Iterable<Product> getAllProducts(){
        return this.productRepository.findAll();
    }

    public ResponseEntity<Product> getSingleProduct(Long id){
        return this.productRepository.findById(id).
                map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    public Product addNewProduct(Product product){
        return productRepository.save(product);
    }

    public Iterable<Product> addMultipleNewProducts(Iterable<Product> products){
        return this.productRepository.saveAll(products);
    }

    public ResponseEntity<Product> updateExistingProduct(Product product, Long orderId){
        return productRepository.findById(orderId)
                .map(existingProduct -> {
                    // Update only the non-null fields from the updatedUser
                    if (product.getProductType() != null) {
                        existingProduct.setProductType(product.getProductType());
                    }
                    if (product.getName() != null) {
                        existingProduct.setName(product.getName());
                    }
                    if(product.getColor() != null){
                        existingProduct.setColor(product.getColor());
                    }
                    if(product.getSize() == ProductSize.SMALL || product.getSize() == ProductSize.MEDIUM || product.getSize() == ProductSize.LARGE || product.getSize() == ProductSize.EXTRA_LARGE){
                        existingProduct.setSize(product.getSize());
                    }
                    if(product.getPrice() >= 1000){
                        existingProduct.setPrice(product.getPrice());
                    }
                    if(product.getProductDescription() != null){
                        existingProduct.setProductDescription(product.getProductDescription());
                    }
                    if(product.getRating() > 0 && product.getRating() <= 5){
                        int calcRating = (existingProduct.getRating() + product.getRating()) / 5;
                        existingProduct.setRating(calcRating);
                    }
                    Product savedProduct = productRepository.save(existingProduct);
                    return ResponseEntity.ok(savedProduct);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Product> deleteExistingProduct(Long productId){
        return productRepository.findById(productId)
                .map(existingProduct -> {
                    Product deletedProduct = null;
                    if(existingProduct.getProductId() == productId){
                        deletedProduct = existingProduct;
                        productRepository.deleteById(productId);
                    }
                    return ResponseEntity.ok(deletedProduct);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<List<Product>> filter(String type, String size, Float minPrice, Float maxPrice) {
        List<Product> list = productRepository.filter(type, size, minPrice, maxPrice);
        return ResponseEntity.ok(list);
    }

    @Override
    public List<Product> sortByPrice() {
        return productRepository.sortByPrice();
    }

    @Override
    public List<Product> sortByRating() {
        return productRepository.sortByRating();
    }
}
