package com.metacube.training.dao;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.metacube.training.mappers.SkillMapper;
import com.metacube.training.model.Skill;

@Repository
public class SkillDAOImplementation implements SkillDAO{
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean addSkill(Skill skill) {
        int insertedRows=jdbcTemplate.update(INSERT,skill.getName());
        if(insertedRows==0)
        {
            return false;
        }
        return true;
    }

    @Override
    public List<Skill> getAll() {
        List<Skill> listOfSkill=jdbcTemplate.query(GET_ALL, new SkillMapper());
        return listOfSkill;
    }
    
}
