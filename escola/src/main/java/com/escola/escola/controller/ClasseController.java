package com.escola.escola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escola.escola.model.Classe;
import com.escola.escola.repository.ClasseRepository;

@RestController
@RequestMapping("/classe")
public class ClasseController {

	@Autowired
	public ClasseRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Classe>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Classe> GetById(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/classe/{turma}")
	public ResponseEntity<List<Classe>> GetByName(@PathVariable String turma){
		return ResponseEntity.ok(repository.findAllByTurmaContainingIgnoreCase(turma));
	}
	
	@PostMapping
	public ResponseEntity<Classe> post(@RequestBody Classe classe){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(classe));
	}
	
	@PutMapping
	public ResponseEntity<Classe> put(@RequestBody Classe classe){
		return ResponseEntity.status(HttpStatus.OK)
				.body(repository.save(classe));
	}
	
	@DeleteMapping("/{id}")
	public void del(@PathVariable long id) {
		repository.deleteById(id);
	}
	
	
}
