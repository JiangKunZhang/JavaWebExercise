<%--
  Created by IntelliJ IDEA.
  User: 17234
  Date: 2020/5/10
  Time: 23:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>登陆成功</title>
</head>
<body>
<!--获取保存在session范围在内的用户名-->
<%
    String username = (String) session.getAttribute("username");
%>

欢迎您! [<%=username%>] <br>

<a href="exit.jsp">[退出]</a>
</body>
</html>
