package com.accesadades.botiga.DTO;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubCategoriaDTO {

    private Long id;
    private String descSubcategoria;
    private String statusSubcategoria;
    private LocalDateTime creationAt;
    private LocalDateTime updatedAt;
    private CategoriaDTO categoria;
}