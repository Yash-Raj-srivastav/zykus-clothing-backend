package design.zykus.zykus.clothing.services;

import design.zykus.zykus.clothing.dto.ProductInWishListResponse;
import design.zykus.zykus.clothing.dto.ProductInWishListRequest;
import design.zykus.zykus.clothing.dto.ProductResponse;

public interface WishListService {
    public ProductInWishListResponse getWishListOfUser(Long userId);
    public ProductResponse addProductToWishList(ProductInWishListRequest productInWishList);
    public ProductResponse deleteProductFromWishList(ProductInWishListRequest productInWishList);
}
