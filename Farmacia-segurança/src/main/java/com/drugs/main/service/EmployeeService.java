package com.drugs.main.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.drugs.main.model.Employee;
import com.drugs.main.model.EmployeeLogin;
import com.drugs.main.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
	public Employee employeeRegister(Employee empl) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		Optional<Employee> isEmployee = repository.findByEmail(empl.getEmail());
		if(isEmployee.isPresent()) {
			return null;
		}
		
		String senhaEnconder = encoder.encode(empl.getPassword());
		empl.setPassword(senhaEnconder);
		
		return repository.save(empl);
	}
	
	public Optional<EmployeeLogin> logar(Optional<EmployeeLogin> empl){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Employee> employeer= repository.findByEmail(empl.get().getEmail());
		
		if(employeer.isPresent()) {
			if(encoder.matches(empl.get().getPassword(), employeer.get().getPassword())){
				
				String auth = empl.get().getEmail()+ ":" + empl.get().getPassword();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);
				
				empl.get().setToken(authHeader);
				empl.get().setName(employeer.get().getName());
				
				return empl;
			}
		}
		return null;
	}
}
