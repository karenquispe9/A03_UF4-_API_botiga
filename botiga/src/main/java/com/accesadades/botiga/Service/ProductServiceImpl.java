package com.accesadades.botiga.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accesadades.botiga.DomainModel.Product;
import com.accesadades.botiga.Repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void save(Product product) {
        if (product.getSubcategoria() == null || product.getSubcategoria().getCategoria() == null) {
            System.out.println("ERROR: El producto necesita categoría y subcategoría.");
            return;
        }
    
        productRepository.save(product);
    }
    



    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product findProductsByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public Set<Product> findAllProductsBySubcategory(String subcategory) {
        return productRepository.findBySubcategory(subcategory);
    }

    @Override
    public void increasePrice(Product product) {
        // Lógica para aumentar el precio del producto
    }
}
