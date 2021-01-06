package com.drugs.main.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.drugs.main.model.Employee;

public class EmployeeDetailsImpl implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	
	private String email;
	private String password;
	
	public EmployeeDetailsImpl(Employee empl) {
		this.email = empl.getEmail();
		this.password=empl.getPassword();
	}
	
	public EmployeeDetailsImpl() {
		
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}
	
	public String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}

	
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
 
	
}
