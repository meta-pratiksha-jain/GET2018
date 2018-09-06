package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.enums.Status;
import com.model.User;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class UserDao {
	
	public static final Status insertUser(User user)
	{
		String query=UserQuery.INSERT_USER;
        try(Connection connection=DatabaseConnection.getConnection();
              //Allocate statement object in connection
                PreparedStatement statement = connection.prepareStatement(query); ){
                statement.setString(1,user.getFirstName());
                statement.setString(2,user.getLastName());
                statement.setString(3,user.getEmail());
                statement.setString(4,user.getPassword());
                statement.setString(5,user.getContactNumber());
                statement.setString(6,user.getOrganization());
                statement.setDate(7, user.getDateOfBirth());
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
	
	public static final Status validateUserLogin(String email,String password)
	{
		String query=UserQuery.VALIDATE_USER;
		 try(Connection connection=DatabaseConnection.getConnection();
	              //Allocate statement object in connection
	                PreparedStatement statement = connection.prepareStatement(query); ){
	                statement.setString(1,email);
	                statement.setString(2,password);
	                ResultSet resultSet=statement.executeQuery();
	                if(!resultSet.next())
	                {
	                	return Status.NOT_FOUND;
	                }
	        }
	        catch (SQLException exception) {
	        	exception.printStackTrace();
	        	return Status.FAILED;
	        }
	        return Status.SUCCESS;
	}
	
	public static final User searchUser(String email)
	{
		User user=new User();
		String query=UserQuery.SEARCH_USER;
		 try(Connection connection=DatabaseConnection.getConnection();
	              //Allocate statement object in connection
	                PreparedStatement statement = connection.prepareStatement(query); ){
	                statement.setString(1,email);
	                ResultSet resultSet=statement.executeQuery();
	                List<User> listOfUser=getUsers(resultSet);
	                if(listOfUser!=null)
	                {
	                	user=listOfUser.get(0);
	                }
	        }
	        catch (SQLException exception) {
	        	exception.printStackTrace();
	        	return null;
	        }
	        return user;
	}
	
	public static final Status updateUser(User user)
	{
		String query=UserQuery.UPDATE_USER;
        try(Connection connection=DatabaseConnection.getConnection();
              //Allocate statement object in connection
                PreparedStatement statement = connection.prepareStatement(query); ){
                statement.setString(1,user.getFirstName());
                statement.setString(2,user.getLastName());
                statement.setString(3,user.getEmail());
                statement.setString(4,user.getContactNumber());
                statement.setString(5,user.getOrganization());
                statement.setDate(6, user.getDateOfBirth());
                statement.setInt(7, user.getId());
                statement.executeUpdate();
        }
        catch (SQLException exception) {
        	exception.printStackTrace();
        	return Status.FAILED;
        }
        return Status.SUCCESS;
	}
	
	public static final List<User> getFriends(String email,String organization)
	{
		List<User> friends=new ArrayList<User>();
		String query=UserQuery.USER_FREINDS;
        try(Connection connection=DatabaseConnection.getConnection();
              //Allocate statement object in connection
                PreparedStatement statement = connection.prepareStatement(query); ){
                statement.setString(1,organization);
                statement.setString(2,email);
                ResultSet resultSet=statement.executeQuery();
                friends=getUsers(resultSet);
        }
        catch (SQLException exception) {
        	exception.printStackTrace();
        	return null;
        }
        return friends;
	}
	
	private static List<User> getUsers(ResultSet resultSet)
	{
		List<User> listOfUsers=new ArrayList<User>();
		try {
			while(resultSet.next())
			{
				User user=new User();
				user.setId(resultSet.getInt("id"));
				user.setFirstName(resultSet.getString("first_name"));
				user.setLastName(resultSet.getString("last_name"));
				user.setEmail(resultSet.getString("email"));
				user.setContactNumber(resultSet.getString("contact_number"));
				user.setDateOfBirth(Date.valueOf(resultSet.getString("date_of_birth")));
				user.setOrganization(resultSet.getString("organization"));
				user.setProfileImage(resultSet.getString("profile_image"));
				listOfUsers.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return listOfUsers;
	}

}