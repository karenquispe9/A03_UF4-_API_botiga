package com.accesadades.botiga.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private String name;
    private String description;
    private String company;
    private float price;
    private long units;
    private String descsubcategoria;
    private String desccategoria;
}
