package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metacube.training.model.Skill;

@Repository
public interface SkillRepository<P> extends JpaRepository<Skill, Integer> {

}
