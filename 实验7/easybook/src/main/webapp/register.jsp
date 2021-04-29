<%@ page language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>注册-简易留言板</title>
</head>
<body bgcolor="#E3E3E3">
<%
    if (session.getAttribute("user") != null) {
        response.sendRedirect("/main");
    }
%>
${errMsg}
<form action="/register" method="post">
    <table>
        <caption>用户注册</caption>
        <tr>
            <td>用户名：</td>
            <td>
                <input type="text" name="username" size="20"/>
            </td>
        </tr>
        <tr>
            <td>密码:</td>
            <td>
                <input type="password" name="password" size="21"/>
            </td>
        </tr>
        <tr>
            <td>密码:</td>
            <td>
                <input type="password" name="rpassword" size="21"/>
            </td>
        </tr>
    </table>
    <input type="submit" value="注册"/>
    <input type="reset" value="重置"/>
</form>
如果已有账号点击<a href="/login.jsp">这里</a>登录！
</body>
</html>
