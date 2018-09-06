package com.dao;

public class UserQuery {
	
	public static final String INSERT_USER="INSERT INTO User(first_name,last_name,email,password,contact_number,organization,date_of_birth,profile_image) "
			                             + "values(?,?,?,?,?,?,?,LOAD_FILE('./WebContent/images/profile.png'))";
	
	public static final String VALIDATE_USER="SELECT id,first_name,last_name,email,password,contact_number,organization,date_of_birth "
			                               + "FROM User "
			                               + "WHERE email=? AND password=?";
	
	public static final String SEARCH_USER="SELECT id, first_name,last_name,email,contact_number,organization,date_of_birth,profile_image "
                                         + "FROM User "
                                         + "WHERE email=?";
	
	public static final String UPDATE_USER="UPDATE USER "
			                             + "SET first_name=?,"
			                             + "last_name=?,"
			                             + "email=?,"
			                             + "contact_number=?,"
			                             + "organization=?,"
			                             + "date_of_birth=? "
			                             + "WHERE id=?";
	
	public static final String USER_FREINDS="SELECT id,first_name,last_name,email,contact_number,organization,date_of_birth,profile_image\n"
                                          + "FROM User\n"
                                          + "WHERE organization=? AND email<>?";
}