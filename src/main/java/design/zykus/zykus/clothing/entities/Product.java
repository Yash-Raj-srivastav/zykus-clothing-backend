package design.zykus.zykus.clothing.entities;

import design.zykus.zykus.clothing.utils.ProductSize;
import design.zykus.zykus.clothing.utils.ProductStatus;
import design.zykus.zykus.clothing.utils.ProductType;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;
    @Enumerated(EnumType.STRING)
    private ProductType productType;
    private String color;
    private String name;
    @Enumerated(EnumType.STRING)
    private ProductSize size;
    private float price;
    private String productDescription;
    private int rating;
    @Enumerated(EnumType.STRING)
    private ProductStatus productStatus;
}
