package com.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.facade.AdvertisementFacade;
import com.facade.CategoryFacade;
import com.model.Advertisement;

@Path("/Advertisement")
public class AdvertisementResource {
	
	@POST
	@Path("/createAdvertisement")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String createAdvertisement(Advertisement advertisement)
	{
		String message=AdvertisementFacade.createAdvertisement(advertisement);
		return message;
	}
	
	@GET
	@Path("/advertisements")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Advertisement> getAdvertisements()
	{
		List<Advertisement> listOfAdvertisement=AdvertisementFacade.getAdvertisements();
		return listOfAdvertisement;
	}
	
	@GET
	@Path("/Category/{categoryId}/advertisements")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Advertisement> getAdvertisements(@PathParam("categoryId") int categoryId)
	{
		List<Advertisement> listOfAdvertisement=AdvertisementFacade.getAdvertisements(categoryId);
		return listOfAdvertisement;
	}
	
	@PUT
	@Path("/updateAdvertisementTitle/{id}/{title}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateTitle(@PathParam("id") int id,@PathParam("title") String title)
	{
		String message=AdvertisementFacade.updateTitle(title, id);
		return message;
	}
	
	@DELETE
	@Path("/deleteAdvertisement/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteAdvertisement(@PathParam("id") int id)
	{
		String message=AdvertisementFacade.deleteAdvertisement(id);
		return message;
	}

}
