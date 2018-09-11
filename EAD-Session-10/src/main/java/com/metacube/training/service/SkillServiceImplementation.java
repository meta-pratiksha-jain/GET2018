package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.SkillDAO;
import com.metacube.training.model.Skill;

@Service
public class SkillServiceImplementation implements SkillService {
    @Autowired
    SkillDAO skillDAO;

    @Override
    public boolean addSkill(Skill skill) {
        return skillDAO.addSkill(skill);
    }

    @Override
    public List<Skill> getAllSkills() {
        return skillDAO.getAllSkills();
    }

}
