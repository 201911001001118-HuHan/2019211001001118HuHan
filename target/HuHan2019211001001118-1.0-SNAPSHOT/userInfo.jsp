<%--
  Created by IntelliJ IDEA.
  User: huhanflyingteam
  Date: 2021/4/13
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="header.jsp"%>
<head>
    <title>userInfo</title>
</head>
<body>
<h1>User Info</h1>
<table>
    <tr><td>Id:</td><td><%=request.getAttribute("Id")%></td></tr>
    <tr><td>Username:</td><td><%=request.getAttribute("Username")%></td></tr>
    <tr><td>Email:</td><td><%=request.getAttribute("Email")%></td></tr>
    <tr><td>Gender:</td><td><%=request.getAttribute("Gender")%></td></tr>
    <tr><td>Birthday:</td><td><%=request.getAttribute("Birthdate")%></td></tr>
    <tr><td>Password:</td><td><%=request.getAttribute("Password")%></td></tr>
</table>
</body>
<%@include file="footer.jsp"%>
</html>

