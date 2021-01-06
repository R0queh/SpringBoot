package com.drugs.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.drugs.main.model.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long>{
	
}
