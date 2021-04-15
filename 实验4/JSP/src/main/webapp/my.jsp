<%--
  Created by IntelliJ IDEA.
  User: isColt
  Date: 2021/4/14
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>%@include 引入的文件在页面最上方</h2>
<%@include file="printnums.jsp"%>
<h2>jsp:include 引入的文件在页面最下方</h2>
<jsp:include page="printnums.jsp"/>
</body>
</html>
