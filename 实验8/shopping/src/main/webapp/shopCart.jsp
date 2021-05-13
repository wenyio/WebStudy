<%@ page import="com.example.shopping.pojo.GoodsShopCart" %><%--
  Created by IntelliJ IDEA.
  User: isColt
  Date: 2021/5/13
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.shopping.dao.GoodsShopCartDao" %>
<%@ page import="com.example.shopping.dao.ShopCartDao" %>
<%@ page import="com.example.shopping.pojo.ShopCart" %>
<% ShopCart shopCart = ShopCartDao.getById(1); %>
<% List<GoodsShopCart> goodsShopCarts = GoodsShopCartDao.findByShopCart(shopCart.getId()); %>
<html>
<head>
    <title>我的购物车</title>
</head>
<body>
<table border="1" width="450" rules="none" cellspacing="0" cellpadding="0">
    <tr height="50">
        <td colspan="5" align="center">购买的商品如下</td>
    </tr>
    <tr align="center" height="30" bgcolor="lightgrey">
        <td width="25%">名称</td>
        <td>价格(元/斤)</td>
        <td>数量</td>
        <td>总价(元)</td>
        <td>移除(-1/次)</td>
    </tr>
    <% if (goodsShopCarts == null || goodsShopCarts.size() == 0) { %>
    <tr height="100">
        <td colspan="5" align="center">您的购物车为空！</td>
    </tr>
    <%
    } else {
        for (int i = 0; i < goodsShopCarts.size(); i++) {
            GoodsShopCart single = goodsShopCarts.get(i);
            String name = single.getGoods().getName();                            //获取商品名称
            Double price = single.getPrice();                            //获取商品价格
            int num = single.getNum();                                //获取购买数量
            Double money = ((int) ((price * num + 0.05f) * 10)) / 10d;            //计算当前商品总价，并进行四舍五入
    %>
    <tr align="center" height="50">
        <td><%=name%>
        </td>
        <td><%=price%>
        </td>
        <td><%=num%>
        </td>
        <td><%=money%>
        </td>
        <td>
            <a href="/move?action=out&goodsId=<%=single.getGoods().getId() %>&num=1">- </a>
            <%=single.getNum()%>
            <a href="/move?action=in&goodsId=<%=single.getGoods().getId() %>&num=1"> +</a>
        </td>
    </tr>
    <%
            }
        }
    %>
    <tr height="50" align="center">
        <td colspan="5">应付金额：<%=shopCart.getTotalPrice()%>
        </td>
    </tr>
    <tr height="50" align="center">
        <td colspan="2"><a href="goods.jsp">继续购物</a></td>
        <td colspan="3"><a href="/move?action=clear">清空购物车</a></td>
    </tr>
</table>
</body>
</html>
