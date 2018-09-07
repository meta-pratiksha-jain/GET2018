package com.metacube.training.dao;

import java.util.List;
import com.metacube.training.model.Skill;

public interface SkillDAO {
    
    public String INSERT="INSERT INTO Skill(name) VALUES(?)";
    
    public String GET_ALL="SELECT id,name FROM Skill";
    
    public boolean addSkill(Skill skill);
    
    public List<Skill> getAll();

}
