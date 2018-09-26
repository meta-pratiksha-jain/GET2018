package com.metacube.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metacube.training.model.Roles;

@Repository
public interface UserRolesRepository extends JpaRepository<Roles, Integer> {
	
	public List<Roles> findRolesByUsername(String username);

}
