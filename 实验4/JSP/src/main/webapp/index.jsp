<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>jsp:forward和response的重定向功能实现页面跳转</h1>
<%
    request.setAttribute("test", 11);
//    response.sendRedirect("sendRedirect.jsp");
%>
<jsp:forward page="forward.jsp"></jsp:forward>
</body>
</html>
