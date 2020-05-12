<%@ page import="com.model.Product" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: 17234
  Date: 2020/5/12
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head><title>购物系统首页面</title></head>
<body>
<center>
  <h3>商品列表</h3>
  <table>
    <tr><td>商品号</td><td>商品名</td><td>价格</td><td>库存量</td><td>类型</td><td>详细信息</td></tr>
    <!-- 从应用作用域中取出productList对象 -->
    <% ArrayList<Product> productList =
            (ArrayList<Product>)application.getAttribute("productList");
      // 对productList中每种商品循环
      for(Product product:productList){
    %>
    <tr>
      <td><%=product.getId() %></td>
      <td><%=product.getPname() %></td>
      <td><%=product.getPrice() %></td>
      <td><%=product.getStock() %></td>
      <td><%=product.getType() %></td>
      <td><a href="showProduct?id=<%=product.getId() %>">详细信息</a></td>
    </tr>
    <%} %>
  </table>
  <a href="showCart.jsp">查看购物车</a>
</center>
</body>
</html>
