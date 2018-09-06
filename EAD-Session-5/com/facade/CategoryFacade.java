package com.facade;

import java.util.List;

import com.dao.CategoryDao;
import com.enums.Status;
import com.model.Category;

public class CategoryFacade {
	
	public static String createCategory(Category category)
	{
		Status status=CategoryDao.createCategory(category);
		String message="";
		switch(status)
		{
		case DUPLICATE:
			message=category.getName()+" already exists";
			break;
		case FAILED:
			message="category insertion failed";
			break;
		case SUCCESS:
			message="category created successfully";
			break;
		}
		return message;
	}
	
	public static List<Category> getAllCategories()
	{
		List<Category> listOfCategory=CategoryDao.getAllCategories();
		return listOfCategory;
	}
	
	public static String updateName(String name,int id)
	{
		Status status=CategoryDao.updateName(id, name);
		String message="";
		switch(status)
		{
		case DUPLICATE:
			message=name+" already exists";
			break;
		case FAILED:
			message="category updation failed";
			break;
		case SUCCESS:
			message="category updated successfully";
			break;
		case NOT_FOUND:
			message="category doesn't exist";
			break;
		}
		return message;
	}

}
