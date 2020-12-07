package com.habilidades.habilidade.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.habilidades.habilidade.module.objeto;

@RestController
@RequestMapping("/principal")
public class habController {
	
	public String per= "Persistência";
	public String ori= "Orientação ao futuro";
	public String atencao= "Atenção a detalhes";
	public String gerencia= "Gerenciamento de tempo";
	
	@GetMapping
	public objeto getPer() {
		String text = "Foi preciso ter persistência para assistir o vídeo e não"
				+ " desanimar se caso assustasse ou fosse muita informação de uma "
				+ "só vez e persistência em repetir várias vezes dentro da nossa IDE.";
		objeto persistencia = new objeto(per, text);
		return persistencia;
	}
	@GetMapping("/ori")
	public objeto getOri() {
		String text = "Foi a habilidade necessária necessária para ter muita vontade de "
				+ "aprender sabendo que essa habilidade é necessaria para um bom profissional"
				+ "e com isso em mente ir com toda vontade e mente aberta";
		objeto orientacao = new objeto(ori, text);
		return orientacao;
		
	}
	@GetMapping("/atencao")
	public objeto getAtencao() {
		String text = "Esse é o mais importante de todos, fiquei um tempo olhando para um"
				+ "Erro 404 sem saber o que estava errado e era um caminho de package errado"
				+ "e depois de mostrar atenção eu consegui resolver meus problemas.";
		objeto aten = new objeto(atencao, text);
		return aten;
		
	}
	@GetMapping("/gerencia")
	public objeto getGerencia() {
		String text = "Esse foi necessário para saber quantas vezes eu precisava olhar o vídeo"
				+ "quanto tempo eu ficaria olhando para o erro pensando e quando eu precisaria"
				+ "Pedir ajuda.";
		objeto ger = new objeto(gerencia, text);
		return ger;
	}
	

}
