package com.dao;

public final class Query {
    public static final String INSERT_EMPLOYEE="INSERT INTO EMPLOYEE(first_name,last_name,email,age) "
                                      + "values(?,?,?,?);";
    
    public static final String SHOW_EMPLOYEES="SELECT id,first_name,last_name,email,age "
                                     + "FROM Employee ";
            
    public static final String SEARCH_EMPLOYEES="SELECT id,first_name,last_name,email,age "
                                              + "FROM Employee "
                                              + "WHERE first_name=? AND last_name=?";
    
    public static final String SEARCH_EMPLOYEE_BY_ID="SELECT id, first_name,last_name,email,age "
                                                   + "FROM Employee WHERE id=?";
    
    public static final String UPDATE_EMPLOYEE="UPDATE Employee "
                                             + " SET first_name=?,last_name=?,email=?,age=? "
                                             + " WHERE id=?";

}
