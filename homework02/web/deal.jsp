<%--
  Created by IntelliJ IDEA.
  User: 17234
  Date: 2020/5/10
  Time: 23:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@page import="java.util.*" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
<%
    String[][] userList = {{"admin","admin"},{"root","root"}};//保存用户列表
    boolean flg = false;//登陆状态
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    for (int i = 0 ; i < userList.length; i++) {
        if (userList[i][0].equals(username)) {
            if (userList[i][1].equals(password)) {
                flg = true;//表示登陆成功
                break;
            }
        }
    }
    if (flg) {
        session.setAttribute("username",username);//保存用户名&nbsp;到session范围的变量中
        response.sendRedirect("main.jsp");//跳转到主页
    }else {
        response.sendRedirect("login.jsp");//跳转到登录页面
    }
%>
</body>
</html>
