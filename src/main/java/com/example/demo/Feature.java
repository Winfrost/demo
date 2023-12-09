package com.example.demo;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Feature {

    private Long id;
    private String name;

//    Inizio Metodo 1 senza entità associativa

//    @ManyToMany(mappedBy = "features")
//    private List<Product> products;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


//  Metodo 1 senza entità associativa

//    public List<Product> getProducts() {
//        return products;
//    }

//    Inizio Metodo 1 senza entità associativa

//    public void setProducts(List<Product> products) {
//        this.products = products;
//    }

//    Fine Metodo 1 senza entità associativa

}

