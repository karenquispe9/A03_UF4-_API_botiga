package com.accesadades.botiga.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.accesadades.botiga.DTO.SubCategoriaDTO;
import com.accesadades.botiga.DomainModel.SubCategoria;

@Mapper(componentModel = "spring")
public interface SubCategoriaMapper {

    SubCategoriaMapper INSTANCE = Mappers.getMapper(SubCategoriaMapper.class);

    @Mapping(target = "descSubcategoria", source = "descSubcategoria")
    @Mapping(target = "statusSubcategoria", source = "statusSubcategoria")
    @Mapping(target = "descCategoria", source = "categoria.descCategoria")
    @Mapping(target = "statusCategoria", source = "categoria.statusCategoria")
    SubCategoriaDTO subCategoriaToSubCategoriaDTO(SubCategoria subCategoria);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "creationAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "categoria", ignore = true)
    @Mapping(target = "descSubcategoria", source = "descSubcategoria")
    @Mapping(target = "statusSubcategoria", source = "statusSubcategoria")
    SubCategoria subCategoriaDTOToSubCategoria(SubCategoriaDTO subCategoriaDTO);
}
