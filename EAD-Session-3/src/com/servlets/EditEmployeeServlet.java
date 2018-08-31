package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DatabaseHelper;
import com.pojo.Employee;

/**
 * Servlet implementation class EditEmployeeServlet
 */
@WebServlet("/EditEmployeeServlet")
public class EditEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        Employee employee=DatabaseHelper.getEmployee(id);
        display(employee,response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }
    
    private void display(Employee employee,HttpServletResponse response) throws IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Edit Employee Details</title>");
        out.println("</head>");
        out.println("<body style=\"background-color:#D8D4CC;\">");
        out.println("<h1 align=\"center\">Edit Employee Details!!</h1>");
        out.println("<form action=\"UpdateEmployeeServlet\">");
        out.println("<input type=\"hidden\" name=\"id\" value=\""+employee.getId()+"\"/>");
        out.println("<table align=\"center\" cellpadding=\"6\">");
        out.println("<tr>");
        out.println("<td><b>First Name</b></td>");
        out.println("<td><input type=\"text\" name=\"firstName\" value=\""+employee.getFirstName()+"\"/></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td><b>Last Name</b></td>");
        out.println("<td><input type=\"text\" name=\"lastName\" value=\""+employee.getLastName()+"\"/></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td><b>Email</b></td>");
        out.println("<td><input type=\"text\" name=\"email\" value=\""+employee.getEmail()+"\"/></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td><b>Age</b></td>");
        out.println("<td><input type=\"text\" name=\"age\" value=\""+employee.getAge()+"\"/></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td colspan=\"2\" align=\"center\"><input type=\"submit\" value=\"Save Info\"/></td>");
        out.println("</tr>");
        out.println("</form>");
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }

}
