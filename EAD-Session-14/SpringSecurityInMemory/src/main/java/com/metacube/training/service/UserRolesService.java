package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.Roles;

public interface UserRolesService {
	
	public List<Roles> getUserRoles(String username);

}
