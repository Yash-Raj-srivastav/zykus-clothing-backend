package design.zykus.zykus.clothing.entities;

import design.zykus.zykus.clothing.utils.ProductStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "wishlist_product")
public class ProductInWishList extends BaseModel{
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "user_id")
    private Long userId;
}
