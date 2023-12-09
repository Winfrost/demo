package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product-features")
public class ProductFeatureController {

    @Autowired
    private ProductFeatureRepository productFeatureRepository;

    @GetMapping
    public List<ProductFeature> getAllProductFeatures() {
        return productFeatureRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductFeature> getProductFeatureById(@PathVariable Long id) {
        return productFeatureRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ProductFeature createProductFeature(@RequestBody ProductFeature productFeature) {
        return productFeatureRepository.save(productFeature);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductFeature> updateProductFeature(@PathVariable Long id, @RequestBody ProductFeature updatedProductFeature) {
        return productFeatureRepository.findById(id)
                .map(existingProductFeature -> {
                    // Aggiorna campi se necessario
                    return ResponseEntity.ok(productFeatureRepository.save(existingProductFeature));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductFeature(@PathVariable Long id) {
        return productFeatureRepository.findById(id)
                .map(existingProductFeature -> {
                    productFeatureRepository.delete(existingProductFeature);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}