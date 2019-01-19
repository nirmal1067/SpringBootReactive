package org.myexample.reactive.controller;

import java.time.Duration;

import org.myexample.reactive.domain.Product;
import org.myexample.reactive.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@GetMapping(path="/all")
	public Flux<Product> getAllProducts()
	{
		return productService.findAllProducts().delayElements(Duration.ofMillis(1000));
	}

}
