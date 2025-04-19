package com.accesadades.botiga.Service;

import com.accesadades.botiga.DomainModel.Product;
import com.accesadades.botiga.DTO.ProductDTO;
import com.accesadades.botiga.Mapper.ProductMapper;
import com.accesadades.botiga.Repository.ProductRepository;
import com.accesadades.botiga.Repository.CategoryRepository;
import com.accesadades.botiga.Repository.SubcategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SubcategoryRepository subcategoryRepository;

    @Override
    public Set<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product findProductsByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public Set<Product> findAllProducts(String subcategoryName) {
        return productRepository.findAll()
                .stream()
                .filter(product -> product.getSubcategory().getName().equalsIgnoreCase(subcategoryName))
                .collect(Collectors.toSet());
    }

    @Override
    public void increasePrice(Object productObject) {
        if (productObject instanceof ProductDTO productDTO) {
            Product product = productMapper.productDTOToProduct(productDTO);

            // Convertir los nombres a objetos reales
            product.setCategory(categoryRepository.findByName(productDTO.getCategoryName()));
            product.setSubcategory(subcategoryRepository.findByName(productDTO.getSubcategoryName()));

            // Lógica de aumentar precio
            float newPrice = product.getPrice() + 1;
            product.setPrice(newPrice);

            productRepository.save(product);
        }
    }
}
