package com.example.springboot.products.services.impl;

import com.example.springboot.products.domains.Product;
import com.example.springboot.products.repositories.ProductRepository;
import com.example.springboot.products.services.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Leticia Pillar <@leticiapillar>
 * @project products-api-rest
 * @created 2023/07/25 - 7:30 PM
 */

@Service
@AllArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        List<Product> products = productRepository.findAll();
        log.debug("Find all products: {}", products);
        return products;
    }
}
