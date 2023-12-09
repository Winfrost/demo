package com.example.demo;

import com.example.demo.Product;
import com.example.demo.Feature;
import com.example.demo.ProductFeature;
import com.example.demo.ProductFeatureRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ProductFeatureRepositoryTest {

    @Autowired
    private ProductFeatureRepository productFeatureRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private FeatureRepository featureRepository;

    @Test
    public void testSaveProductFeature() {
        Product product = new Product();
        productRepository.save(product);

        Feature feature = new Feature();
        featureRepository.save(feature);

        ProductFeature productFeature = new ProductFeature();
        productFeature.setProduct(product);
        productFeature.setFeature(feature);

        productFeatureRepository.save(productFeature);

        assertThat(productFeature.getId()).isNotNull();
    }

    // Aggiungi altri test a seconda delle tue esigenze
}
