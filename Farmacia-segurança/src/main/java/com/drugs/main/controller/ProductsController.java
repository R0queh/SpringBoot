package com.drugs.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drugs.main.model.Products;
import com.drugs.main.repository.ProductsRepository;

@RestController
@RequestMapping("/products")
@CrossOrigin(value = "*", allowedHeaders = "*")
public class ProductsController {
	
	@Autowired
	public ProductsRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Products>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Products> GetById(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Products> post(@RequestBody Products produto){
		return ResponseEntity.status(HttpStatus.CREATED)
					.body(repository.save(produto));
	}
	
	@PutMapping
	public ResponseEntity<Products> put(@RequestBody Products produto){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(produto));
	}

}