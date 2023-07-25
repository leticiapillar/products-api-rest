package com.example.springboot.products.bootstrap;

import com.example.springboot.products.domains.Product;
import com.example.springboot.products.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Leticia Pillar <@leticiapillar>
 * @project products-api-rest
 * @created 2023/07/25 - 7:13 PM
 */

@Component
@AllArgsConstructor
public class ProductBootstrapData implements CommandLineRunner {

    private final ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        Product apple = Product.builder()
                .name("Apple")
                .quantity(100)
                .price(new BigDecimal(0.50))
                .createdAt(LocalDateTime.now())
                .build();

        Product tomato = Product.builder()
                .name("Tomato")
                .quantity(100)
                .price(new BigDecimal(0.85))
                .createdAt(LocalDateTime.now())
                .build();

        Product chicken = Product.builder()
                .name("Chicken")
                .quantity(100)
                .price(new BigDecimal(12.85))
                .createdAt(LocalDateTime.now())
                .build();

        productRepository.save(apple);
        productRepository.save(tomato);
        productRepository.save(chicken);
    }

}
