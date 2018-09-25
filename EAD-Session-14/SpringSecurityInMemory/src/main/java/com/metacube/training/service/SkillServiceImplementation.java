package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Skill;
import com.metacube.training.repository.SkillRepository;

@Service
public class SkillServiceImplementation implements SkillService {
    @Autowired
    SkillRepository<Skill> skillRepository;
    //SkillDAO skillDAO;

    @Override
    @Transactional
    public boolean addSkill(Skill skill) {
    	try{
			skillRepository.save(skill);
		}catch(Exception e){
			return false;
		}
		return true;
    }

    @Override
    @Transactional
    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

}
