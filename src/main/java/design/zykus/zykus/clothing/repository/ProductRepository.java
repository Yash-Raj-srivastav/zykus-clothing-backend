package design.zykus.zykus.clothing.repository;

import design.zykus.zykus.clothing.entities.Product;
import design.zykus.zykus.clothing.utils.ProductSize;
import design.zykus.zykus.clothing.utils.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT * FROM products WHERE (:type is null or product_type = :type) and (:size is null or size = :size) and (:minPrice is null or price >= :minPrice) and (:maxPrice is null or price <= :maxPrice)", nativeQuery = true)
    List<Product> filter(
            @Param("type") String type,
            @Param("size") String size,
            @Param("minPrice") Float minPrice,
            @Param("maxPrice") Float maxPrice);
    @Query(value = "SELECT * FROM products ORDER BY price ASC", nativeQuery = true)
    List<Product> sortByPrice();
    @Query(value = "SELECT * FROM products ORDER BY rating DESC", nativeQuery = true)
    List<Product> sortByRating();
}
