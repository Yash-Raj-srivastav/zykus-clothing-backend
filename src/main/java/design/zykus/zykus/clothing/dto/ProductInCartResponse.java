package design.zykus.zykus.clothing.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Data
@RequiredArgsConstructor
public class ProductInCartResponse {
    private UserResponse userResponse;
    private Set<ProductResponse> productResponses;
}
