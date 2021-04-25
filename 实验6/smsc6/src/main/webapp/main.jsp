<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*" %>
<%@ page import="com.example.sms.bean.Student" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>图书管理系统主页</title>
</head>
<body>
<jsp:useBean id="studentDao" class="com.example.sms.dao.StudentDao"></jsp:useBean>
<%
    request.setCharacterEncoding("utf-8");
    String keyword = request.getParameter("keyword");
    request.setAttribute("keyword", keyword);
    ArrayList<Student> students = studentDao.getByNumber(keyword);
    request.setAttribute("students", students);
%>
<form action="main.jsp" method="post">
    <input type="text" name="keyword" size="80" value="${requestScope.keyword}">
    <input type="submit" value="搜索">
</form>
<br>
<button onclick="goAdd()">添加</button>
<br>
<br>
<table border="1">
    <tr>
        <th>ID</th>
        <th>学号</th>
        <th>姓名</th>
        <th>专业</th>
        <th>班级</th>
        <th>性别</th>
        <th>籍贯</th>
        <th>生日</th>
        <th>是否是团员</th>
    </tr>
    <c:forEach items="${students}" var="student">
        <tr>
            <td>${student.id}</td>
            <td>${student.number}</td>
            <td>${student.name}</td>
            <td>${student.major}</td>
            <td>${student.clazz}</td>
            <td>${student.sex}</td>
            <td>${student.address}</td>
            <td>${student.birthday}</td>
            <td>${student.member ? "是" : "否"}</td>
            <td><a href="handle.jsp?action=update&id=${student.id}">修改</a></td>
            <td><a href="javascript:void(0);" onclick="deleteBook(${student.id})">删除</a></td>
        </tr>
    </c:forEach>
</table>
<script type="text/javascript">
    function deleteBook(id) {
        if (confirm("你确定要删除该记录吗？")) {
            window.location = "handle.jsp?action=delete&id=" + id;
        }
    }

    function goAdd() {
        window.location.href = "add.jsp"
    }
</script>
</body>
</html>
