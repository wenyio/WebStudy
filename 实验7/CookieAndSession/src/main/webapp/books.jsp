<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.Collection" %>
<%@ page import="com.example.CookieAndSession.session.example01.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.CookieAndSession.session.example01.BookDB" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: isColt
  Date: 2021/3/29
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    PrintWriter pr = response.getWriter();
    List<Book> books = new ArrayList<>(BookDB.getAll());
    pr.write("本站提供的图书有：<br>");
    for (int i = 0; i < books.size(); i++) {
        String url = "/PurchaseServlet?id=" + books.get(i).getId() ;
        HttpSession s=request.getSession();
        String newUrl=response.encodeRedirectURL(url);
        pr.write(books.get(i).getName());
        pr.write("<input type='number' value='0' onchange='handleInput(this.value, " + i +")' />");
        pr.write("<button onclick='handleClick(" + books.get(i).getId() + ", " + i + ")'>点击购买</button><br>");
    }
%>
<script>
    let amountArr = [];

    function handleInput(val, index) {
        amountArr[index] = val
    }
    function handleClick(bookId, index) {
        if (!amountArr[index] || amountArr[index] === 0) {
            alert("数量不能为0")
        } else {
            window.location = "/PurchaseServlet?id=" + bookId + "&amount=" + amountArr[index]
            window.navigator("/PurchaseServlet?id=" + bookId + "&amount=" + amountArr[index])
        }
    }
</script>
</body>
</html>
