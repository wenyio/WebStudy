<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<%
    out.println("100以内所有的素数");
    for (int i = 2; i < 101; i++) {
        int j = 2;
        while (i % j != 0) {
            j++;
        }
        if (i == j) {
           out.println(i);
        }
    }
%>
</body>
</html>
