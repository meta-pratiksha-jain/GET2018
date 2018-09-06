package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.enums.Status;
import com.facade.LoginFacade;
import com.facade.ProfileFacade;
import com.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        Status status=LoginFacade.validateUserLogin(email, password);
        String url="";
        String message="";
        switch(status)
        {
        case NOT_FOUND:
            url="/login.html";
            message="Email or password is incorrect";
            break;
        case FAILED:
            url="/login.html";
            message="OOPS!!Login failed.";
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
            message="Login successful";
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
        doGet(request, response);
    }

}