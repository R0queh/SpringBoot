package com.drugs.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.drugs.main.model.Drugs;

public interface DrugsRepository extends JpaRepository<Drugs, Long>{
	
	//public List<Drugs> findAllByDrugsContainingIgnoreCase();

}
