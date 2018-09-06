package com.dao;

public class AdvertisementQuery {
	
	public static final String INSERT_ADVERTISEMENT="INSERT INTO Advertisement(title,description,category_id) "
			                                      + "values(?,?,?)";
	
	public static final String GET_ALL="SELECT id,title,description,category_id "
			                         + "FROM Advertisement";
	
	public static final String GET_ADVERTISEMENT_BY_CATEGORY_ID="SELECT id,title,description,category_id "
                                                              + "FROM Advertisement WHERE category_id=?";
	
	public static final String UPDATE_ADVERTISEMENT_TITLE="UPDATE Advertisement "
			                                            + "SET title=? "
			                                            + "WHERE id=?";
	
	public static final String DELETE_ADVERTISEMENT="DELETE "
			                                      + "FROM Advertisement "
			                                      + "WHERE id=?";

}
