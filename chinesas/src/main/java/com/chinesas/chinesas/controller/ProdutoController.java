package com.chinesas.chinesas.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

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

import com.chinesas.chinesas.model.Produtos;
import com.chinesas.chinesas.repository.ProdutoRepository;

@RestController
@RequestMapping("/prod")
public class ProdutoController {

	@Autowired
	private ProdutoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Produtos>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produtos> GetById(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/range/{ini}/{fim}")
	public ResponseEntity<List<Produtos>> GetAllByRange(@PathVariable BigDecimal ini, @PathVariable BigDecimal fim){
		return ResponseEntity.ok(repository.findAllByPrecoBetween(ini, fim));
	}
	
	/*@GetMapping("/range/{ini}/{fim}")
	public ResponseEntity<List<Produtos>> GetAllByRange(@PathVariable BigDecimal ini, @PathVariable BigDecimal fim){
		return ResponseEntity.ok(repository.findAllByPrecoBetween(ini, fim));
	}*/
	
	@PostMapping
	public ResponseEntity<Produtos> post(@RequestBody Produtos produto){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
	}
	
	@PutMapping
	public ResponseEntity<Produtos> put(@RequestBody Produtos produto){
		return ResponseEntity.ok(repository.save(produto));
	}
	
	@DeleteMapping("/{id}")
	public void del(@PathVariable long id) {
		Optional<Produtos> idTeste = repository.findById(id);
		if(idTeste.isPresent()) {
			repository.deleteById(id);
			ResponseEntity.ok().build();				
		}else {
			ResponseEntity.notFound().build();
		}
	}	
}