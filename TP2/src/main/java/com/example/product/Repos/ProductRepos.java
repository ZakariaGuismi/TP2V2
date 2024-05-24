package com.example.product.Repos;

import com.example.product.entites.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepos extends JpaRepository<Product,Long> {
List<Product> findProductByPrixGreaterThan(Double d);
List<Product> findProductByNameContains(String s);

@Query("select  p from Product p where p.name like :x")
Product search(@Param("x") String s );
}
