package design.zykus.zykus.clothing.Entity;

import design.zykus.zykus.clothing.Utils.ProductType;
import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;
    private ProductType productType;
    private String color;
    private String name;
    private String size;
    private float price;
    private String productDescription;
    public Product(){}

    public Product(int productId, ProductType productType, String color, String name, String size, float price, String productDescription) {
        this.productId = productId;
        this.productType = productType;
        this.color = color;
        this.name = name;
        this.size = size;
        this.price = price;
        this.productDescription = productDescription;
    }

    public int getProductId() {
        return productId;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
}
