package com.drugs.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drugs.main.model.Drugs;
import com.drugs.main.repository.DrugsRepository;

@RestController
@RequestMapping("/drugs")
@CrossOrigin(value = "*" , allowedHeaders = "*")
public class DrugsController {
	
	@Autowired
	private DrugsRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Drugs>> getAll(){
	return ResponseEntity.ok(repository.findAll());	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Drugs> GetById(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Drugs> post(@RequestBody Drugs drug){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(drug));
	}
	
	@PutMapping
	public ResponseEntity<Drugs> put(@RequestBody Drugs drug){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(drug));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}
