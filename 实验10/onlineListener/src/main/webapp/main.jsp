<%@ page language="java" pageEncoding="utf-8" %>
<%@ page import="com.example.onlineListener.vo.User" %>
<%@ page import="com.example.onlineListener.vo.LoginInfo" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.onlineListener.dao.LoginInfoDao" %>
<html>
<head>
    <title>留言板信息</title>
</head>
<body>
<%
    // 当前登录的用户信息
    User user = (User) session.getAttribute("user");
    String usr = user.getUsername();
    // 所有登录的用户信息
    List<LoginInfo> loginList = LoginInfoDao.listAll();
%>

<%=usr%>，您好！欢迎登录留言板。<a href="/logout">退出</a><br/>
当前在线人数：<%=session.getServletContext().getAttribute("online")%><br/>

<table border="1" width="500" rules="none" cellspacing="0" cellpadding="0">
    <tr height="50">
        <td colspan="4" align="center">系统登陆用户如下</td>
    </tr>
    <tr align="center" height="30" bgcolor="lightgrey">
        <td>ID</td>
        <td>用户名</td>
        <td>浏览器</td>
        <td>IP地址</td>
    </tr>
    <% if (loginList == null || loginList.size() == 0) { %>
    <tr height="100">
        <td colspan="3" align="center">没有用户登录！</td>
    </tr>
    <%
    } else {
        for (int i = 0; i < loginList.size(); i++) {
            LoginInfo loginInfo = loginList.get(i);
    %>
    <tr height="50" align="center">
        <td>
            <%=i + 1%>
        </td>
        <td>
            <%=loginInfo.getUser().getUsername()%>
        </td>
        <td>
            <%=loginInfo.getAgent()%>
        </td>
        <td>
            <%=loginInfo.getIp()%>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>
