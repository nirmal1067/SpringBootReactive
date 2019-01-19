package org.myexample.reactive.service;

import java.math.BigDecimal;

import javax.annotation.PostConstruct;

import org.myexample.reactive.domain.Product;
import org.myexample.reactive.repositories.ReactiveProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;

@Service
public class ProductService {
	
	@Autowired
	private ReactiveProductRepository productRepository;
	
	
	public Flux<Product> findAllProducts()
	{
		return productRepository.findAll();
	}
	
	@PostConstruct
	public void pushData()
	{
	   Product product =  new Product("N", "Spring Guru plain T Shirt", new BigDecimal(115), "tshirt2.png");
	   Product product1 =  new Product("T", "Spring Guru plain T Shirt", new BigDecimal(125), "tshirt2.png");
       
		productRepository.save(product);
		productRepository.save(product1);
		
		System.out.println("************************************Data injected into Monog ******************************************");
		
	}

}
