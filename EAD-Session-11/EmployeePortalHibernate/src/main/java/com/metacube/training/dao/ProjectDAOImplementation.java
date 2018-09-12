package com.metacube.training.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.metacube.training.model.Project;

@Repository
@Transactional
public class ProjectDAOImplementation implements ProjectDAO {
    /*private JdbcTemplate jdbcTemplate;
    public static final String INSERT="INSERT INTO PROJECT(name,description,start_date,end_date) VALUES(?,?,?,?)";
    public static final String GET_PROJECT_BY_ID="SELECT id,name,description,start_date,end_date FROM PROJECT WHERE id=? AND is_enable=true";
    public static final String GET_ALL="SELECT id,name,description,start_date,end_date,project_logo FROM PROJECT";
    public static final String UPDATE="UPDATE PROJECT SET name=?,description=?,start_date=?,end_date=? WHERE id=?";
    public static final String DELETE="UPDATE PROJECT SET is_enable=FALSE WHERE id=?";
    */
    @Autowired
    private SessionFactory sessionFactory;
    
    /*@Autowired
    public ProjectDAOImplementation(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }*/
    
    @Override
    public boolean createProject(Project project) {
        /*int insertedRows=jdbcTemplate.update(INSERT,project.getName(), project.getDescription(),project.getStartDate(),project.getEndDate());
        if(insertedRows==0)
        {
            return false;
        }
        return true;*/
    	
    	Session session=null;
    	try{
    	session=sessionFactory.openSession();
    	Transaction transaction=session.beginTransaction();
    	session.save(project);
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
    public Project getProjectById(int id) {
        /*Project project= jdbcTemplate.queryForObject(GET_PROJECT_BY_ID, new Object[] {id}, new ProjectMapper());
        return project;
        */
        Session session=sessionFactory.getCurrentSession();
        Criteria criteria=session.createCriteria(Project.class).add(Restrictions.eq("id", id));
        return (Project) criteria.uniqueResult();
    }

    @Override
    public List<Project> getAllProjects() {
       /* List<Project> listOfproject=jdbcTemplate.query(GET_ALL, new ProjectMapper());
        return listOfproject;*/
    	@SuppressWarnings("unchecked")
		TypedQuery<Project> query=sessionFactory.getCurrentSession().createQuery("from Project");
    	return query.getResultList();
    }

    @Override
    public boolean updateProject(Project project) {
        /*int updatedRows=jdbcTemplate.update(UPDATE,project.getName(), project.getDescription(),project.getStartDate(),project.getEndDate(),project.getId());
        if(updatedRows==0)
        {
            return false;
        }
        return true;*/
    	Session session=null;
    	try{
    	session=sessionFactory.openSession();
    	Transaction transaction=session.beginTransaction();
    	
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
    public boolean deleteProject(int id) {
       /* int updatedRows=jdbcTemplate.update(DELETE,id);
        if(updatedRows==0)
        {
            return false;
        }*/
        return true;
    }

}