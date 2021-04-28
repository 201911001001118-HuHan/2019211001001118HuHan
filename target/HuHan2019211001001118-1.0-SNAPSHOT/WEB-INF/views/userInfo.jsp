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
<head>
    <title>userInfo</title>
</head>
<body>
<h1>User Info</h1>
<%
    User user1 = (User) session.getAttribute("user");


%>
<%
    // read cookies
    Cookie [] allCookies = request.getCookies();
    for(Cookie c:allCookies){
        //get one by one
        out.println("<br/>"+c.getName()+"---"+c.getValue());
    }
%>
<%--<%--%>
<%--    String path = request.getContextPath();--%>
<%--    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";--%>
<%--%>--%>
<table>
    <tr><td>Id:</td><td><%=user1.getId()%></td></tr>
    <tr><td>Username:</td><td><%=user1.getUsername()%></td></tr>
    <tr><td>Email:</td><td><%=user1.getEmail()%></td></tr>
    <tr><td>Gender:</td><td><%=user1.getGender()%></td></tr>
    <tr><td>Birthday:</td><td><%=user1.getBirthDate()%></td></tr>
    <tr><td>Password:</td><td><%=user1.getPassword()%></td></tr>
<%--    <tr><td><a href="<%request.getRequestDispatcher("/WEB-INF/views/updateUser.jsp").forward(request,response);%>"></a></td></tr>--%>
</table>
<%--<a href="<%request.getRequestDispatcher("/WEB-INF/views/updateUser.jsp").forward(request,response);%>--%>
<a href="updateUser">update</a>
<%--<a href="<%=basePath%>updateUser.jsp">update</a>--%>
</body>
<%@include file="footer.jsp"%>
</html>

