package design.zykus.zykus.clothing.services;

import design.zykus.zykus.clothing.dto.ProductInCartRequest;
import design.zykus.zykus.clothing.dto.ProductInCartResponse;
import design.zykus.zykus.clothing.dto.ProductInWishListResponse;
import design.zykus.zykus.clothing.dto.ProductResponse;

public interface CartService {
    public ProductInCartResponse getCartOfUser(Long userId);
    public ProductResponse addProductToCart(ProductInCartRequest productInCartRequest);
    public ProductResponse deleteProductFromCart(ProductInCartRequest productInCartRequest);
}
