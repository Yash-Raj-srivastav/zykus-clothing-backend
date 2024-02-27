package design.zykus.zykus.clothing.services.impl;

import design.zykus.zykus.clothing.dto.ProductInWishListResponse;
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

            productInWishListResponse.setUserId(userId);
            productInWishListResponse.setUserName(user.getUsername());
            productInWishListResponse.setFirstName(user.getFirstName());
            productInWishListResponse.setMiddleName(user.getMiddleName());
            productInWishListResponse.setLastName(user.getLastName());
            productInWishListResponse.setEmail(user.getEmail());
            productInWishListResponse.setGender(user.getGender());
            productInWishListResponse.setAddress(user.getAddress());
            productInWishListResponse.setPinCode(user.getPinCode());
            productInWishListResponse.setState(user.getState());
            productInWishListResponse.setCountry(user.getCountry());
            productInWishListResponse.setProductInWishList(user.getProductInWishList());

            for(ProductInWishListRequest productInWishList : user.getProductInWishList()){
                Optional<Product> optionalProduct = productRepository.findById(productInWishList.getProductId());
                if(optionalProduct.isEmpty()) throw new RuntimeException("Product does not exist!!");
                logger.info("Product found: " + optionalProduct.get());

                Product product = optionalProduct.get();
                productInWishListResponse.setProductId(productInWishList.getProductId());
                productInWishListResponse.setProductType(product.getProductType());
                productInWishListResponse.setColor(product.getColor());
                productInWishListResponse.setName(product.getName());
                productInWishListResponse.setSize(product.getSize());
                productInWishListResponse.setPrice(product.getPrice());
                productInWishListResponse.setProductDescription(product.getProductDescription());
                productInWishListResponse.setRating(product.getRating());
                productInWishListResponse.setProductStatus(product.getProductStatus());
            }
            return productInWishListResponse;
        }
        catch (Exception e){
            logger.error("An error occurred:", e);
        }
        return productInWishListResponse;
    }

    @Override
    public ProductInWishListRequest addProductToWishList(ProductInWishListRequest productInWishList) {

        Optional<WebAppUser> optionalUser = userRepository.findById(productInWishList.getUserId());
        Optional<Product> optionalProduct = productRepository.findById(productInWishList.getProductId());
        try {
            if(optionalUser.isEmpty()) throw new RuntimeException("User does not exist!!");
            if(optionalProduct.isEmpty()) throw new RuntimeException("Product does not exist!!");

            logger.info("User found: " + optionalUser.get());
            logger.info("Product found: " + optionalProduct.get());

            WebAppUser user = optionalUser.get();

            Set<ProductInWishListRequest> productInWishLists = user.getProductInWishList();
            productInWishLists.add(productInWishList);
            user.setProductInWishList(productInWishLists);
            logger.info("Product added to the wishlist");
            userRepository.save(user);
            return productInWishList;
        }
        catch (Exception e){
            logger.error("An error occurred:", e);
        }
        return null;
    }

    @Override
    public ProductInWishListRequest deleteProductFromWishList(ProductInWishListRequest productInWishList){

        Optional<WebAppUser> optionalUser = userRepository.findById(productInWishList.getUserId());
        Optional<Product> optionalProduct = productRepository.findById(productInWishList.getProductId());
        try {
            if(optionalUser.isEmpty()) throw new RuntimeException("User does not exist!!");
            if(optionalProduct.isEmpty()) throw new RuntimeException("Product does not exist!!");

            logger.info("User found: " + optionalUser.get());
            logger.info("Product found: " + optionalProduct.get());

            WebAppUser user = optionalUser.get();

            Set<ProductInWishListRequest> productInWishLists = user.getProductInWishList();
            if(productInWishLists.contains(productInWishList)){
                productInWishLists.remove(productInWishList);
                user.setProductInWishList(productInWishLists);
                logger.info("Product removed from the wishlist");
                userRepository.save(user);
                return productInWishList;
            }
            else {
                logger.info("Product not found in the wishlist");
                return null;
            }
        }
        catch (Exception e){
            logger.error("An error occurred:", e);
        }
        return null;
    }
}
