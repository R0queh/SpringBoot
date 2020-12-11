package com.escola.escola.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escola.escola.model.Aluno;
import com.escola.escola.model.Classe;

public interface ClasseRepository extends JpaRepository<Classe, Long>{
	
	public List<Classe> findAllByTurmaContainingIgnoreCase(String turma);

}