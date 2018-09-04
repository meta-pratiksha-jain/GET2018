package com.resources;

import java.util.List;

import javax.ws.rs.Consumes;
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
import com.model.Category;

@Path("/Category")
public class CategoryResource {
	
	@POST
	@Path("/createCategory")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createCategory(Category category)
	{
		String message=CategoryFacade.createCategory(category);
		response=Response.ok(message,MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Path("/getAllCategories")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Category> getAllCategories()
	{
		List<Category> listOfCategory=CategoryFacade.getAllCategories();
		return listOfCategory;
	}
	
	@PUT
	@Path("/updateCategoryName/{id}/{name}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateName(@PathParam("id") int id,@PathParam("name") String name)
	{
		String message=CategoryFacade.updateName(name,id);
		response=Response.ok(message,MediaType.APPLICATION_JSON).build();
	}

}
