package com.accesadades.botiga.DomainModel;

import lombok.*; 
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column
    private long product_id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String company;

    @Column
    private float price;
    
    @Column
    private long units;

    @Column(name = "creation_at")
    private LocalDateTime creationDate;

    @Column(name = "updated_at")
    private LocalDateTime updateDate;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name= "subcategory_id")
    private Subcategory subcategory;

    @OneToOne
    @JoinColumn(name = "category_id")
    private Category category; 

}
