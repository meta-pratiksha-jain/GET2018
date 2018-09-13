package com.metacube.training.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.mappers.SkillMapper;
import com.metacube.training.model.Skill;

@Repository
public class SkillDAOImplementation implements SkillDAO{
    private JdbcTemplate jdbcTemplate;
    
public String INSERT="INSERT INTO Skill(name) VALUES(?)";
    
    public String GET_ALL="SELECT id,name FROM Skill";

    @Autowired
    public SkillDAOImplementation(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
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
    public List<Skill> getAllSkills() {
        List<Skill> listOfSkill=jdbcTemplate.query(GET_ALL, new SkillMapper());
        return listOfSkill;
    }
    
}
