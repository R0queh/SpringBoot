package com.drugs.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.drugs.main.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	public Optional<Employee> findByEmail(String email);
}
