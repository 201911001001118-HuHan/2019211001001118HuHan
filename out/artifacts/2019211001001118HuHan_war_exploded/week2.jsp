<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="index.jsp">Get home page</a>
<form method="post">
    Name:HuangZhiCheng<br/>
    ID:2019211001001120<br/>
    Date and Time:<%= new Date()%>
    <br/>
    <input type="submit" value="Send data to sever">

</form>

</body>
</html>