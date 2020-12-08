package org.myschool.secretary.repository;

import java.util.List;

import org.myschool.secretary.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurmaRepository extends JpaRepository<Turma, Long> {
	public List<Turma> findAllByTurmaContainingIgnoreCase(String turma);
}
