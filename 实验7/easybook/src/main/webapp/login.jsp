<%@ page language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>简易留言板</title>
</head>
<body bgcolor="#E3E3E3">
<%
    if (session.getAttribute("user") != null) {
        response.sendRedirect("/main");
    }
%>
<form action="/login" method="post">
    <table>
        <caption>用户登录</caption>
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
            <td>验证码:</td>
            <td>
                <input type="text" name="check_code">
                <img src="/check_code" style="cursor: pointer" title="点击刷新"
                     onclick="this.src = this.src + '?' + new Date()"><br>
            </td>
        </tr>
    </table>
    <input type="submit" value="登录"/>
    <input type="reset" value="重置"/>
</form>
如果没注册单击<a href="/register.jsp">这里</a>注册！
</body>
</html>
