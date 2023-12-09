package com.example.demo;

import com.example.demo.Product;
import com.example.demo.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testSaveProduct() {
        Product product = new Product();
        product.setCode("ABC123");
        product.setName("Test Product");
        product.setDescription("Description for test product");
        product.setImage("test_image.jpg");
        product.setPrice(99.99);

        productRepository.save(product);

        assertThat(product.getId()).isNotNull();
    }

    // Aggiungi altri test a seconda delle tue esigenze
}
