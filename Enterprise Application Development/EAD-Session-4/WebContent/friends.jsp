<%@ page import="com.model.User" %>
<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Friends</title>
        <style>
            body{
                background-color:#D8D4CC;
            }    
        </style>
    </head>
    <body>
        <% List<User> friends =(List<User>)request.getAttribute("friends"); %>
        <table id="header" width="90%" align="center">
            <tr>
                <td><img src="images/logo.png" alt="logo" height="90px"/></td>
                <td align="right">
                    <a href="LogoutServlet">Logout</a>
                </td>
            </tr>
        </table>
        <hr/>
        <h1 align="center" font-family="verdana">Your have <%=friends.size()%> friends</h1>
        <table align="center">
            <%for(int i=0;i<friends.size();i++)
             {
            %>
            <tr>
                <td><a href="FriendProfileServlet?email=<%=friends.get(i).getEmail()%>"> <%=friends.get(i).getFirstName() %> <%=friends.get(i).getLastName() %></a></td>
                <td><%=friends.get(i).getOrganization() %></td>
            </tr>
            <%}
            %>
        </table>
    </body>
</html>