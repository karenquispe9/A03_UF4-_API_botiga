package com.accesadades.botiga.DomainModel;

import jakarta.persistence.*;
import java.util.List;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDateTime;  


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Categoria;

    @Column(name = "desc_Categoria")
    private String desc_Categoria;

    @Column(name = "status_Categoria")
    private String status_Categoria;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

    @Column(name = "creation_at")
    private LocalDateTime creation_at;

    @Column(name = "updated_at")
    private LocalDateTime updated_at;

    // Relació 1 a N amb Subcategoria
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Subcategory> subcategorys;

    // Relació 1 a 1 amb Producte
    @OneToOne(mappedBy = "category")
    private Product product;


}
