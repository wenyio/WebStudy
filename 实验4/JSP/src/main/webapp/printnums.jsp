<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: isColt
  Date: 2021/4/14
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    PrintWriter writer = response.getWriter();
    for (int i = 1; i <= 9; i++) {
        // 打印空格 (9 - i)/2
        for (int j = 1; j <= (9 - i); j++) {
            writer.print("&nbsp;&nbsp;");
        }
        for (int k = 1; k <= i; k++) {
            writer.print(k);
        }
        for (int m = i - 1; m > 0; m--) {
            writer.print(m);
        }
        writer.print("<br/>");
    }
%>
</body>
</html>
