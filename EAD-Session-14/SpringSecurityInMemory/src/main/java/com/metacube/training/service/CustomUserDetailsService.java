package com.metacube.training.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.metacube.training.model.Employee;
import com.metacube.training.model.Roles;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	UserRolesService userRolesService;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		Employee user=employeeService.getEmployeeByEmail(username);
		if(user==null){
            throw new UsernameNotFoundException("Username not found"); 
        }
            return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), 
                 user.getIsEnable(), true, true, true, getGrantedAuthorities(username));
	}
	
	private List<GrantedAuthority> getGrantedAuthorities(String username){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        List<Roles> listOfUserRoles=userRolesService.getUserRoles(username);
        for(Roles userRoles : listOfUserRoles){
            authorities.add(new SimpleGrantedAuthority("ROLE_"+userRoles.getRole()));
        }
        return authorities;
    }

}
