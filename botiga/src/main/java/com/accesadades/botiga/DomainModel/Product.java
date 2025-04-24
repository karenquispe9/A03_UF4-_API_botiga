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
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;

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

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "subcategory_id")
    private SubCategoria subcategoria;    

    public SubCategoria getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(SubCategoria subcategoria) {
        this.subcategoria = subcategoria;
    }

    // Si necesitas trabajar con la categoría (relación ManyToOne dentro de SubCategoria)
    public Categoria getCategoria() {
        if (this.subcategoria != null) {
            return this.subcategoria.getCategoria(); // Esto asume que la clase SubCategoria tiene un método getCategoria()
        }
        return null;
    }
}
