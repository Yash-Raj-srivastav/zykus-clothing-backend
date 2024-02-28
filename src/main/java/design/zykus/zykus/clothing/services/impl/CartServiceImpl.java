package design.zykus.zykus.clothing.services.impl;

import design.zykus.zykus.clothing.dto.ProductInCartRequest;
import design.zykus.zykus.clothing.dto.ProductInCartResponse;
import design.zykus.zykus.clothing.dto.ProductInWishListResponse;
import design.zykus.zykus.clothing.dto.ProductResponse;
import design.zykus.zykus.clothing.entities.WebAppUser;
import design.zykus.zykus.clothing.repository.ProductRepository;
import design.zykus.zykus.clothing.repository.UserRepository;
import design.zykus.zykus.clothing.services.CartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;
    private static final Logger logger = LoggerFactory.getLogger(WishListServiceImpl.class);
    @Override
    public ProductInCartResponse getCartOfUser(Long userId) {
        Optional<WebAppUser> optionalUser = userRepository.findById(userId);
        ProductInCartResponse productInCartResponse = new ProductInCartResponse();
        try{
            if(optionalUser.isEmpty()) throw new RuntimeException("User does not exist!!");
            WebAppUser user = optionalUser.get();
            logger.info("User found: " + user);

            return setCartResponse(user, productInCartResponse, userId);
        }
        catch (Exception e){
            logger.error("An error occurred:", e);
        }
        return null;
    }

    @Override
    public ProductInCartResponse addProductToCart(ProductInCartRequest productInCartRequest) {
        return null;
    }

    @Override
    public ProductResponse deleteProductFromCart(ProductInCartRequest productInCartRequest) {
        return null;
    }

    public ProductInCartResponse setCartResponse(WebAppUser user, ProductInCartResponse productInCartResponse, Long userId){

        return productInCartResponse;
    }
}
