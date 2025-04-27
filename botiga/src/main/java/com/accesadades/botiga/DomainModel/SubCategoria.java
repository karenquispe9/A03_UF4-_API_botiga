package com.accesadades.botiga.DomainModel;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "subcategories")
public class SubCategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_subcategoria")
    private Long id;

    @Column(name = "desc_subcategoria", nullable = false)
    private String descSubcategoria;

    @Column(name = "status_subcategoria", nullable = false)
    private String statusSubcategoria;

    @Column(name = "creation_at")
    private LocalDateTime creationAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Relació N a 1 amb Categoria
    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    // Getters i Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescSubcategoria() {
        return descSubcategoria;
    }

    public void setDescSubcategoria(String descSubcategoria) {
        this.descSubcategoria = descSubcategoria;
    }

    public String getStatusSubcategoria() {
        return statusSubcategoria;
    }

    public void setStatusSubcategoria(String statusSubcategoria) {
        this.statusSubcategoria = statusSubcategoria;
    }

    public LocalDateTime getCreationAt() {
        return creationAt;
    }

    public void setCreationAt(LocalDateTime creationAt) {
        this.creationAt = creationAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
