package com.accesadades.botiga.Mapper;

import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.Mapping;
import com.accesadades.botiga.DomainModel.Subcategory;
import com.accesadades.botiga.DomainModel.Category;

import com.accesadades.botiga.DomainModel.Product;
import com.accesadades.botiga.DTO.ProductDTO;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface  ProductMapper {

    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "company", source = "company")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "units", source = "units")
    @Mapping(target = "subcategoryName", source = "subcategory.desc_Subcategoria")
    @Mapping(target = "categoryName", source = "category.desc_Categoria")
    ProductDTO productToProductDTO(Product product);


    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "company", source = "company")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "units", source = "units")
    @Mapping(source = "subcategoryName", target = "subcategory.desc_Subcategoria")
    @Mapping(source = "categoryName", target = "category.desc_Categoria")
    Product productDTOToProduct(ProductDTO productDTO);

    Set<ProductDTO> ProductToProductDTO(Set<Product> products);
    Set<Product> ProductDTOToProduct(Set<ProductDTO> productDTOs);



}
