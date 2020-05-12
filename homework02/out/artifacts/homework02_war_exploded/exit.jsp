<%--
  Created by IntelliJ IDEA.
  User: 17234
  Date: 2020/5/10
  Time: 23:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>退出</title>
</head>
<body>
<%
    session.invalidate();//销毁session
    response.sendRedirect("login.jsp");//页面重定向
%>
</body>
</html>
