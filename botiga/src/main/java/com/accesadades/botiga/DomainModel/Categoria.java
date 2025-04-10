package com.accesadades.botiga.DomainModel;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "categories")
public class Categoria {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    // Relació 1 a N amb Subcategoria
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SubCategoria> subcategories;

    // Relació 1 a 1 amb Producte
    @OneToOne(mappedBy = "categoria")
    private Product producte;

    // Getters i Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<SubCategoria> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<SubCategoria> subcategories) {
        this.subcategories = subcategories;
    }

    public Product getProducte() {
        return producte;
    }

    public void setProducte(Product producte) {
        this.producte = producte;
    }
    

}
