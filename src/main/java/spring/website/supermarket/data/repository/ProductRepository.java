package spring.website.supermarket.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import spring.website.supermarket.data.entity.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("select p from Product p " +
            "where lower(p.product_name) like lower(concat('%', :searchTerm, '%'))")
    List<Product> searchProduct(@Param("searchTerm") String searchTerm);

    @Query("select p from Product p")
    List<Product> returnAllProducts();

    @Query("select p.product_photo from Product p " +
            "where p.product_id = :id")
    byte[] returnImage(@Param("id") String id);

    @Query("select p.product_name from Product p " + "" +
            "where p.product_id = :id")
    String returnProductName(@Param("id") String id);

    @Query("select p.product_desc from Product p " + "" +
            "where p.product_id = :id")
    String returnProductDesc(@Param("id") String id);

    @Query("select p.product_price from Product p " + "" +
            "where p.product_id = :id")
    double returnProductPrice(@Param("id") String id);

    @Query("select distinct(p.product_category) from Product p")
    List<String> returnAllProductCategories();

}
