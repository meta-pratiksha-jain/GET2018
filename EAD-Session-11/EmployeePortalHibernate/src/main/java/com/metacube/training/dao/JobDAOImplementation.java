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

import com.metacube.training.mappers.JobMapper;
import com.metacube.training.mappers.ProjectMapper;
import com.metacube.training.model.Job;
import com.metacube.training.model.Project;

@Repository
public class JobDAOImplementation implements JobDAO {
   /* JdbcTemplate jdbcTemplate;
    public static final String INSERT="INSERT INTO Job(title) VALUES(?)";
    
    public static final String GET_ALL="SELECT * FROM Job";

    @Autowired
    public JobDAOImplementation(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }*/
	
	@Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public boolean addJob(Job job) {
       /* int insertedRows=jdbcTemplate.update(INSERT,job.getTitle());
        if(insertedRows==0)
        {
            return false;
        }
        return true;*/
        try{
        	Session session=sessionFactory.getCurrentSession();
        	Transaction transaction=session.beginTransaction();
        	session.save(job);
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
	public List<Job> getAllJobs() {
		/*List<Job> listOfJob=jdbcTemplate.query(GET_ALL, new JobMapper());
        return listOfJob;*/
		@SuppressWarnings("unchecked")
		TypedQuery<Job> query=sessionFactory.getCurrentSession().createQuery("from Job");
    	return query.getResultList();
	}

}
