<%--
  Created by IntelliJ IDEA.
  User: 17234
  Date: 2020/5/11
  Time: 9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hello</title>
</head>
<body>
<form name="form1" action="hello.jsp" method="get">
    输入你的名字:
    <input type="text" name="username" id="username"><br>
    <input type="submit" value="确定"><br><br>
    <%@ include file="response.jsp"%>
</form>

</body>
</html>
