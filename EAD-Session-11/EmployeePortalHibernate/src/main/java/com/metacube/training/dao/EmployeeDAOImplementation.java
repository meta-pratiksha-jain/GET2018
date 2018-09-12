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

import com.metacube.training.model.Employee;

@Repository
@Transactional
public class EmployeeDAOImplementation implements EmployeeDAO{
	/*
	public String INSERT="INSERT INTO Employee(first_name,middle_name,last_name,email,date_of_birth,gender) "
	           + "VALUES(?,?,?,?,?,?,?)";
	public static final String GET_ALL="SELECT * FROM Employee";
	public static final String CHECK_EMPLOYEE_LOGIN="SELECT * FROM Employee WHERE email=? AND password=?";
	public static final String ENABLE_EMPLOYEE="UPDATE Employee SET is_enable=true WHERE id=?";
	public static final String DISABLE_EMPLOYEE="UPDATE Employee SET is_enable=false WHERE id=?";
	JdbcTemplate jdbcTemplate;
	
	@Autowired
    public EmployeeDAOImplementation(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
	*/
	 @Autowired
	    private SessionFactory sessionFactory;
	 
	@Override
	public boolean addEmployee(Employee employee) {
		/*int insertedRows=jdbcTemplate.update(INSERT,employee.getFirstName(),employee.getMiddleName(),employee.getLastName(),employee.getEmail(),employee.getDateOfBirth(),employee.getGender());
        if(insertedRows==0)
        {
            return false;
        }
        return true;*/
		Session session=null;
    	try{
    	session=sessionFactory.openSession();
    	Transaction transaction=session.beginTransaction();
    	session.save(employee);
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
	public Employee login(String email, String password) {
		/*Employee employee=jdbcTemplate.queryForObject(CHECK_EMPLOYEE_LOGIN, new Object[]{email,password},new EmployeeMapper());
		if(employee.getId()==0)
		{
			return null;
		}
		else 
		{
			return employee;
		}*/
		Session session=sessionFactory.getCurrentSession();
        Criteria criteria=session.createCriteria(Employee.class);
        criteria.add(Restrictions.eq("email",email));
        criteria.add(Restrictions.eq("password",password));
        return (Employee) criteria.uniqueResult();
	}

	@Override
	public List<Employee> getAllEmployees() {
		/*List<Employee> listOfEmployee=jdbcTemplate.query(GET_ALL, new EmployeeMapper());
        return listOfEmployee;*/
		@SuppressWarnings("unchecked")
		TypedQuery<Employee> query=sessionFactory.getCurrentSession().createQuery("from Employee");
    	return query.getResultList();

	}

	@Override
	public boolean enableEmployee(int id) {
		/*int updatedRows=jdbcTemplate.update(ENABLE_EMPLOYEE,id);
		if(updatedRows==0)
		{
			return false;
		}*/
		return true;
	}

	@Override
	public boolean disableEmployee(int id) {
		/*int updatedRows=jdbcTemplate.update(DISABLE_EMPLOYEE,id);
		if(updatedRows==0)
		{
			return false;
		}*/
		return true;
	}

}