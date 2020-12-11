package org.roquehtech.blogPessoal.repository;

import java.util.List;

import org.roquehtech.blogPessoal.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface temaRepository extends JpaRepository<Tema, Long>{

	public List<Tema> findAllByDescricaoContainingIgnoreCase(String descricao);
		
}
