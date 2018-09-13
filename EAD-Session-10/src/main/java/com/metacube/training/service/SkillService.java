package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.Skill;

public interface SkillService {
    public boolean addSkill(Skill skill);
    
    public List<Skill> getAllSkills();

}
