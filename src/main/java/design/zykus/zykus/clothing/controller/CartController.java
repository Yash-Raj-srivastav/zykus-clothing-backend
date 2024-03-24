package design.zykus.zykus.clothing.controller;

import design.zykus.zykus.clothing.dto.*;
import design.zykus.zykus.clothing.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/cart")
@RequiredArgsConstructor
public class CartController {
    @Autowired
    private CartService cartService;
    @GetMapping("/get-cart")
    public ResponseEntity<ProductInCartResponse> getCart(@RequestParam Long userId){
        ProductInCartResponse productInCartResponse = cartService.getCartOfUser(userId);
        return ResponseEntity.ok(productInCartResponse);
    }

    @PostMapping("/add-to-cart")
    public ResponseEntity<ProductResponse> addProductToCart(@RequestBody ProductInCartRequest productInCartRequest){
        ProductResponse addProductInCartResponse = cartService.addProductToCart(productInCartRequest);
        return ResponseEntity.ok(addProductInCartResponse);
    }

    @DeleteMapping("/remove-from-cart")
    public ResponseEntity<ProductResponse> deleteProductFromCart(@RequestBody ProductInCartRequest productInCartRequest){
        ProductResponse deletedProductFromWishList = cartService.deleteProductFromCart(productInCartRequest);
        return ResponseEntity.ok(deletedProductFromWishList);
    }
}
