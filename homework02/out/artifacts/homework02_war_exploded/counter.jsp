<%--
  Created by IntelliJ IDEA.
  User: 17234
  Date: 2020/5/11
  Time: 0:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>application</title>
</head>
<body>
<%
    int i =0;
    synchronized (application) {
        if (application.getAttribute("times") == null) {
            i = 1;
        }else {
            i = Integer.parseInt((String)application.getAttribute("times")) + 1;
        }
        application.setAttribute("times",Integer.toString(i));
    }
%>
<table>
    <tr>
        <td>您是第 <font color="red"><%=i %></font> 位访客</td>
    </tr>
</table>
</body>
</html>
