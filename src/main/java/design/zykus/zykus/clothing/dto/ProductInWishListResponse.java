package design.zykus.zykus.clothing.dto;

import design.zykus.zykus.clothing.utils.ProductSize;
import design.zykus.zykus.clothing.utils.ProductStatus;
import design.zykus.zykus.clothing.utils.ProductType;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Data
@RequiredArgsConstructor
public class ProductInWishListResponse {
    private Long userId;
    private String userName;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String gender;
    private String address;
    private int pinCode;
    private String state;
    private String country;
    private Set<ProductInWishListRequest> productInWishList;
    // ---------------------
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
