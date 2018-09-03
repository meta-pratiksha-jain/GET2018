package com.facade;

import java.util.List;

import com.dao.AdvertisementDao;
import com.enums.Status;
import com.model.Advertisement;


public class AdvertisementFacade {
	
	public static String createAdvertisement(Advertisement advertisement)
	{
		Status status=AdvertisementDao.createAdvertisement(advertisement);
		String message="";
		switch(status)
		{
		case DUPLICATE:
			message=advertisement.getTitle()+" already exists";
			break;
		case FAILED:
			message="advertisement insertion failed";
			break;
		case SUCCESS:
			message="advertisement created successfully";
			break;
		}
		return message;
	}
	
	public static List<Advertisement> getAdvertisements()
	{
		List<Advertisement> listOfAdvertisement=AdvertisementDao.getAdvertisements();
		return listOfAdvertisement;
	}
	
	public static List<Advertisement> getAdvertisements(int categoryId)
	{
		List<Advertisement> listOfAdvertisement=AdvertisementDao.getAdvertisements(categoryId);
		return listOfAdvertisement;
	}
	
	public static String updateTitle(String title,int id)
	{
		Status status=AdvertisementDao.updateTitle(title, id);
		String message="";
		switch(status)
		{
		case NOT_FOUND:
			message="advertisement doesn't exist";
			break;
		case FAILED:
			message="advertisement title is not updated";
			break;
		case SUCCESS:
			message="advertisement title is updated";
			break;
		}
		return message;
	}
	
	public static String deleteAdvertisement(int id)
	{
		Status status=AdvertisementDao.deleteAdvertisement(id);
		String message="";
		switch(status)
		{
		case NOT_FOUND:
			message="advertisement doesn't exist";
			break;
		case FAILED:
			message="advertisement deletion failed";
			break;
		case SUCCESS:
			message="advertisement title is deleted";
			break;
		}
		return message;
	}

}
