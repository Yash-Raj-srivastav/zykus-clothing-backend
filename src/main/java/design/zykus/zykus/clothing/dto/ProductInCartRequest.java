package design.zykus.zykus.clothing.dto;

import design.zykus.zykus.clothing.entities.BaseModel;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
public class ProductInCartRequest extends BaseModel {
    private Long productId;
    private Long userId;
}
