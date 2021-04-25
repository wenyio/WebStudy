<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="com.example.*" isELIgnored="false" %>
<%request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="studentDao" class="com.example.sms.dao.StudentDao">
</jsp:useBean>
<jsp:useBean id="student" class="com.example.sms.bean.Student">
</jsp:useBean>
<jsp:setProperty property="*" name="student"/>
<%
    String msg = "";
    boolean result = false;
    int id = 0;
    String action = request.getParameter("action");
    if (request.getParameter("id") != null)
        id = Integer.parseInt(request.getParameter("id"));
    if (action.equals("delete")) {
        result = studentDao.delete(id);
        if (result == true)
            msg = "删除成功！";
        else
            msg = "删除失败！";
        session.setAttribute("msg", msg);
        response.sendRedirect("result.jsp");
        return;
    } else if (action.equals("update")) {
        student = studentDao.getById(id);
        request.setAttribute("student", student);
        request.getRequestDispatcher("edit.jsp").forward(request, response);
    } else if (action.equals("add")) {
        result = studentDao.save(student);
        if (result == true)
            msg = "添加成功！";
        else
            msg = "添加失败！";
        session.setAttribute("msg", msg);
        response.sendRedirect("result.jsp");
        return;
    }
%>
