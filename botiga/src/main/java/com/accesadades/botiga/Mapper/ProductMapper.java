package com.accesadades.botiga.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.accesadades.botiga.DTO.ProductDTO;
import com.accesadades.botiga.DomainModel.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mappings({
        @Mapping(source = "name", target = "name"),
        @Mapping(source = "description", target = "description"),
        @Mapping(source = "company", target = "company"),
        @Mapping(source = "price", target = "price"),
        @Mapping(source = "units", target = "units"),
        @Mapping(source = "subcategoria.descSubcategoria", target = "subCategoria"),
        @Mapping(source = "subcategoria.statusSubcategoria", target = "statusSubcategoria"),
        @Mapping(source = "subcategoria.categoria.descCategoria", target = "descCategoria"),
        @Mapping(source = "subcategoria.categoria.statusCategoria", target = "statusCategoria")
    })
    ProductDTO productToProductDTO(Product product);

    @Mappings({
        @Mapping(target = "productId", ignore = true),
        @Mapping(target = "creationDate", ignore = true),
        @Mapping(target = "updateDate", ignore = true),
        @Mapping(target = "subcategoria.descSubcategoria", source = "descSubcategoria"),
        @Mapping(target = "subcategoria.statusSubcategoria", source = "statusSubcategoria"),
        @Mapping(target = "subcategoria.categoria", ignore = true),
        @Mapping(target = "name", source = "name"),
        @Mapping(target = "description", source = "description"),
        @Mapping(target = "company", source = "company"),
        @Mapping(target = "price", source = "price"),
        @Mapping(target = "units", source = "units")
    })
    Product productDTOToProduct(ProductDTO productDTO);
}
