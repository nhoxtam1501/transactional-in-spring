package dev.ducku.main.repository;

import dev.ducku.main.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ProductRepository {

    private final JdbcTemplate jdbcTemplate;

    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /*use @Transactional here is not necessary because the transaction already created in product service save() method
    -> it means will use the same transaction with productService save()*/
    //@Transactional
    public void save(Product product) {
        String sql = "INSERT INTO product VALUES(NULL, ?)";
        Object[] args = {product.name()};
        jdbcTemplate.update(sql, args);
    }
}
