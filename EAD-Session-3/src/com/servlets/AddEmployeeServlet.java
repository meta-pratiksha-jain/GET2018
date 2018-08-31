package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DatabaseHelper;

/**
 * Servlet implementation class AddEmployeeServlet
 */
@WebServlet("/AddEmployeeServlet")
public class AddEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        int age = Integer.parseInt(request.getParameter("age"));
        boolean isInserted=DatabaseHelper.addEmployee(firstName, lastName, email, age);
        PrintWriter out = response.getWriter();
        if(isInserted)
        {
            out.println("<script>alert(\"Data inserted successfully\")</script>");
            RequestDispatcher dispatcher=request.getRequestDispatcher("/index.html");
            dispatcher.include(request, response);
        }
        else
        {
            out.println("<script>alert(\"Data not inserted\")</script>");
            RequestDispatcher dispatcher=request.getRequestDispatcher("/addEmployee.html");
            dispatcher.include(request, response);
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

}
