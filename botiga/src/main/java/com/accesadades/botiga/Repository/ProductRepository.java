package com.accesadades.botiga.Repository;

import com.accesadades.botiga.DomainModel.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findById(Long id);
    Product findByName(String name);
    Set<Product> findBySubcategory(String subcategory);
}
