package com.dao;

import java.sql.Connection;

import com.pojo.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class DatabaseHelper {
    public static boolean addEmployee(String firstName,String lastName,String email,int age)
    {
        String query=Query.INSERT_EMPLOYEE;
        try(Connection connection=DatabaseConnection.getConnection();
              //Allocate statement object in connection
                PreparedStatement statement = connection.prepareStatement(query); ){
                statement.setString(1,firstName);
                statement.setString(2,lastName);
                statement.setString(3,email);
                statement.setInt(4,age);
                int insertedRows=statement.executeUpdate();
                if(insertedRows>0)
                {
                    return true;
                }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return false;
    }
    
    public static List<Employee> getAllEmployees()
    {
        List<Employee> listOfEmployee=new ArrayList<Employee>();
        String query=Query.SHOW_EMPLOYEES;
        try(Connection connection=DatabaseConnection.getConnection();
                //Allocate statement object in connection
                PreparedStatement statement = connection.prepareStatement(query); )
        {
            ResultSet result=statement.executeQuery();
            listOfEmployee=getEmployees(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfEmployee;
    }
    
    public static List<Employee> searchEmployees(String firstName, String lastName)
    {
        List<Employee> listOfEmployee=new ArrayList<Employee>();
        String query=Query.SEARCH_EMPLOYEES;
        try(Connection connection=DatabaseConnection.getConnection();
                //Allocate statement object in connection
                PreparedStatement statement = connection.prepareStatement(query); )
        {
            statement.setString(1,firstName);
            statement.setString(2,lastName);
            ResultSet result=statement.executeQuery();
            listOfEmployee=getEmployees(result);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return listOfEmployee;
    }
    
    public static Employee getEmployee(int id)
    {
        Employee employee=new Employee();
        String query=Query.SEARCH_EMPLOYEE_BY_ID;
        try(Connection connection=DatabaseConnection.getConnection();
                //Allocate statement object in connection
                PreparedStatement statement = connection.prepareStatement(query); )
        {
            statement.setInt(1,id);
            ResultSet result=statement.executeQuery();
            employee=getEmployees(result).get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }
    
    public static int updateEmployee(int id,String firstName,String lastName,String email,int age)
    {
        String query=Query.UPDATE_EMPLOYEE;
        int updatedRows=0;
        try(Connection connection=DatabaseConnection.getConnection();
              //Allocate statement object in connection
                PreparedStatement statement = connection.prepareStatement(query); ){
            try {
    
                statement.setString(1,firstName);
                statement.setString(2,lastName);
                statement.setString(3,email);
                statement.setInt(4,age);
                statement.setInt(5,id);
                updatedRows=statement.executeUpdate();
            } 
            catch (SQLException sqlException) {
                sqlException.printStackTrace();
                connection.rollback();
            }    
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return updatedRows;
    }
    
    private static List<Employee> getEmployees(ResultSet result)
    {
        List<Employee> listOfEmployee=new ArrayList<Employee>();
        try {
            while(result.next())
            {
                int id=result.getInt("id");
                String first=result.getString("first_name");
                String last=result.getString("last_name");
                String email=result.getString("email");
                int age=result.getInt("age");
                Employee employee=new Employee();
                employee.setId(id);
                employee.setFirstName(first);
                employee.setLastName(last);
                employee.setEmail(email);
                employee.setAge(age);
                listOfEmployee.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfEmployee;
    }

}
