package com.accesadades.botiga.Repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accesadades.botiga.DomainModel.Product;
import com.accesadades.botiga.DomainModel.SubCategoria;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findById(Long id);

    Product findByName(String name);

    Set<Product> findBySubcategoria(SubCategoria subcategoria);
}
