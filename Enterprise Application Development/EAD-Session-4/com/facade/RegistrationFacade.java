package com.facade;

import java.sql.Date;

import com.dao.UserDao;
import com.enums.Status;
import com.model.User;

public class RegistrationFacade {
    
    public static Status insertUser(String firstName,String lastName,String email,String password,Date dateOfBirth,String contactNumber,String organization)
    {
        User user=new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        user.setDateOfBirth(dateOfBirth);
        user.setContactNumber(contactNumber);
        user.setOrganization(organization);
        Status status=UserDao.insertUser(user);
        return status;
    }

}
