package com.example.springboot.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductsApiRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsApiRestApplication.class, args);
		System.out.println("Products API running...");
	}

}
