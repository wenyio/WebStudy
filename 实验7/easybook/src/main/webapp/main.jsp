<%@ page language="java" pageEncoding="utf-8"%>
<%@ page import="com.example.easybook.model.vo.User" %>
<html>
<head>
	<title>留言板信息</title>
</head>
<body>
	<%
		User user= (User)session.getAttribute("user");
		String usr=user.getUsername();
	%>
	<%=usr%>，您好！欢迎登录留言板。<a href="/logout">退出</a>
</body>
</html>
