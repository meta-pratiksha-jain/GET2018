package com.metacube.training.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.metacube.training.model.Project;


@Repository
public interface ProjectRepository<P> extends JpaRepository<Project,Integer> {
	
	@Modifying
	@Query("update Project set is_enable=false where id=?1")
	public int deleteProject(int id);

}
