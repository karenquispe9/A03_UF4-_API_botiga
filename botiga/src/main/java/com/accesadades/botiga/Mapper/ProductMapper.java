package com.accesadades.botiga.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import com.accesadades.botiga.DTO.ProductDTO;
import com.accesadades.botiga.DomainModel.Product;

@Mapper(componentModel = "spring", unmappedTargetPolicy= ReportingPolicy.IGNORE)
public interface ProductMapper {


    @Mappings({
        @Mapping(source = "product.subcategoria.descSubcategoria", target = "descsubcategoria"),
        @Mapping(source = "product.categoria.descCategoria", target = "desccategoria")
    })
    ProductDTO productToProductDTO(Product product);

    @Mappings({
        @Mapping(target = "subcategoria.descSubcategoria", source = "descsubcategoria"),
        @Mapping(target = "categoria.descCategoria",  source = "desccategoria")
    })
    Product productDTOToProduct(ProductDTO productDTO);
}
