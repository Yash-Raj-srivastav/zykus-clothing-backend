package design.zykus.zykus.clothing.dto;

import design.zykus.zykus.clothing.entities.BaseModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "wishlist_product")
public class ProductInWishListRequest extends BaseModel {
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "user_id")
    private Long userId;
}
