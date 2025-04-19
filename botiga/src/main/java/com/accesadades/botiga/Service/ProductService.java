package com.accesadades.botiga.Service;

import java.util.Set;

import com.accesadades.botiga.DomainModel.Product;
import com.accesadades.botiga.DTO.ProductDTO;

public interface ProductService {

    Set<Product> findAllProducts();
    Product findProductsByName(String name);
    Set<Product> findAllProducts(String subcategory);
    void increasePrice(Object product);

    // NUEVOS MÉTODOS
    ProductDTO saveProduct(ProductDTO dto);
}
