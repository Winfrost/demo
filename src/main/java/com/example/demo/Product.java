package com.example.demo;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Product {

    private Long id;
    private String code;
    private String name;
    private String description;
    private String image;
    private Double price;

//    Inizio Metodo 1 senza entità associativa

//   @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
//    private List<Feature> features;

//    Fine Metodo 1 senza entità associativa

    // Getter and Setter methods
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

//    Inizio Metodo 1 senza entità associativa

//    public List<Feature> getFeatures() {
//        return features;
//    }

//    public void setFeatures(List<Feature> features) {
//        this.features = features;
//    }

//    Fine Metodo 1 senza entità associativa

}
