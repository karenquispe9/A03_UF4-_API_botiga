package com.accesadades.botiga.Service;

import java.util.Set;

import com.accesadades.botiga.DomainModel.Product;

public interface ProductService extends Service<Product, Long> {
    Product findProductsByName(String name);
    Set<Product> findAllProductsBySubcategory(String subcategory);
    void increasePrice(Product product);
}
