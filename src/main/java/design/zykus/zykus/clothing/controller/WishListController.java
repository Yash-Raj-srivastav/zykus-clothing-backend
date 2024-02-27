package design.zykus.zykus.clothing.controller;

import design.zykus.zykus.clothing.entities.ProductInWishList;
import design.zykus.zykus.clothing.services.WishListService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/v2/wishlist")
@RequiredArgsConstructor
public class WishListController {
    @Autowired
    private WishListService wishListService;
    @GetMapping("/get-wishlist")
    public Set<ProductInWishList> getWishList(@RequestParam Long userId){
        return wishListService.getWishListOfUser(userId);
    }

    @PostMapping("/add-to-wishlist")
    public ResponseEntity<?> addProductToWishList(@RequestBody ProductInWishList productInWishList){
        wishListService.addProductToWishList(productInWishList);
        return ResponseEntity.ok().build();
    }
}
