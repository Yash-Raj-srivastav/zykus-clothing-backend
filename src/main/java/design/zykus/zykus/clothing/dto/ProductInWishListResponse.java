package design.zykus.zykus.clothing.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;

import java.util.Set;

@Data
@RequiredArgsConstructor
public class ProductInWishListResponse {
    private UserResponse userResponse;
    private Set<ProductResponse> productResponses;
}
