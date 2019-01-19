package org.myexample.reactive.controller;

import java.time.Duration;

import org.myexample.reactive.domain.Product;
import org.myexample.reactive.service.CounterService;
import org.myexample.reactive.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CounterService counterService;
	
	@GetMapping(path="/all",produces=MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Product> getAllProducts()
	{
		return productService.findAllProducts();
	}
	
	@GetMapping(path="/numbers",produces=MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Integer> getNumbers()
	{
		Flux<Integer> flux = Flux.create(sink->{
			counterService.count(sink, 10);
		});
		
		return flux;
	}
	
	
	@GetMapping(path="/strs")
	public Flux<String> getTime()
	{
		return Flux.just("tyy","hgh","opp","hh");
	}

}
