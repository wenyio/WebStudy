<%@ page import="com.example.filter.entity.LiuYan" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: isColt
  Date: 2021/5/24
  Time: 9:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>留言列表</h1>
<%
    List<LiuYan> list = (List<LiuYan>) application.getAttribute("list");
    if (list == null) {
        list = new ArrayList<>();
        application.setAttribute("list", list);
    }
    String title = (String) request.getAttribute("title");
    String content = (String) request.getAttribute("content");
    list.add(new LiuYan(title, content));
    application.setAttribute("list", list);
%>
<ul>
    <%
        for (LiuYan liuYan : list) {
    %>
    <li><%=title%>: <%=content%></li>
    <%
        }
    %>
</ul>
</body>
</html>
