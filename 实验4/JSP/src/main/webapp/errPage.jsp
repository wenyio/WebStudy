<%--
  Created by IntelliJ IDEA.
  User: isColt
  Date: 2021/4/14
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>获取客户信息</title>
</head>
<body>
客户提交信息的方式：<%=request.getMethod()%>
<br>使用的协议：<%=request.getProtocol()%>
<br>获取发出请求字符串的客户端地址：<%=request.getRequestURI()%>
<br>获取提交数据的客户端IP地址：<%=request.getRemoteAddr()%>
<br>获取服务器端口号：<%=request.getServerPort()%>
<br>获取服务器的名称：<%=request.getServerName()%>
<br>获取客户端的机器名称：<%=request.getRemoteHost()%>
    <br>获取客户端所请求的脚本文件的文件路径:<%=request.getServletPath()%>
<br>获得Http协议定义的文件头信息Host的值:<%=request.getHeader("host")%>
<br>获得Http协议定义的文件头信息User-Agent的值:<%=request.getHeader("user-agent")%>
</body>
</html>

