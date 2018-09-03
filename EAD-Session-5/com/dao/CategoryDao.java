package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.enums.Status;
import com.model.Category;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class CategoryDao {
	
	public static final Status createCategory(Category category)
	{
		String query=CategoryQuery.INSERT_CATEGORY;
        try(Connection connection=DatabaseConnection.getConnection();
              //Allocate statement object in connection
                PreparedStatement statement = connection.prepareStatement(query); ){
            statement.setString(1,category.getName());
            statement.executeUpdate();
        }
        catch(MySQLIntegrityConstraintViolationException duplicateException)
        {
        	duplicateException.printStackTrace();
        	return Status.DUPLICATE;
        }
        catch (SQLException exception) {
        	exception.printStackTrace();
        	return Status.FAILED;
        }
        return Status.SUCCESS;
	}
	
	public static final List<Category> getAllCategories()
	{
		List<Category> listOfCategory;
		String query=CategoryQuery.GET_ALL;
        try(Connection connection=DatabaseConnection.getConnection();
              //Allocate statement object in connection
                PreparedStatement statement = connection.prepareStatement(query); ){
            ResultSet resultSet=statement.executeQuery();
            listOfCategory=getCategories(resultSet);
        }
        catch (SQLException exception) {
        	exception.printStackTrace();
            return null;
        }
        return listOfCategory;
	}
	
	public static final Status updateName(int id,String name)
	{
		String query=CategoryQuery.UPDATE_NAME;
        try(Connection connection=DatabaseConnection.getConnection();
              //Allocate statement object in connection
                PreparedStatement statement = connection.prepareStatement(query); ){
            statement.setString(1,name);
            statement.setInt(2, id);
            int updatedRows=statement.executeUpdate();
            if(updatedRows==0)
            {
              	return Status.NOT_FOUND;
            }
        }
        catch(MySQLIntegrityConstraintViolationException duplicateException)
        {
        	duplicateException.printStackTrace();
        	return Status.DUPLICATE;
        }
        catch (SQLException exception) {
        	exception.printStackTrace();
        	return Status.FAILED;
        }
        return Status.SUCCESS;
	}
	
	private static List<Category> getCategories(ResultSet resultSet)
	{
		List<Category> listOfCategory=new ArrayList<Category>();
		try {
			while(resultSet.next())
			{
				Category category=new Category();
				category.setId(resultSet.getInt("id"));
				category.setName(resultSet.getString("name"));
				listOfCategory.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listOfCategory;
	}

}
