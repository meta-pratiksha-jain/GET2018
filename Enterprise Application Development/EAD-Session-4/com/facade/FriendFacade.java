package com.facade;

import java.util.List;

import com.dao.UserDao;
import com.model.User;

public class FriendFacade {
    
    public static List<User> getFriends(String email,String organization)
    {
        List<User> friends=UserDao.getFriends(email, organization);
        return friends;
    }

}
