package com.generation.livecode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.livecode.model.LiveCoding;
import com.generation.livecode.repository.liveRepository;

@RestController
@RequestMapping("/live")
@CrossOrigin(value = "*", allowedHeaders = "*")
public class LiveController {
	
	@Autowired // injeção de dependencia
	private liveRepository repository;

	@GetMapping
	public ResponseEntity<List<LiveCoding>> getAll(){
		return ResponseEntity.ok(repository.findAll());
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<LiveCoding> getById(@PathVariable long id){
		
		/*Optional<LiveCoding> live = repository.findById(id); 
		
		if(live.isPresent())						//método alternativo 
			return ResponseEntity.ok(live.get()); 	
		
		return ResponseEntity.badRequest().build();  */ 
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
					.orElse(ResponseEntity.badRequest().build());
	
	}
	
	@GetMapping("/nome/{titulo}")
	public ResponseEntity<List<LiveCoding>> getByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}
	
	@GetMapping("/qtd/{valor}")
	public ResponseEntity<List<LiveCoding>> getByQnt(@PathVariable int valor){
		return ResponseEntity.ok(repository.maiorQue(valor));
	}
	
	@PostMapping
	public ResponseEntity<LiveCoding> post(@RequestBody LiveCoding live){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(live));
	}
	
	@PostMapping
	public ResponseEntity<LiveCoding> put(@RequestBody LiveCoding live){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(live));
	}
	
	@DeleteMapping("/{id}")
	public void delete (@PathVariable long id){
		repository.deleteById(id);
	}
	
}