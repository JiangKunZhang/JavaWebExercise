<%@ page import="java.io.IOException" %>
<%--
  Created by IntelliJ IDEA.
  User: 17234
  Date: 2020/5/11
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<jsp:useBean id="calculator" class="com.beans.SimpleCalculator">
    <jsp:setProperty name="calculator" property="*"/>
</jsp:useBean>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>计算</title>

</head>
<body>

<br/>
<form action="calculator.jsp" method="post">
    第一个操作数：<input type="text" name="first">
    第二个操作数：<input type="text" name="second"><br/>
    <select name="operator">
        <option value="+">+</option>
        <option value="-">-</option>
        <option value="*">*</option>
        <option value="/">/</option>
    </select>
    <input type="submit" value="计算" >
</form>

<%
    try
    {
        float first=calculator.getFirst();
        float second=calculator.getSecond();
        String  op=calculator.getOperator();
        out.print("计算结果为："+ calculator.getFirst() + calculator.getOperator() + calculator.getSecond() + "="
                + calculator.calculate(first, second, op));
    }catch(Exception e)
    {
        e.printStackTrace();

    }

%>
</body>
</html>
