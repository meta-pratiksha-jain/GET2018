package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.model.Roles;
import com.metacube.training.repository.UserRolesRepository;

@Service
public class UserRolesServiceImplemetation implements UserRolesService {
	
	@Autowired
	UserRolesRepository userRolesRepository;

	@Override
	public List<Roles> getUserRoles(String username) {
		return userRolesRepository.findRolesByUsername(username);
	}

}
