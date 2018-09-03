package com.dao;

public class CategoryQuery {
	
	public static final String INSERT_CATEGORY="INSERT INTO CATEGORY(name)"
			                                 + " values(?)";
	
	public static final String GET_ALL="SELECT id,name "
			                         + "FROM Category";
	
	public static final String UPDATE_NAME="UPDATE Category "
			                             + "SET name=? "
			                             + "WHERE id=?";
	
	public static final String GET_CATEGORY="SELECT id,name "
			                              + "FROM Category "
			                              + "WHERE id=?";

}
