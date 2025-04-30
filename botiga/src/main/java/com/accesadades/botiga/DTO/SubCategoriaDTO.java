package com.accesadades.botiga.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubCategoriaDTO {

    private String descSubcategoria;
    private String statusSubcategoria;
    private Long categoriaId;
}