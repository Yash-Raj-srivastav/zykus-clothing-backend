package design.zykus.zykus.clothing.services;

import design.zykus.zykus.clothing.dto.ProductInWishListResponse;
import design.zykus.zykus.clothing.dto.ProductInWishListRequest;

public interface WishListService {
    public ProductInWishListResponse getWishListOfUser(Long userId);
    public ProductInWishListRequest addProductToWishList(ProductInWishListRequest productInWishList);
    public ProductInWishListRequest deleteProductFromWishList(ProductInWishListRequest productInWishList);
}
