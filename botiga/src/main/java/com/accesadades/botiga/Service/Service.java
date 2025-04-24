package com.accesadades.botiga.Service;

import java.util.List;
import java.util.Optional;

public interface Service<T, ID> {

    List<T> findAll();
    Optional<T> findById(ID id);
    void save(T entity);
    void deleteById(ID id);
}
