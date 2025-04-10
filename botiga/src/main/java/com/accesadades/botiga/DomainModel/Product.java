package com.accesadades.botiga.DomainModel;

import lombok.*; 
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column
    private String subcategory; //canviar de String
    @Column(name = "add_categoria")
    private String add_categoria; //revisar
    

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="subcategory_id")
    private SubCategoria subcategoria;    

    //Fer adequadament les relacions (@OneToOne, etc.) amb aquestes entitats.
}
