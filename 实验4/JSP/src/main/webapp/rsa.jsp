<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: isColt
  Date: 2021/4/14
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>request、session和application</title>
</head>
<body>
<%
    int count1 = 0;
    int count2 = 0;
    int count3 = 0;
    int count4 = 0;

    if (application.getAttribute("count1") != null) {
        count1 = Integer.parseInt(application.getAttribute("count1").toString());
    }
    count1++;
    application.setAttribute("count1", count1);

    if (session.getAttribute("count2") != null) {
        count2 = Integer.parseInt(session.getAttribute("count2").toString());
    }
    count2++;
    session.setAttribute("count2", count2);

    if (request.getAttribute("count3") != null) {
        count3 = Integer.parseInt(request.getAttribute("count3").toString());
    }
    count3++;
    request.setAttribute("count3", count3);

    if (pageContext.getAttribute("count4") != null) {
        count4 = Integer.parseInt(pageContext.getAttribute("count4").toString());
    }
    count4++;
    pageContext.setAttribute("count4", count4);

    PrintWriter writer = response.getWriter();
    writer.print("application count1 " + count1 + "<br/>");
    writer.print("session count2 " + count2 + "<br/>");
    writer.print("request count3 " + count3 + "<br/>");
    writer.print("pageContext count4 " + count4 + "<br/>");
%>
</body>
</html>
