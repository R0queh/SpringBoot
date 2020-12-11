package com.escola.escola.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escola.escola.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

	public List<Aluno> findAllByNomeContainingIgnoreCase(String nome);
}
