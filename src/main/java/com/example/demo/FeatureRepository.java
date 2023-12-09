package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

public interface FeatureRepository extends JpaRepository<Feature, Long> {
    List<Feature> findByNameContaining(String name);

}