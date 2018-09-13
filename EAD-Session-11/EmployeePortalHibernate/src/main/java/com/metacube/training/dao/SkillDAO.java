package com.metacube.training.dao;

import java.util.List;
import com.metacube.training.model.Skill;

public interface SkillDAO {
    
    
    
    public boolean addSkill(Skill skill);
    
    public List<Skill> getAllSkills();

}
