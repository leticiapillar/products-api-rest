package com.example.springboot.products.controllers;

import com.example.springboot.products.domains.Product;
import com.example.springboot.products.repositories.ProductRepository;
import com.example.springboot.products.services.ProductService;
import com.example.springboot.products.services.impl.ProductServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * @author Leticia Pillar <@leticiapillar>
 * @project products-api-rest
 * @created 2023/07/25 - 8:17 PM
 */
@WebMvcTest(ProductController.class)
class ProductControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @MockBean
    ProductService productService;
    @MockBean
    ProductRepository productRepository;

    ProductServiceImpl productServiceimpl;

    @BeforeEach
    void setUp() {
        productServiceimpl = new ProductServiceImpl(productRepository);
    }

    @Test
    void getAll() throws Exception {
        List<Product> products = List.of(
                Product.builder()
                        .uuid(UUID.randomUUID())
                        .name("Apple")
                        .quantity(10)
                        .price(new BigDecimal(10.29))
                        .build(),
                Product.builder()
                        .uuid(UUID.randomUUID())
                        .name("Banana")
                        .quantity(12)
                        .price(new BigDecimal(5.99))
                        .build());
        given(productService.findAll()).willReturn(products);
        mockMvc.perform(get("/api/v1/products")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()", is(products.size())));
    }

    @Test
    void getOne() throws Exception {
        UUID id = UUID.randomUUID();
        Product product = Product.builder()
                .uuid(id)
                .name("Apple")
                .quantity(10)
                .price(new BigDecimal(10.29))
                .build();
        given(productService.findById(id)).willReturn(Optional.ofNullable(product));
        mockMvc.perform(get("/api/v1/products/" + id)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.uuid", is(product.getUuid().toString())))
                .andExpect(jsonPath("$.name", is(product.getName())))
                .andExpect(jsonPath("$.quantity", is(product.getQuantity())))
                .andExpect(jsonPath("$.price", is(product.getPrice())));
    }

    @Test
    void getOne_notFound() throws Exception {
        UUID id = UUID.randomUUID();
        given(productService.findById(id)).willReturn(Optional.ofNullable(null));
        mockMvc.perform(get("/api/v1/products/" + id)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

}