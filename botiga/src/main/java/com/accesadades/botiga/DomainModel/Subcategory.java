package com.accesadades.botiga.DomainModel;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;  
import java.util.List; 
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(name = "subcategory")
public class Subcategory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Subcategoria;

    @Column(name = "desc_Subcategoria")
    private String desc_Subcategoria;

    @Column(name = "status_Subcategoria")
    private String status_Subcategoria;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "creation_at")
    private LocalDateTime creation_at;

    @Column(name = "updated_at")
    private LocalDateTime updated_at;

    @OneToMany(mappedBy = "subcategory")
    private List<Product> products;

}
