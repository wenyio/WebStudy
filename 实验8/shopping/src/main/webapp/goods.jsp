<%--
  Created by IntelliJ IDEA.
  User: isColt
  Date: 2021/5/13
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.shopping.pojo.Goods" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.shopping.dao.GoodsDao" %>
<% List<Goods> goodsList = GoodsDao.findAll(); %>
<html>
<head>
    <title>商品列表</title>
</head>
<body>
<table border="1" width="500" rules="none" cellspacing="0" cellpadding="0">
    <tr height="50">
        <td colspan="4" align="center">提供商品如下</td>
    </tr>
    <tr align="center" height="30" bgcolor="lightgrey">
        <td>名称</td>
        <td>库存</td>
        <td>价格(元/斤)</td>
        <td>购买</td>
    </tr>
    <% if (goodsList == null || goodsList.size() == 0) { %>
    <tr height="100">
        <td colspan="3" align="center">没有商品可显示！</td>
    </tr>
    <%
    } else {
        for (int i = 0; i < goodsList.size(); i++) {
            Goods single = goodsList.get(i);
    %>
    <tr height="50" align="center">
        <td><%=single.getName()%>
        </td>
        <td><%=single.getTotal()%>/<%=single.getMargin()%>
        </td>
        <td><%=single.getPrice()%>
        </td>
        <td>
            <a href="/move?action=in&goodsId=<%=single.getId()%>&num=1">加入购物车</a>
        </td>
    </tr>
    <%
            }
        }
    %>
    <tr height="50">
        <td align="center" colspan="4"><a href="shopCart.jsp">查看购物车</a></td>
    </tr>
</table>
</body>
</html>
