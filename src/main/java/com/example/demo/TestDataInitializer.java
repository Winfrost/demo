package com.example.demo;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestDataInitializer implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final FeatureRepository featureRepository;
    private final ProductFeatureRepository productFeatureRepository;
    private final Faker faker;

    @Autowired
    public TestDataInitializer(ProductRepository productRepository, FeatureRepository featureRepository,
                               ProductFeatureRepository productFeatureRepository) {
        this.productRepository = productRepository;
        this.featureRepository = featureRepository;
        this.productFeatureRepository = productFeatureRepository;
        this.faker = new Faker();
    }

    @Override
    public void run(String... args) {
        // Creare e salvare alcuni dati di test per la tabella Product
        for (int i = 0; i < 10; i++) {
            Product product = new Product();
            product.setCode(faker.code().asin());
            product.setName(faker.commerce().productName());
            product.setDescription(faker.lorem().sentence());
            product.setImage(faker.internet().image());
            product.setPrice(faker.random().nextDouble() * 999 + 1);

            productRepository.save(product);
        }

        // Creare e salvare alcuni dati di test per la tabella Feature
        for (int i = 0; i < 5; i++) {
            Feature feature = new Feature();
            feature.setName(faker.lorem().word());

            featureRepository.save(feature);
        }

        // Creare e salvare alcuni dati di test per la tabella ProductFeature
        for (Product product : productRepository.findAll()) {
            for (Feature feature : featureRepository.findAll()) {
                ProductFeature productFeature = new ProductFeature();
                productFeature.setProduct(product);
                productFeature.setFeature(feature);

                productFeatureRepository.save(productFeature);
            }
        }
    }
}
