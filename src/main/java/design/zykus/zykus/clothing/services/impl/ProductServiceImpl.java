package design.zykus.zykus.clothing.services.impl;

import design.zykus.zykus.clothing.repository.ProductRepository;
import design.zykus.zykus.clothing.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class ProductServiceImpl {

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

    public Iterable<Product> addMultipleNewProducts(Iterable<Product> products){
        return this.productRepository.saveAll(products);
    }

    public ResponseEntity<Product> updateExistingProduct(Product product, int orderId){
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

    public ResponseEntity<Product> deleteExistingProduct(@PathVariable("invoiceNumber") int productId){
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
}
