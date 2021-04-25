<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>修改图书</title>
</head>
<body>
<h1>修改图书信息</h1>
<form action="saveupdate.jsp" method="post">
    <input type="hidden" name="id" value="${student.id}">
    学号：<input type="text" value="${student.number}" name="number" required="required"><br>
    姓名：<input type="text" value="${student.name}" name="name"><br>
    专业：<input type="text" value="${student.major}" name="major"><br>
    班级：<input type="text" value="${student.clazz}" name="clazz"><br>
    性别：<input type="text" value="${student.sex}" name="sex"><br>
    籍贯：<input type="text" value="${student.address}" name="address"><br>
    生日：<input type="date" value="${student.birthday}" name="birthday">格式如：2017-10-01<br>
    团员：<input type="radio" name="member" value="true"/>是 <input type="radio" name="member" value="false">否
    <input type="submit" value="提交">
</form>

</body>
</html>
