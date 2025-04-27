package com.accesadades.botiga.DTO;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoriaDTO {

    private Long id;
    private String descCategoria;
    private String statusCategoria;
    private LocalDateTime creationAt;
    private LocalDateTime updatedAt;
    private List<SubCategoriaDTO> subcategories;
}
