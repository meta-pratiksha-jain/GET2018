<%@ page import="com.model.User" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>FriendProfile</title>
        <style>
            body{
                background-color:#D8D4CC;
            }    
        </style>
    </head>
    <body>
    <% User user =(User)request.getAttribute("user"); %>
        <table id="header" width="90%" align="center">
            <tr>
                <td><img src="images/logo.png" alt="logo" height="90px"/></td>
                <td align="right">
                    <a href="LogoutServlet">Logout</a>
                </td>
            </tr>
        </table>
        <hr/>
        <h1 align="center">Your Friend's Profile</h1>
        <table align="center">
            <tr>
                <td>First Name:</td>
                <td><%out.println(user.getFirstName()); %></td>
            </tr>
            <tr>
                <td>Last Name:</td>
                <td><%out.println(user.getLastName()); %></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><%out.println(user.getEmail()); %></td>
            </tr>
            <tr>
                <td>Contact Number:</td>
                <td><%out.println(user.getContactNumber()); %></td>
            </tr>
            <tr>
                <td>Date Of Birth:</td>
                <td><%out.println(user.getDateOfBirth()); %></td>
            </tr>
            <tr>
                <td>Organization:</td>
                <td><%out.println(user.getOrganization()); %></td>
            </tr>
        </table>
    </body>
</html>