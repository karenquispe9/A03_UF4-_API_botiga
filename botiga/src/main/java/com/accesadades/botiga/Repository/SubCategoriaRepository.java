package com.accesadades.botiga.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accesadades.botiga.DomainModel.SubCategoria;

@Repository
public interface SubCategoriaRepository extends JpaRepository<SubCategoria, Long> {
    Optional<SubCategoria> findByDescSubcategoria(String descSubcategoria);

}
