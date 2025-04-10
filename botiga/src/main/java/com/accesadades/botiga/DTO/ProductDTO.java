package com.accesadades.botiga.DTO;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private long product_id;
    private String name;
    private String description;
    private String company;
    private float price;
    private long units;
    private String subcategory;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;
}
