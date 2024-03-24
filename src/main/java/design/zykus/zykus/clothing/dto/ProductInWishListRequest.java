package design.zykus.zykus.clothing.dto;

import design.zykus.zykus.clothing.entities.BaseModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
public class ProductInWishListRequest extends BaseModel{
    private Long productId;
    private Long userId;
}
