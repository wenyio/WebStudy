<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: isColt
  Date: 2021/4/14
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Object times = session.getAttribute("times");
    if (times != null) {
        Integer i = Integer.parseInt(times.toString()) + 1;
        if (i > 6) {
            request.getRequestDispatcher("p3.jsp").forward(request, response);
        }
        session.setAttribute("times", i);
    } else {
        session.setAttribute("times", 1);
    }
    Date now = new Date();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
    String format = simpleDateFormat.format(now);
    out.print(format);
%>
</body>
</html>
