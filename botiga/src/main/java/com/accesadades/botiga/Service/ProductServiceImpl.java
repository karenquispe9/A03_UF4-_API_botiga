package com.accesadades.botiga.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accesadades.botiga.DTO.ProductDTO;
import com.accesadades.botiga.DomainModel.Categoria;
import com.accesadades.botiga.DomainModel.Product;
import com.accesadades.botiga.DomainModel.SubCategoria;
import com.accesadades.botiga.Mapper.ProductMapper;
import com.accesadades.botiga.Repository.CategoriaRepository;
import com.accesadades.botiga.Repository.ProductRepository;
import com.accesadades.botiga.Repository.SubCategoriaRepository;

@Service
public class ProductServiceImpl implements BotigaService<ProductDTO, Long> {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private SubCategoriaRepository subCategoriaRepository;


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
    // Buscar la categoría por descripción
    Categoria categoria = categoriaRepository.findByDescCategoria(productDTO.getDesccategoria())
        .orElseThrow(() -> new IllegalArgumentException("Categoria no trobada: " + productDTO.getDesccategoria()));

    // Buscar la subcategoría por descripción
    SubCategoria subcategoria = subCategoriaRepository.findByDescSubcategoria(productDTO.getDescsubcategoria())
        .orElseThrow(() -> new IllegalArgumentException("Subcategoria no trobada: " + productDTO.getDescsubcategoria()));

    // Mapear DTO a entidad
    Product product = productMapper.productDTOToProduct(productDTO);

    // Asignar relaciones
    product.setCategoria(categoria);
    product.setSubcategoria(subcategoria);

    // Guardar
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
