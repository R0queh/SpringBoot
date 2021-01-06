package com.drugs.main.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drugs.main.model.Employee;
import com.drugs.main.model.EmployeeLogin;
import com.drugs.main.service.EmployeeService;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "*" , allowedHeaders = "*")
public class EmployeeControler {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/logar")
	public ResponseEntity<EmployeeLogin> Autentication(@RequestBody Optional<EmployeeLogin> empl){
		return employeeService.logar(empl).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Employee> Post(@RequestBody Employee empl){
		Employee employ = employeeService.employeeRegister(empl);
		if(employ == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body
				(employ);
		}
	
}
