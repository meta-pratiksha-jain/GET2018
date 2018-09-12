package com.metacube.training.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.metacube.training.model.Skill;

@Repository
@Transactional
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
    	Session session=null;
    	try{
    	session=sessionFactory.openSession();
    	Transaction transaction=session.beginTransaction();
    	session.save(skill);
    	transaction.commit();
    	return true;
    	}
    	catch(Exception exception)
    	{
    		return false;
    	}
    	finally{
    		if(session!=null)
    		{
    		session.close();
    		}
    	}
    }

    @Override
    public List<Skill> getAllSkills() {
       /* List<Skill> listOfSkill=jdbcTemplate.query(GET_ALL, new SkillMapper());
        return listOfSkill;*/
    	@SuppressWarnings("unchecked")
		TypedQuery<Skill> query=sessionFactory.getCurrentSession().createQuery("from Skill");
    	return query.getResultList();
    }
    
}