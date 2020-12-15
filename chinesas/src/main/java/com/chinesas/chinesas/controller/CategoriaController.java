package com.chinesas.chinesas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chinesas.chinesas.model.Categoria;
import com.chinesas.chinesas.repository.CategoriaRepository;

@RestController
@RequestMapping("/cat")
@CrossOrigin(value = "*", allowedHeaders = "*")
public class CategoriaController {
	
	@Autowired 
	private CategoriaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> GetById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Categoria> post(@RequestBody Categoria cat){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(cat));
	}
	
	@PutMapping
	public ResponseEntity<Categoria> put(@RequestBody Categoria cat){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(cat));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Categoria> del(@PathVariable long id) {
		Optional<Categoria> idTeste = repository.findById(id);
		if(idTeste.isPresent()) {
			repository.deleteById(id);
			return ResponseEntity.ok().build();				
		}else {
			return ResponseEntity.notFound().build();
		}
	}
}

