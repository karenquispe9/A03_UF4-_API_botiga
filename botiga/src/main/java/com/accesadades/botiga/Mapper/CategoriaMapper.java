package com.accesadades.botiga.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.accesadades.botiga.DTO.CategoriaDTO;
import com.accesadades.botiga.DomainModel.Categoria;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    CategoriaMapper INSTANCE = Mappers.getMapper(CategoriaMapper.class);

    @Mapping(target = "descCategoria", source = "descCategoria")
    @Mapping(target = "statusCategoria", source = "statusCategoria")
    CategoriaDTO categoriaToCategoriaDTO(Categoria categoria);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "creationAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "subcategories", ignore = true)
    @Mapping(target = "descCategoria", source = "descCategoria")
    @Mapping(target = "statusCategoria", source = "statusCategoria")
    Categoria categoriaDTOToCategoria(CategoriaDTO categoriaDTO);
}
