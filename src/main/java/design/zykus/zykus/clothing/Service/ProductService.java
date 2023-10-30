package design.zykus.zykus.clothing.Service;

import design.zykus.zykus.clothing.DAO.ProductRepository;
import design.zykus.zykus.clothing.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Iterable<Product> getAllProducts(){
        return this.productRepository.findAll();
    }

    public ResponseEntity<Product> getSingleProduct(int id){
        return this.productRepository.findById(id).
                map(existingProduct -> ResponseEntity.ok(existingProduct))
                .orElse(ResponseEntity.notFound().build());
    }

    public Product addNewProduct(Product product){
        return productRepository.save(product);
    }

    public ResponseEntity<Product> updateExistingProduct(Product product, int id){
        return productRepository.findById(id)
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
                    if(product.getSize() == "S" || product.getSize() == "M" || product.getSize() == "L" || product.getSize() == "XL"){
                        existingProduct.setSize(product.getSize());
                    }
                    if(product.getPrice() >= 1000){
                        existingProduct.setPrice(product.getPrice());
                    }
                    if(product.getProductDescription() != null){
                        existingProduct.setProductDescription(product.getProductDescription());
                    }
                    Product savedProduct = productRepository.save(existingProduct);
                    return ResponseEntity.ok(savedProduct);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
