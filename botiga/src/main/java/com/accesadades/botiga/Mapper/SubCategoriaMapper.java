package com.accesadades.botiga.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.accesadades.botiga.DTO.SubCategoriaDTO;
import com.accesadades.botiga.DomainModel.Categoria;
import com.accesadades.botiga.DomainModel.SubCategoria;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SubCategoriaMapper {

    @Mapping(target = "categoria", source = "categoriaId")
    SubCategoria subCategoriaDTOToSubCategoria(SubCategoriaDTO dto);

    SubCategoriaDTO subCategoriaToSubCategoriaDTO(SubCategoria subCategoria);

    // este método extra lo usa MapStruct internamente
    default Categoria map(Long categoriaId) {
        if (categoriaId == null) return null;
        Categoria categoria = new Categoria();
        categoria.setId(categoriaId);
        return categoria;
    }
}
