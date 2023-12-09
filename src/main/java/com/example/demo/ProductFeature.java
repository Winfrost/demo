package com.example.demo;

import jakarta.persistence.*;

@Entity
public class ProductFeature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "feature_id")
    private Feature feature;

    // Altri attributi, se necessario

    public ProductFeature() {
        // Costruttore vuoto richiesto da JPA
    }

    public ProductFeature(Product product, Feature feature) {
        this.product = product;
        this.feature = feature;
        // Puoi inizializzare altri attributi se necessario
    }

    // Getter e Setter per id, product, feature e altri attributi

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Feature getFeature() {
        return feature;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }

    // Altri metodi, se necessario

}
