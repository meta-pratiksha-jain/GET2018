package com.facade;

import com.dao.UserDao;
import com.enums.Status;

public class LoginFacade {
    
    public static Status validateUserLogin(String email,String password)
    {
        Status status=UserDao.validateUserLogin(email, password);
        return status;
    }

}