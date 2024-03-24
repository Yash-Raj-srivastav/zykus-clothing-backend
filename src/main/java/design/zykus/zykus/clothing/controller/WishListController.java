package design.zykus.zykus.clothing.controller;

import design.zykus.zykus.clothing.dto.ProductInWishListResponse;
import design.zykus.zykus.clothing.dto.ProductInWishListRequest;
import design.zykus.zykus.clothing.dto.ProductResponse;
import design.zykus.zykus.clothing.services.WishListService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/wishlist")
@RequiredArgsConstructor
public class WishListController {
    @Autowired
    private WishListService wishListService;
    @GetMapping("/get-wishlist")
    public ResponseEntity<ProductInWishListResponse> getWishList(@RequestParam Long userId){
        ProductInWishListResponse productInWishListResponse = wishListService.getWishListOfUser(userId);
        return ResponseEntity.ok(productInWishListResponse);
    }

    @PostMapping("/add-to-wishlist")
    public ResponseEntity<ProductResponse> addProductToWishList(@RequestBody ProductInWishListRequest productInWishList){
        ProductResponse addedProductToWishList = wishListService.addProductToWishList(productInWishList);
        return ResponseEntity.ok(addedProductToWishList);
    }

    @DeleteMapping("/remove-from-wishlist")
    public ResponseEntity<ProductResponse> deleteProductFromWishList(@RequestBody ProductInWishListRequest productInWishList){
        ProductResponse deletedProductFromWishList = wishListService.deleteProductFromWishList(productInWishList);
        return ResponseEntity.ok(deletedProductFromWishList);
    }
}
