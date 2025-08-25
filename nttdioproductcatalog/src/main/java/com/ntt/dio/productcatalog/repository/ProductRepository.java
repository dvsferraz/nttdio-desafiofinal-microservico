package com.ntt.dio.productcatalog.repository;

import com.ntt.dio.productcatalog.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByNameContaining(String name);

    List<Product> findByDescriptionContaining(String description);

    List<Product> findByPrice(Double price);
}
