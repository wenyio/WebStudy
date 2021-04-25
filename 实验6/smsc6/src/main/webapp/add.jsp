<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>添加图书</title>
</head>
<body>
<form action="handle.jsp?action=add" method="post">
    学号：<input type="text" name="number" required="required"><br>
    姓名：<input type="text" name="name"><br>
    专业：<input type="text" name="major"><br>
    班级：<input type="text" name="clazz"><br>
    性别：<input type="text" name="sex"><br>
    籍贯：<input type="text" name="address"><br>
    生日：<input type="date" name="birthday">格式如：2017-10-01<br>
    团员：<input type="radio" name="member" value="true"/>是 <input type="radio" name="member" value="false">否
    <input type="submit" value="提交"><br>
</form>
</body>
</html>
