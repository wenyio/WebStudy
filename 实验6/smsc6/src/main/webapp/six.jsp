<%--
  Created by IntelliJ IDEA.
  User: isColt
  Date: 2021/4/25
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<sql:setDataSource var="snapshot" driver="com.mysql.cj.jdbc.Driver"
                   url="jdbc:mysql://localhost:3306/bookdb?useSSL=false&characterEncoding=UTF-8&serverTimezone=UTC"
                   user="root"  password="5211"/>
<br/>
${snapshot}
<hr/>
<!-- ****SQL查询【sql:query】****
    sql="要执行的SQL语句，默认为主体内容"
    dataSource="数据源"
    maxRows="存储在变量中的最大结果数，默认无无穷大"
    startRow="开始记录的结果行数，默认为0"
    var="存储查询结果的变量"
    scope="var属性的作用域(page request session application),默认为page"
    rowCount属性。该属性统计结果集中有效记录的量，可以使用于大批量数据分页显示。
    查询结果属性：
        rows                结果数据，字段名={字段值···}
        rowsByIndex         常用得到数据库中数据的方式，从有效行的第一个元素开始遍历，到最后一个有效行的最后一个元素。
        columnNames         用于得到数据库中的字段名。
        limitedByMaxRows    用于判断是否受到了maxRows的限制
 -->
<sql:query dataSource="${snapshot}" var="result" maxRows="10" startRow="0">
    select * from student;
</sql:query>
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
    <c:forEach items="${result.rows}" var="student">
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
</body>
</html>
