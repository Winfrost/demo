package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/features")
public class FeatureController {

    @Autowired
    private FeatureRepository featureRepository;

    @GetMapping
    public List<Feature> getAllFeatures() {
        return featureRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Feature> getFeatureById(@PathVariable Long id) {
        return featureRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Feature createFeature(@RequestBody Feature feature) {
        return featureRepository.save(feature);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Feature> updateFeature(@PathVariable Long id, @RequestBody Feature updatedFeature) {
        return featureRepository.findById(id)
                .map(existingFeature -> {
                    existingFeature.setName(updatedFeature.getName());
                    // Aggiorna altri campi se necessario
                    return ResponseEntity.ok(featureRepository.save(existingFeature));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeature(@PathVariable Long id) {
        return featureRepository.findById(id)
                .map(existingFeature -> {
                    featureRepository.delete(existingFeature);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}