<%--
  Created by IntelliJ IDEA.
  User: isColt
  Date: 2021/3/18
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生爱好收集</title>
</head>
<body>
<form method="post" action="collect">
    学号：<input type="number" /><br/>
    姓名：<input /><br/>
    性别：<br/>
    <input type="radio" name="sex" />男<br/>
    <input type="radio" name="sex" />女<br/>
    爱好：<br/>
    <input type="checkbox" name="hobby" /> 学习<br/>
    <input type="checkbox" name="hobby" /> 唱歌<br/>
    <input type="checkbox" name="hobby" /> 看书<br/>
    <input type="checkbox" name="hobby" /> 运动<br/>
    <button type="submit">提交</button>
    <button type="reset">重置</button>
</form>
</body>
</html>
