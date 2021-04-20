<%@ page import="com.dabing.model.User" %><%--
  Created by IntelliJ IDEA.
  User: huhanflyingteam
  Date: 2021/4/13
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="header.jsp"%>
<%
    User user = (User)request.getAttribute("user");

%>
<head>
    <title>userInfo</title>
</head>
<body>
<h1>User Info</h1>
<table>
    <tr><td>Id:</td><td><%=user.getId()%></td></tr>
    <tr><td>Username:</td><td><%=user.getUsername()%></td></tr>
    <tr><td>Email:</td><td><%=user.getEmail()%></td></tr>
    <tr><td>Gender:</td><td><%=user.getGender()%></td></tr>
    <tr><td>Birthday:</td><td><%=user.getBirthDate()%></td></tr>
    <tr><td>Password:</td><td><%=user.getPassword()%></td></tr>
</table>
</body>
<%@include file="footer.jsp"%>
</html>

