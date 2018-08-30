package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DatabaseHelper;
import com.pojo.Employee;

/**
 * Servlet implementation class ShowEmployeeServlet
 */
@WebServlet("/ShowEmployeeServlet")
public class ShowEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> listOfEmployee=DatabaseHelper.getAllEmployees();
        displayEmployee(listOfEmployee, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }
    
    private void displayEmployee(List<Employee> listOfEmployee,HttpServletResponse response) throws IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Show Employees</title>");
        out.println("</head>");
        out.println("<body style=\"background-color:#D8D4CC;\">");
        out.println("<h1 align=\"center\">Employee Details:</h1>");
        out.println("<form action=\"EditEmployeeServlet\">");
        out.println("<table align=\"center\" cellpadding=\"6\">");
        out.println("<th>");
        out.println("<td><b>First Name</b></td>");
        out.println("<td><b>Last Name</b></td>");
        out.println("<td><b>Email</b></td>");
        out.println("<td><b>Age</b></td>");
        out.println("</th>");
        int rowCount=1;
        for(Employee employee:listOfEmployee)
        {
            System.out.println(employee.getId());
            out.println("<tr>");
            out.println("<form action=\"EditEmployeeServlet\">");
            out.println("<td>"+rowCount+"</td>");
            out.println("<td>"+employee.getFirstName()+"</td>");
            out.println("<td>"+employee.getLastName()+"</td>");
            out.println("<td>"+employee.getEmail()+"</td>");
            out.println("<td>"+employee.getAge()+"</td>");
            out.println("<td><input type=\"submit\" value=\"update\"/></td>");
            out.println("<td><input type=\"hidden\" name=\"id\" value=\""+employee.getId()+"\"/></td>");
            out.println("</form>");
            out.println("</tr>");
            rowCount++;
        }
        out.println("</table>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }


}
