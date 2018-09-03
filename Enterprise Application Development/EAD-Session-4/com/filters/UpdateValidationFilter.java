package com.filters;

import java.io.IOException;

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
 * Servlet Filter implementation class UpdateValidationFilter
 */
@WebFilter("/UpdateValidationFilter")
public class UpdateValidationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public UpdateValidationFilter() {
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
        String contactNumber = request.getParameter("contact");
        boolean isFirstNameVaild=Validation.validateName(firstName);
        boolean isLastNameValid=Validation.validateName(lastName);
        boolean isEmailValid=Validation.validateEmail(email);
        boolean isContactValid=Validation.validateContact(contactNumber);
        System.out.println(isFirstNameVaild);
        System.out.println(isLastNameValid);
        System.out.println(isEmailValid);
        System.out.println(isContactValid);
        if(isFirstNameVaild && isLastNameValid && isEmailValid && isContactValid)
        {
            // pass the request along the filter chain
            chain.doFilter(request, response);
        }
        else
        {
            RequestDispatcher dispatcher=request.getRequestDispatcher("/editUser.jsp");
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
