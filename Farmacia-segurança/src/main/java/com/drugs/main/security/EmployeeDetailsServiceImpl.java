package com.drugs.main.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.drugs.main.model.Employee;
import com.drugs.main.repository.EmployeeRepository;

@Service
public class EmployeeDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Employee> empl = employeeRepository.findByEmail(email);
		empl.orElseThrow(() -> new UsernameNotFoundException(email + " not found."));
		
		return empl.map(EmployeeDetailsImpl::new).get();
	}
}
