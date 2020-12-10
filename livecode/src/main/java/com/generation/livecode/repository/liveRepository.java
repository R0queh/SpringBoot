package com.generation.livecode.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.generation.livecode.model.LiveCoding;

@Repository // boas praticas para o Spring enteder realmente que estamos falando de um repository
public interface liveRepository extends JpaRepository<LiveCoding, Long>{
	
	public List<LiveCoding> findAllByTituloContainingIgnoreCase(String titulo);
	
	@Query(value ="select * from tb_live_code where qtd_participantes > :valor", nativeQuery = true)
	public List<LiveCoding> maiorQue (@Param("valor") int valor);
}
