<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="studentDao" class="com.example.sms.dao.StudentDao">
</jsp:useBean>
<jsp:useBean id="student" class="com.example.sms.bean.Student">
</jsp:useBean>
<jsp:setProperty property="*" name="student"/>
<%
    boolean result = studentDao.save(student);
    String msg = "";
    if (result)
        msg = "图书修改成功！";
    else
        msg = "图书修改失败！";
    session.setAttribute("msg", msg);
    response.sendRedirect("result.jsp");
%>
</body>
</html>
