package com.validation;

public class Validation {
    
    public static boolean validateName(String name)
    {
        if(name.matches("[A-Za-z]{2,}"))
        {
            return true;
        }
        return false;
    }
    
    public static boolean validateEmail(String email)
    {
        if(email.matches("^([a-zA-Z])([a-zA-Z0-9_.-])*@([a-zA-Z0-9_.-])+\\.([a-zA-Z])+([a-zA-Z])+$"))
        {
            return true;
        }
        return false;
    }
    
    public static boolean validatePassword(String password)
    {
        if(password.matches("^(?=.*[A-Z])(?=.*[!@#$%^&*-_])(?=.*[0-9])(?=.*[a-z]).{8,}$"))
        {
            return true;
        }
        return false;
    }
    

    public static boolean MatchPassword(String confirmPassword,String password)
    {
        if(password.equals(confirmPassword))
        {
            return true;
        }
        return false;
    }
    

    public static boolean validateContact(String contact)
    {
        if(contact.matches("^([0-9]){8,}$"))
        {
            return true;
        }
        return false;
    }

}
