<%@ page import="java.io.PrintWriter" %>
<%--
  Created by IntelliJ IDEA.
  User: isColt
  Date: 2021/3/18
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生爱好信息</title>
</head>
<body>
<%--学号：<%=request.getParameter("number")%><br/>--%>
<%--姓名：${username}<br/>--%>
<%--性别：${sex}<br/>--%>
<%--爱好：<br/>--%>
<%
    PrintWriter writer = response.getWriter();
    String number = request.getParameter("number");
    String username = request.getParameter("username");
    String sex = request.getParameter("sex");
    String[] hobbies = request.getParameterValues("hobby");
    writer.println("学号：" + number + "<br/>");
    writer.println("姓名：" + username + "<br/>");
    writer.println("性别：" + sex + "<br/>");
    writer.println("爱好：");
    for (String hobby : hobbies) {
        writer.println(hobby + "、");
    }
%>
</body>
</html>
