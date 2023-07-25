package com.example.springboot.products.services;

import com.example.springboot.products.domains.Product;

import java.util.List;

/**
 * @author Leticia Pillar <@leticiapillar>
 * @project products-api-rest
 * @created 2023/07/25 - 7:28 PM
 */
public interface ProductService {
    List<Product> findAll();
}
