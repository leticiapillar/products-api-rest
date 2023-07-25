package com.example.springboot.products.controllers;

import com.example.springboot.products.domains.Product;
import com.example.springboot.products.services.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Leticia Pillar <@leticiapillar>
 * @project products-api-rest
 * @created 2023/07/25 - 7:27 PM
 */

@Controller
@ResponseBody
@RequestMapping("/api/v1/products")
@AllArgsConstructor
@Slf4j
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        log.debug("Get all products ...");
        return ResponseEntity.status(HttpStatus.OK)
                .body(productService.findAll());
    }

}
