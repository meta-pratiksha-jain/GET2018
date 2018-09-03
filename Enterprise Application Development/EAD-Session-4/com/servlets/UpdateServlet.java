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
import com.facade.UpdateFacade;
import com.model.User;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        int id=Integer.parseInt(request.getParameter("id"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        Date date=Date.valueOf(request.getParameter("dateOfBirth"));
        String contactNumber = request.getParameter("contact");
        String organization = request.getParameter("organization");
        Status status=UpdateFacade.updateUser(id,firstName, lastName, email, date, contactNumber, organization);
        String message="message";
        switch(status)
        {
        case FAILED:
            message="OOPS!!Updation failed.";
            break;
        case SUCCESS:
            message="Your profile is updated";
            break;    
        }
        PrintWriter out=response.getWriter();
        out.println("<script>alert(\""+message+"\")</script>");
        User user=ProfileFacade.getUser(email);
        request.setAttribute("user", user);
        RequestDispatcher dispatcher=request.getRequestDispatcher("/profile.jsp");
        dispatcher.include(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

}
