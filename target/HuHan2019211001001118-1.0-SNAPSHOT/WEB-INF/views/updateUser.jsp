<%--
  Created by IntelliJ IDEA.
  User: huhanflyingteam
  Date: 2021/4/28
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="header.jsp" %>
<h1>User update</h1>
 <%
    User user3 = (User) session.getAttribute("user");

%>

<form method="post" action="updateUser">
    <input type="hidden" name="id" value="<%=user3.getId()%>">
    Username<input type="text" name="username" value="<%=user3.getUsername()%>"><br/>
    Email<input type="text" name="email" value="<%=user3.getEmail()%>"><br/>
    Gender: <input type="radio" name="gender" value="Male"<%="male".equals(user3.getGender())?"checked:":""%>>Male
    <input type="radio" name="gender" value="Female"<%="female".equals(user3.getGender())?"checked:":""%>>Female <br/>
    Date of Birth :<input type="text" name="birthdate" value="<%=user3.getBirthDate()%>"><br/>
    Password<input type="password" name="password" value="<%=user3.getPassword()%>"><br/>
    <input type="submit" value="Save changes"><br/>
</form>

<%@include file="footer.jsp" %>
<html/>

