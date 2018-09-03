package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.enums.Status;
import com.model.Advertisement;
import com.model.Category;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class AdvertisementDao {
	
	public static final Status createAdvertisement(Advertisement advertisement)
	{
		String query=AdvertisementQuery.INSERT_ADVERTISEMENT;
        try(Connection connection=DatabaseConnection.getConnection();
              //Allocate statement object in connection
                PreparedStatement statement = connection.prepareStatement(query); ){
            statement.setString(1,advertisement.getTitle());
            statement.setString(2,advertisement.getDescription());
            statement.setInt(3,advertisement.getCategoryId());
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
	
	public static final List<Advertisement> getAdvertisements()
	{
		List<Advertisement> listOfAdvertisement;
		String query=AdvertisementQuery.GET_ALL;
        try(Connection connection=DatabaseConnection.getConnection();
              //Allocate statement object in connection
                PreparedStatement statement = connection.prepareStatement(query); ){
            ResultSet resultSet=statement.executeQuery();
            listOfAdvertisement=getAdvertisements(resultSet);
        }
        catch (SQLException exception) {
        	exception.printStackTrace();
            return null;
        }
        return listOfAdvertisement;
	}
	
	public static final List<Advertisement> getAdvertisements(int categoryId)
	{
		List<Advertisement> listOfAdvertisement;
		String query=AdvertisementQuery.GET_ADVERTISEMENT_BY_CATEGORY_ID;
        try(Connection connection=DatabaseConnection.getConnection();
              //Allocate statement object in connection
                PreparedStatement statement = connection.prepareStatement(query); ){
            statement.setInt(1, categoryId);
            ResultSet resultSet=statement.executeQuery();
            listOfAdvertisement=getAdvertisements(resultSet);
        }
        catch (SQLException exception) {
        	exception.printStackTrace();
            return null;
        }
        return listOfAdvertisement;
	}
	
	public static final Status updateTitle(String title,int id)
	{
		String query=AdvertisementQuery.UPDATE_ADVERTISEMENT_TITLE;
        try(Connection connection=DatabaseConnection.getConnection();
              //Allocate statement object in connection
                PreparedStatement statement = connection.prepareStatement(query); ){
        	statement.setString(1,title);
            statement.setInt(2,id);
            int updatedRows=statement.executeUpdate();
            if(updatedRows==0)
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
	
	public static final Status deleteAdvertisement(int id)
	{
		String query=AdvertisementQuery.DELETE_ADVERTISEMENT;
        try(Connection connection=DatabaseConnection.getConnection();
              //Allocate statement object in connection
                PreparedStatement statement = connection.prepareStatement(query); ){
            statement.setInt(1,id);
            int deletedRows=statement.executeUpdate();
            if(deletedRows==0)
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
	
	private static List<Advertisement> getAdvertisements(ResultSet resultSet)
	{
		List<Advertisement> listOfAdvertisement=new ArrayList<Advertisement>();
		try {
			while(resultSet.next())
			{
				Advertisement advertisement=new Advertisement();
				advertisement.setId(resultSet.getInt("id"));
				advertisement.setTitle(resultSet.getString("title"));
				advertisement.setDescription(resultSet.getString("description"));
				advertisement.setCategoryId(resultSet.getInt("category_id"));
				listOfAdvertisement.add(advertisement);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listOfAdvertisement;
	}

}
