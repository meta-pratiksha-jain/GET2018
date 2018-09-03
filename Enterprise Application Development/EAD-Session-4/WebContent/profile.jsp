<%@ page import="com.model.User" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile</title>
<style>
            body{
                background-color:#D8D4CC;
            }
            
        </style>
</head>
<body>
<% User user =(User)request.getAttribute("user"); %>
<%session.setAttribute("user", user); %>
<table id="header" width="90%" align="center">
            <tr>
                <td><img src="images/logo.png" alt="logo" height="90px"/></td>
                <td align="right">
                    <a>Welcome</a>
                    <a><%out.println(user.getFirstName()); %></a>
                    <a href="home.html">Logout</a>
                </td>
            </tr>
        </table>
        <hr/>
        <p align="right">See Your Friends<a href="FriendServlet?email=<%=user.getEmail()%>&organization=<%=user.getOrganization()%>">here</a></p>
        <h1 align="center" font-family="verdana">Your Profile</h1>
        <form action="editUser.jsp">
            <table align="center" cellpadding="6">
                <tr>
                    <td colspan="2"><img src=<%user.getProfileImage();%>></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="file" name="profile" value=user.getProfileImage()/></td>
                </tr>
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
                    <td>Date Of Birth:</td>
                    <td><%out.println(user.getDateOfBirth()); %></td>
                </tr>
                <tr>
                    <td>Conatct Number:</td>
                    <td><%out.println(user.getContactNumber()); %></td>
                </tr>
                <tr>
                    <td>Organization:</td>
                    <td><%out.println(user.getOrganization()); %></td>
                </tr>
                <tr>
                    <td colspan="2" padding-left="10px" align="center">
                        <input type="submit" value="Edit Info">
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>