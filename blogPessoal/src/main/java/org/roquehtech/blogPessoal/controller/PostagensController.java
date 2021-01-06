package org.roquehtech.blogPessoal.controller;

import java.util.List;

import org.roquehtech.blogPessoal.model.Postagem;
import org.roquehtech.blogPessoal.repository.PostagemRepository;
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

@RestController //informa que se trata de um controlador
@RequestMapping("/postagens") // por qual url a classe será acessada
@CrossOrigin(origins =  "*", allowedHeaders = "*") //essa classe aceita requisições de qualqeur origem por exemplo talvez noss ofront venha de angular ou de react e são origens diferentes e por isso precisamos de cross origin 
public class PostagensController {
	
	@Autowired //não podemos intanciar uma interface entaõ deixamos a responsavilidade de instanciação com o spring com esse comando 
	private PostagemRepository repository;
	
	@GetMapping // estou dizendo que as requisições externas atraves da url "/postagens" se o método for get ele dispara esse metodo.
	public ResponseEntity<List <Postagem>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Postagem> GetById(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	@GetMapping("/title/{title}")
	public ResponseEntity<List<Postagem>> GetByTitle(@PathVariable String title){
		return ResponseEntity.ok(repository.findAllByTitleContainingIgnoreCase(title));
		
	}
	
	@PostMapping
	public ResponseEntity<Postagem> post(@RequestBody Postagem postagem){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
	}
	
	@PutMapping
	public ResponseEntity<Postagem> put(@RequestBody Postagem postagem){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
	
	
	
}