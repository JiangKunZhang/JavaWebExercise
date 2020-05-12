<%--
  Created by IntelliJ IDEA.
  User: 17234
  Date: 2020/5/11
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.beans.UserBean" %>
<jsp:useBean id="user" class="com.beans.UserBean" scope="request">
    <jsp:setProperty name="user" property="*"></jsp:setProperty>
</jsp:useBean>
<html>
<head>
    <title>display</title>
</head>
<body>
    UserName: <jsp:getProperty name="user" property="userName"/><br>
    PassWord: <jsp:getProperty name="user" property="password"/><br>
    Email: <jsp:getProperty name="user" property="email"/><br>
    <!--
    UserName:<%=user.getUserName() %> <br/>
    Password:<%=user.getPassword() %>  <br/>
    Email:<%=user.getEmail() %> <br/>
    -->
</body>
</html>
