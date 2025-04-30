package com.accesadades.botiga.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.accesadades.botiga.DTO.CategoriaDTO;
import com.accesadades.botiga.DomainModel.Categoria;

@Mapper(componentModel = "spring",unmappedTargetPolicy= ReportingPolicy.IGNORE)
public interface CategoriaMapper {

    CategoriaMapper INSTANCE = Mappers.getMapper(CategoriaMapper.class);

    CategoriaDTO categoriaToCategoriaDTO(Categoria categoria);

    Categoria categoriaDTOToCategoria(CategoriaDTO categoriaDTO);
}
