<%--
  Created by IntelliJ IDEA.
  User: huhanflyingteam
  Date: 2021/4/6
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="header.jsp"%>
<head>
    <title>login</title>
</head>
<h1>Login</h1>
<%
if(!(request.getAttribute("message")==null)){
    response.getWriter().write("<h3>"+request.getAttribute("message")+"</h3>");
}
%>
<form method="post" action="login">
    UserName:<input type="text" name="username"><br/>
    Password:<input type="text" name="password"><br/>
    <input type="submit" value="login">
</form>
<%@include file="footer.jsp"%>
</html>