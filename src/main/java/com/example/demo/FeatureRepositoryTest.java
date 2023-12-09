package com.example.demo;

import com.example.demo.Feature;
import com.example.demo.FeatureRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class FeatureRepositoryTest {

    @Autowired
    private FeatureRepository featureRepository;

    @Test
    public void testSaveFeature() {
        Feature feature = new Feature();
        feature.setName("Test Feature");

        featureRepository.save(feature);

        assertThat(feature.getId()).isNotNull();
    }

    // Aggiungi altri test a seconda delle tue esigenze
}
