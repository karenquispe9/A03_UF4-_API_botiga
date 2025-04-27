package com.accesadades.botiga.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accesadades.botiga.DTO.ProductDTO;
import com.accesadades.botiga.DomainModel.Product;
import com.accesadades.botiga.Mapper.ProductMapper;
import com.accesadades.botiga.Repository.ProductRepository;

@Service
public class ProductServiceImpl implements BotigaService<ProductDTO, Long> {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<ProductDTO> findAll() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::productToProductDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProductDTO> findById(Long id) {
        return productRepository.findById(id)
                .map(productMapper::productToProductDTO);
    }

    @Override
    public void save(ProductDTO productDTO) {
        Product product = productMapper.productDTOToProduct(productDTO);

        // Validaciones de negocio: asegurar que categoría y subcategoría existen
        if (product.getCategoria() == null || product.getSubcategoria() == null) {
            throw new IllegalArgumentException("El producto debe tener categoría y subcategoría válidas.");
        }

        productRepository.save(product);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    // Método extra: buscar producto por nombre
    public ProductDTO findByName(String name) {
        Product product = productRepository.findByName(name);
        return productMapper.productToProductDTO(productRepository.findByName(name));
    }
}
