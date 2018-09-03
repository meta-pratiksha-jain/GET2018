<%@ page import="com.model.User" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Edit User</title>
    <style>
        body{
            background-color:#D8D4CC;
        }    
        </style>
        <script src="validation.js"></script>
    </head>
    <body>
        <% User user =(User)session.getAttribute("user"); %>
        <table id="header" width="90%" align="center">
            <tr>
                <td><img src="images/logo.png" alt="logo" height="90px"/></td>
                <td align="right">
                    <a href="">Welcome</a>
                    <input type="image" name="profile" value=user.getProfileImage()/>
                    <a href="profile.jsp"><%out.println(user.getFirstName()); %></a>
                    <a href="home.html">Logout</a>
                </td>
            </tr>
        </table>
        <h1 align="center" font-family="verdana">Edit Your Info</h1>
        <form action="UpdateServlet">
        <%session.setAttribute("user", user); %>
           <table align="center" cellpadding="6">
               <tr>
                   <td>First Name:</td>
                   <td><input type="text" id="firstName" name=firstName value="<%out.println(user.getFirstName()); %>" onblur="validateName(id)"/></td>
               </tr>
               <tr>
                   <td>Last Name:</td>
                   <td><input type="text" id="lastName" name=lastName value="<%out.println(user.getLastName()); %>" onblur="validateName(id)"/></td>
            </tr>
               <tr>
                   <td>Email:</td>
                   <td><input type="email" id="emailId" name=email value="<%out.println(user.getEmail()); %>" onblur="validateEmail()"/></td>
               </tr>
               <tr>
                   <td>Date Of Birth:</td>
                   <td><input type="Date" id="dateId" name=dateOfBirth value="<%out.println(user.getDateOfBirth()); %>"/></td>
               </tr>
               <tr>
                   <td>Conatct Number:</td>
                   <td><input type="text" id="contactId" name=contact value="<%out.println(user.getContactNumber()); %>" onblur="validateContact()"/></td>
               </tr>
            <tr>
                   <td>Organization:</td>
                   <td><select name="organization" value="<%out.println(user.getOrganization()); %>">
                    <option value="metacube">Metacube</option>
                    <option value="TCS">TCS</option>
                    <option value="Infosys">Infosys</option>
                    <option value="Vipro">Vipro</option>
                    <option value="Mahindra">Mahindra</option>
                </select></td>
               </tr>
               <tr>
                   <td colspan="2" padding-left="10px" align="center">
                       <input type="submit" value="Edit Info">
                   </td>
               </tr>
               <tr>
                   <td><input type="hidden" name="id" value=<%out.println(user.getId());%>/></td>
               </tr>
        </table>
        </form>
    </body>
</html>