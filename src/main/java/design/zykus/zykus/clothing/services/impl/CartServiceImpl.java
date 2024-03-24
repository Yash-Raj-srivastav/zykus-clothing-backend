package design.zykus.zykus.clothing.services.impl;

import design.zykus.zykus.clothing.dto.*;
import design.zykus.zykus.clothing.entities.Product;
import design.zykus.zykus.clothing.entities.WebAppUser;
import design.zykus.zykus.clothing.repository.ProductRepository;
import design.zykus.zykus.clothing.repository.UserRepository;
import design.zykus.zykus.clothing.services.CartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;
    private static final Logger logger = LoggerFactory.getLogger(CartServiceImpl.class);
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
    public ProductResponse addProductToCart(ProductInCartRequest productInCartRequest) {
        Optional<WebAppUser> optionalUser = userRepository.findById(productInCartRequest.getUserId());
        Optional<Product> optionalProduct = productRepository.findById(productInCartRequest.getProductId());
        try {
            if (optionalUser.isEmpty()) throw new RuntimeException("User does not exist!!");
            if (optionalProduct.isEmpty()) throw new RuntimeException("Product does not exist!!");

            logger.info("User found: " + optionalUser.get());
            logger.info("Product found: " + optionalProduct.get());

            WebAppUser user = optionalUser.get();
            Product product = optionalProduct.get();

            Set<ProductInCartRequest> productInCarts = user.getProductInCart();
            productInCarts.add(productInCartRequest);

            user.setProductInCart(productInCarts);
            logger.info("Product added to the wishlist");

            ProductResponse productResponse = setProductResponse(product);
            userRepository.save(user);

            return productResponse;

        } catch (Exception e) {
            logger.error("An error occurred:", e);
        }
        return null;
    }

    @Override
    public ProductResponse deleteProductFromCart(ProductInCartRequest productInCartRequest) {
        Optional<WebAppUser> optionalUser = userRepository.findById(productInCartRequest.getUserId());
        Optional<Product> optionalProduct = productRepository.findById(productInCartRequest.getProductId());
        try {
            if (optionalUser.isEmpty()) throw new RuntimeException("User does not exist!!");
            if (optionalProduct.isEmpty()) throw new RuntimeException("Product does not exist!!");

            logger.info("User found: " + optionalUser.get());
            logger.info("Product found: " + optionalProduct.get());

            WebAppUser user = optionalUser.get();
            Product product = optionalProduct.get();

            Set<ProductInCartRequest> productInCarts = user.getProductInCart();

            if (productInCarts.contains(productInCartRequest)) {
                productInCarts.remove(productInCartRequest);
                user.setProductInCart(productInCarts);

                logger.info("Product removed from the wishlist");
                ProductResponse productResponse = setProductResponse(product);

                userRepository.save(user);
                return productResponse;
            } else {
                logger.info("Product not found in the wishlist");
                return null;
            }
        } catch (Exception e) {
            logger.error("An error occurred:", e);
        }
        return null;
    }

    public ProductInCartResponse setCartResponse(WebAppUser user, ProductInCartResponse productInCartResponse, Long userId){
        UserResponse userResponse = setUserResponse(user);
        productInCartResponse.setUserResponse(userResponse);
        Set<ProductResponse> productResponses = new HashSet<>();
        for (ProductInCartRequest productInCartRequest : user.getProductInCart()) {
            Optional<Product> optionalProduct = productRepository.findById(productInCartRequest.getProductId());
            if (optionalProduct.isEmpty()) throw new RuntimeException("Product does not exist!!");
            logger.info("Product found: " + optionalProduct.get());

            Product product = optionalProduct.get();
            ProductResponse productResponse = setProductResponse(product);
            productResponses.add(productResponse);
            productInCartResponse.setProductResponses(productResponses);
        }
        return productInCartResponse;
    }

    public UserResponse setUserResponse(WebAppUser user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setUserId(user.getUserId());
        userResponse.setUserName(user.getUsername());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setMiddleName(user.getMiddleName());
        userResponse.setLastName(user.getLastName());
        userResponse.setEmail(user.getEmail());
        userResponse.setGender(user.getGender());
        userResponse.setAddress(user.getAddress());
        userResponse.setPinCode(user.getPinCode());
        userResponse.setState(user.getState());
        userResponse.setCountry(user.getCountry());
        return userResponse;
    }

    public ProductResponse setProductResponse(Product product) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setProductId(product.getProductId());
        productResponse.setProductType(product.getProductType());
        productResponse.setColor(product.getColor());
        productResponse.setName(product.getName());
        productResponse.setSize(product.getSize());
        productResponse.setPrice(product.getPrice());
        productResponse.setProductDescription(product.getProductDescription());
        productResponse.setRating(product.getRating());
        productResponse.setProductStatus(product.getProductStatus());
        return productResponse;
    }
}
