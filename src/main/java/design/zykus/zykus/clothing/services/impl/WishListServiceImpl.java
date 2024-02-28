package design.zykus.zykus.clothing.services.impl;

import design.zykus.zykus.clothing.dto.ProductInWishListResponse;
import design.zykus.zykus.clothing.dto.ProductResponse;
import design.zykus.zykus.clothing.dto.UserResponse;
import design.zykus.zykus.clothing.entities.Product;
import design.zykus.zykus.clothing.dto.ProductInWishListRequest;
import design.zykus.zykus.clothing.entities.WebAppUser;
import design.zykus.zykus.clothing.repository.ProductRepository;
import design.zykus.zykus.clothing.repository.UserRepository;
import design.zykus.zykus.clothing.services.WishListService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class WishListServiceImpl implements WishListService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;
    private static final Logger logger = LoggerFactory.getLogger(WishListServiceImpl.class);

    @Override
    public ProductInWishListResponse getWishListOfUser(Long userId) {
        Optional<WebAppUser> optionalUser = userRepository.findById(userId);
        ProductInWishListResponse productInWishListResponse = new ProductInWishListResponse();
        try {
            if (optionalUser.isEmpty()) throw new RuntimeException("User does not exist!!");
            WebAppUser user = optionalUser.get();
            logger.info("User found: " + user);

            return setWishListResponse(user, productInWishListResponse, userId);
        } catch (Exception e) {
            logger.error("An error occurred:", e);
        }
        return productInWishListResponse;
    }

    @Override
    public ProductResponse addProductToWishList(ProductInWishListRequest productInWishList) {

        Optional<WebAppUser> optionalUser = userRepository.findById(productInWishList.getUserId());
        Optional<Product> optionalProduct = productRepository.findById(productInWishList.getProductId());
        try {
            if (optionalUser.isEmpty()) throw new RuntimeException("User does not exist!!");
            if (optionalProduct.isEmpty()) throw new RuntimeException("Product does not exist!!");

            logger.info("User found: " + optionalUser.get());
            logger.info("Product found: " + optionalProduct.get());

            WebAppUser user = optionalUser.get();
            Product product = optionalProduct.get();

            Set<ProductInWishListRequest> productInWishLists = user.getProductInWishList();
            productInWishLists.add(productInWishList);

            user.setProductInWishList(productInWishLists);
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
    public ProductResponse deleteProductFromWishList(ProductInWishListRequest productInWishList) {

        Optional<WebAppUser> optionalUser = userRepository.findById(productInWishList.getUserId());
        Optional<Product> optionalProduct = productRepository.findById(productInWishList.getProductId());
        try {
            if (optionalUser.isEmpty()) throw new RuntimeException("User does not exist!!");
            if (optionalProduct.isEmpty()) throw new RuntimeException("Product does not exist!!");

            logger.info("User found: " + optionalUser.get());
            logger.info("Product found: " + optionalProduct.get());

            WebAppUser user = optionalUser.get();
            Product product = optionalProduct.get();

            Set<ProductInWishListRequest> productInWishLists = user.getProductInWishList();

            if (productInWishLists.contains(productInWishList)) {
                productInWishLists.remove(productInWishList);
                user.setProductInWishList(productInWishLists);

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

    public ProductInWishListResponse setWishListResponse(WebAppUser user, ProductInWishListResponse productInWishListResponse, Long userId) {

        UserResponse userResponse = setUserResponse(user);
        productInWishListResponse.setUserResponse(userResponse);
        Set<ProductResponse> productResponses = new HashSet<>();
        for (ProductInWishListRequest productInWishList : user.getProductInWishList()) {
            Optional<Product> optionalProduct = productRepository.findById(productInWishList.getProductId());
            if (optionalProduct.isEmpty()) throw new RuntimeException("Product does not exist!!");
            logger.info("Product found: " + optionalProduct.get());

            Product product = optionalProduct.get();
            ProductResponse productResponse = setProductResponse(product);
            productResponses.add(productResponse);
            productInWishListResponse.setProductResponses(productResponses);
        }
        return productInWishListResponse;
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
