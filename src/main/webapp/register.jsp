<%--
  Created by IntelliJ IDEA.
  User: huhanflyingteam
  Date: 2021/3/25
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>


<%@include file="header.jsp"%>
<form method="post" action="register">
    id<input type="text" name="id"/><br/>
    username<input type=="text" name="username"/><br/>
    password<input type=="password" name="password"/><br/>
    Email<input type=="text" name="email"/><br/>
    Gender: <input type="radio" name="gender" value="Male">Male <input type="radio" name="gender"value="Female">Female <br/>
    Date of Birth :<input type="text"name="birthDate"><br/>
    <input type="submit" value="Register"/>
</form>
<%@include file="footer.jsp"%>


