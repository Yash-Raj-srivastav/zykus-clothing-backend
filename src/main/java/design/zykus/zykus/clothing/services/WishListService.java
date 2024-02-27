package design.zykus.zykus.clothing.services;

import design.zykus.zykus.clothing.entities.ProductInWishList;

import java.util.Set;

public interface WishListService {
    public Set<ProductInWishList> getWishListOfUser(Long userId);
    public void addProductToWishList(ProductInWishList productInWishList);
}
