package com.facade;

import java.sql.Date;

import com.dao.UserDao;
import com.enums.Status;
import com.model.User;

public class UpdateFacade {
    public static Status updateUser(int id,String firstName,String lastName,String email,Date dateOfBirth,String contactNumber,String organization)
    {
        User user=new User();
        user.setId(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setDateOfBirth(dateOfBirth);
        user.setContactNumber(contactNumber);
        user.setOrganization(organization);
        Status status=UserDao.updateUser(user);
        return status;
    }

}
