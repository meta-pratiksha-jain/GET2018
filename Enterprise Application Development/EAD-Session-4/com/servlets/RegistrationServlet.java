package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.enums.Status;
import com.facade.ProfileFacade;
import com.facade.RegistrationFacade;
import com.model.User;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Date date=Date.valueOf(request.getParameter("dateOfBirth"));
        String contactNumber = request.getParameter("contact");
        String organization = request.getParameter("organization");
        Status status=RegistrationFacade.insertUser(firstName, lastName, email, password, date, contactNumber, organization);
        String url="";
        String message="message";
        switch(status)
        {
        case DUPLICATE:
            url="/registration.html";
            message="User with "+email+" already exists";
            break;
        case FAILED:
            url="/registration.html";
            message="OOPS!!Registration failed.";
            break;
        case SUCCESS:
            url="/profile.jsp";
            User user=ProfileFacade.getUser(email);
            request.setAttribute("user", user);
            HttpSession oldSession = request.getSession(false);
            if (oldSession != null) {
                oldSession.invalidate();
            }
            //generate a new session
            HttpSession newSession = request.getSession(true);
            message="Congratulations!! you are registered successfully...Welcome to our site";
            break;    
        }
        PrintWriter out=response.getWriter();
        out.println("<script>alert(\""+message+"\")</script>");  
        RequestDispatcher dispatcher=request.getRequestDispatcher(url);
        dispatcher.include(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

}
