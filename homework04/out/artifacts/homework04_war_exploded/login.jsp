<%--
  Created by IntelliJ IDEA.
  User: 17234
  Date: 2020/5/12
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<%=(String)session.getAttribute("message")%>
<form action="CheckUserServlet" method="post">
    <table>
        <tr> <td>用户名:</td><td><input type="text" name="userName"/></td></tr>
        <tr> <td>密码:</td><td><input type="password" name="password"/></td> </tr>
        <tr> <td colspan="2">
            <input type="checkbox" name="check" value="check">自动登录<br>
            <input type="submit" value="登录"/> </td></tr>
    </table>
</form></body>
</html>
