package com.facade;

import com.dao.UserDao;
import com.model.User;

public class ProfileFacade {
    public static User getUser(String email)
    {
        User user=UserDao.searchUser(email);
        String userProfile=user.getProfileImage();
        if(userProfile==null)
        {
            user.setProfileImage("images/profile.png");
        }
        System.out.println(user.getProfileImage());
        return user;
    }

}
