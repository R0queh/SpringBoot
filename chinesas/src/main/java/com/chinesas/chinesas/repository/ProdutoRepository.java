package com.chinesas.chinesas.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chinesas.chinesas.model.Produtos;

@Repository
public interface ProdutoRepository extends JpaRepository<Produtos, Long>{
	List<Produtos> findAllByPrecoBetween(BigDecimal ini, BigDecimal fim);
	
}