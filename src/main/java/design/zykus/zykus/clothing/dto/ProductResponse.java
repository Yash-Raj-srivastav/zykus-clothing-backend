package design.zykus.zykus.clothing.dto;

import design.zykus.zykus.clothing.utils.ProductSize;
import design.zykus.zykus.clothing.utils.ProductStatus;
import design.zykus.zykus.clothing.utils.ProductType;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ProductResponse {
    private Long productId;
    private ProductType productType;
    private String color;
    private String name;
    private ProductSize size;
    private float price;
    private String productDescription;
    private int rating;
    private ProductStatus productStatus;
}
