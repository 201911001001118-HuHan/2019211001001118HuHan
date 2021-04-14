<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="header.jsp"%>
<h1><%= "Welcome to my home page" %></h1>
<form method="get"  action="SearchServlet">
    <input type="text" name="txt" size="35"/>
    <select name="search">
        <option value="google">Google</option>
        <option value="bing">Bing</option>
        <option value="baidu">Baidu</option>
    </select>
    <input type="submit" value="Search"/>
</form>
<br/>
<a href="hello-servlet">Hello Servlet---week1</a><br/>
<a href="week2.jsp">Student Info Servlet-Week2</a><br/>
<a href="register.jsp">Register-getParameter-Week3</a><br/>
<a href="config">Config parameter-Week4</a><br/>
<a href="register">Register JDBC-Week4</a><br/>
<a href="index.jsp">include-week5</a><br/>
<a href="login.jsp">Login-week5</a><br/>
<%@include file="footer.jsp"%>