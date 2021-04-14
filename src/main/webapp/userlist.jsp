<%--
  Created by IntelliJ IDEA.
  User: huhanflyingteam
  Date: 2021/4/14
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="header.jsp"%>
<%@ page import="java.sql.ResultSet" %>
<%--<%@ page import="java.io.PrintWriter"%>--%>
<h1>userlist</h1>
<table border=1>
    <tr>
        <td>Id</td><td>Username</td><td>password</td><td>Email</td><td>Gender</td><td>Birthday</td>
    </tr>
    <%
        ResultSet rs = (ResultSet) request.getAttribute("rsname");
//        String sql = "SELECT * FROM usertable";
        if(rs == null){
    %>
    <tr>
        <td>No Data!!!</td>
    </tr>
    <% } else
        while (rs.next())
        {

            out.println("<tr>");
            out.println("<td>"+rs.getInt("id")+"</td>");
            out.println("<td>"+rs.getString("username")+"</td>");
            out.println("<td>"+rs.getString("password")+"</td>");
            out.println("<td>"+rs.getString("email")+"</td>");
            out.println("<td>"+rs.getString("gender")+"</td>");
            out.println("<td>"+rs.getString("birthdate")+"</td>");
            out.println("<tr>");
        }
    %>



</table>




<%@include file="footer.jsp"%>
</html>
<%--request.getAttribute("<tr>");--%>
<%--request.getAttribute("<td>"+rs.getInt("id")+"</td>");--%>
<%--request.getAttribute("<td>"+rs.getString("username")+"</td>");--%>
<%--request.getAttribute("<td>"+rs.getString("password")+"</td>");--%>
<%--request.getAttribute("<td>"+rs.getString("email")+"</td>");--%>
<%--request.getAttribute("<td>"+rs.getString("gender")+"</td>");--%>
<%--request.getAttribute("<td>"+rs.getString("birthdate")+"</td>");--%>
<%--request.getAttribute("<tr>");--%>