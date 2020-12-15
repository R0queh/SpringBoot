package com.chinesas.chinesas.controller;

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

import com.chinesas.chinesas.model.TipoEletro;
import com.chinesas.chinesas.repository.TipoEletroRepository;

@RestController
@RequestMapping("/tipo")
public class TipoEletroController {
	
	@Autowired
	private TipoEletroRepository repository;
	
	@GetMapping
	public ResponseEntity<List<TipoEletro>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<TipoEletro> GetById(@PathVariable Long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<TipoEletro> post(@RequestBody TipoEletro tipo){
		tipo.setDescricao(tipo.getDescricao().toLowerCase());
		if(tipo.getDescricao().equals("eletro-domestico")   || tipo.getDescricao().equals("eletro-eletronico")){
			for(TipoEletro verifica: repository.findAll()) {
				if(verifica.getDescricao().equals(tipo.getDescricao())) {
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
				}
			}
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tipo));
			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
}
	@PutMapping
	public ResponseEntity<TipoEletro> put(@RequestBody TipoEletro tipo){
		tipo.setDescricao(tipo.getDescricao().toLowerCase());
		if(tipo.getDescricao().equals("eletro-domestico")   || tipo.getDescricao().equals("eletro-eletronico")){
			for(TipoEletro verifica: repository.findAll()) {
				if(verifica.getDescricao().equals(tipo.getDescricao())) {
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
				}
			}
			return ResponseEntity.status(HttpStatus.OK).body(repository.save(tipo));
			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<TipoEletro> del(@PathVariable long id) {
		Optional<TipoEletro> idTeste = repository.findById(id);
		if(idTeste.isPresent()) {
			repository.deleteById(id);
			return ResponseEntity.ok().build();				
		}else {
			return ResponseEntity.notFound().build();
		}
	}
}
