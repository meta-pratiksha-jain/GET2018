package com.filters;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.validation.Validation;

/**
 * Servlet Filter implementation class RegistrationValidationFilter
 */
@WebFilter("/RegistrationValidationFilter")
public class RegistrationValidationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public RegistrationValidationFilter() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
        // TODO Auto-generated method stub
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // TODO Auto-generated method stub
        // place your code here
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword=request.getParameter("confirmPassword");
        String contactNumber = request.getParameter("contact");
        
        boolean isFirstNameVaild=Validation.validateName(firstName);
        boolean isLastNameValid=Validation.validateName(lastName);
        boolean isEmailValid=Validation.validateEmail(email);
        boolean isPasswordValid=Validation.validatePassword(password);
        boolean isPasswordMatched=Validation.MatchPassword(confirmPassword, password);
        boolean isContactValid=Validation.validateContact(contactNumber);
        if(isFirstNameVaild && isLastNameValid && isEmailValid && isPasswordValid && isPasswordMatched && isContactValid)
        {
            // pass the request along the filter chain
            chain.doFilter(request, response);
        }
        else
        {
            RequestDispatcher dispatcher=request.getRequestDispatcher("/registration.html");
            dispatcher.include(request, response);
        }
        
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        // TODO Auto-generated method stub
    }

}
