package com.example.easybook.servlet;

import com.example.easybook.constant.ContentType;
import com.example.easybook.model.vo.User;

import java.sql.*;
import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "MainServlet", value = "/main")
public class MainServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            request.setAttribute("errMsg", "用户未登录！");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        } else {
            response.sendRedirect("main.jsp");
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
