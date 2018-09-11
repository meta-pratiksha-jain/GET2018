package com.metacube.training.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.mappers.SkillMapper;
import com.metacube.training.model.Project;
import com.metacube.training.model.Skill;

@Repository
public class SkillDAOImplementation implements SkillDAO{
   /* private JdbcTemplate jdbcTemplate;
    
public String INSERT="INSERT INTO Skill(name) VALUES(?)";
    
    public String GET_ALL="SELECT id,name FROM Skill";

    @Autowired
    public SkillDAOImplementation(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }*/
    
	@Autowired
    private SessionFactory sessionFactory;
	
    @Override
    public boolean addSkill(Skill skill) {
       /* int insertedRows=jdbcTemplate.update(INSERT,skill.getName());
        if(insertedRows==0)
        {
            return false;
        }
        return true;*/
    	try{
        	Session session=sessionFactory.getCurrentSession();
        	Transaction transaction=session.beginTransaction();
        	session.save(skill);
        	transaction.commit();
        	session.close();
        	return true;
        	}
        	catch(Exception exception)
        	{
        		return false;
        	}
    }

    @Override
    public List<Skill> getAllSkills() {
       /* List<Skill> listOfSkill=jdbcTemplate.query(GET_ALL, new SkillMapper());
        return listOfSkill;*/
    	@SuppressWarnings("unchecked")
		TypedQuery<Project> query=sessionFactory.getCurrentSession().createQuery("from Skill");
    	return query.getResultList();
    }
    
}
