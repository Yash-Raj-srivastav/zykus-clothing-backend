package design.zykus.zykus.clothing.services.impl;

import design.zykus.zykus.clothing.entities.Product;
import design.zykus.zykus.clothing.entities.ProductInWishList;
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
    public Set<ProductInWishList> getWishListOfUser(Long userId) {
        Optional<WebAppUser> optionalUser = userRepository.findById(userId);
        try {
            if (optionalUser.isEmpty()) throw new RuntimeException("User does not exist!!");
            WebAppUser user = optionalUser.get();
            return user.getProductInWishList();
        }
        catch (Exception e){
            logger.error("An error occurred:", e);
        }
        return null;
    }

    @Override
    public void addProductToWishList(ProductInWishList productInWishList) {
        Optional<WebAppUser> optionalUser = userRepository.findById(productInWishList.getUserId());
        Optional<Product> optionalProduct = productRepository.findById(productInWishList.getProductId());
        try {
            if(optionalUser.isEmpty()) throw new RuntimeException("User does not exist!!");
            if(optionalProduct.isEmpty()) throw new RuntimeException("Product does not exist!!");

            logger.info("User found: " + optionalUser.get());
            logger.info("Product found: " + optionalProduct.get());

            WebAppUser user = optionalUser.get();

            Set<ProductInWishList> productInWishLists = user.getProductInWishList();
            productInWishLists.add(productInWishList);
            user.setProductInWishList(productInWishLists);

            userRepository.save(user);
        }
        catch (Exception e){
            logger.error("An error occurred:", e);
        }
    }
}
