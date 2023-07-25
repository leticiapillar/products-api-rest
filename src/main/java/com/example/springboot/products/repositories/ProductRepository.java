package com.example.springboot.products.repositories;

import com.example.springboot.products.domains.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author Leticia Pillar <@leticiapillar>
 * @project products-api-rest
 * @created 2023/07/25 - 7:06 PM
 */
public interface ProductRepository extends JpaRepository<Product, UUID> {
}
