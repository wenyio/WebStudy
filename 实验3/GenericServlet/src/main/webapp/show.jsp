<%--
  Created by IntelliJ IDEA.
  User: isColt
  Date: 2021/3/28
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean id='commodity' class="cn.mypji.GenericServlet.vo.Commodity" scope="page"/>

<jsp:setProperty name="commodity" property="id" param="id"/>
<jsp:setProperty name="commodity" property="name" param="name"/>
<jsp:setProperty name="commodity" property="price" param="price"/>
<jsp:setProperty name="commodity" property="number" param="number"/>
<jsp:setProperty name="commodity" property="address" param="address"/>

商品号：<%=commodity.getId() %><br/>
商品名：<%=commodity.getName() %><br/>
商品价格：<%=commodity.getPrice() %><br/>
商品数量：<%=commodity.getNumber() %><br/>
商品地址：<%=commodity.getAddress() %><br/>

</body>
</html>
