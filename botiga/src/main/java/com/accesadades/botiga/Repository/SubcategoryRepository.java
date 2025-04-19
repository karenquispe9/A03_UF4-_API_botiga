package com.accesadades.botiga.Repository;

import com.accesadades.botiga.DomainModel.Subcategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubcategoryRepository extends CrudRepository<Subcategory, Long> {
    Subcategory findByName(String name);
}
