package com.accesadades.botiga.Mapper;

import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.Mapping;

import com.accesadades.botiga.DomainModel.Product;
import com.accesadades.botiga.DTO.ProductDTO;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface  ProductMapper {

    @Mapping(target = "name", source = "product.name")
    @Mapping(target = "description", source = "product.description")
    @Mapping(target = "company", source = "product.company")
    @Mapping(target = "price", source = "product.price")
    @Mapping(target = "units", source = "product.units")
    @Mapping(target = "subcategory", source = "product.subcategory")
    ProductDTO  ProductToProductDTO(Product product);



    @Mapping(target = "name", source = "productDTO.name")
    @Mapping(target = "description", source = "productDTO.description")
    @Mapping(target = "company", source = "productDTO.company")    
    @Mapping(target = "price", source = "productDTO.price")
    @Mapping(target = "units", source = "productDTO.units")
    @Mapping(target = "subcategory", source = "productDTO.subcategory")
    Product ProductDTOToProduct(ProductDTO productDTO);

    Set<ProductDTO> ProductToProductDTO(Set<Product> products);
    Set<Product> ProductDTOToProduct(Set<ProductDTO> productDTOs);



}
