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
<%
    Cookie[] allCookies = request.getCookies();
    String username="",password="",rememberMeVal="";
    if(allCookies!=null){
        for(Cookie c:allCookies){
            if(c.getName().equals("cUsername")){
                username = c.getValue();
            }
            if(c.getName().equals("cPassword")){
                password = c.getValue();
            }
            if(c.getName().equals("cRememberMe")){
                rememberMeVal = c.getValue();
            }
        }
    }
   %>


<form method="post" action="login">
    UserName:<input type="text" name="username" value="<%=username%>"><br/>
    Password:<input type="text" name="password" value="<%=password%>"><br/>
    <input type="checkbox" name="rememberMe" value="1" <%=rememberMeVal.equals("1")?"checked":""%>checked/>RememberMe<br/>
    <input type="submit" value="login">
</form>


<%@include file="footer.jsp"%>
</html>