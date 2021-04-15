package com.example.JSP.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * xx
 * <p>
 * Description:
 * </p>
 *
 * @author: https://github.com/wenyio
 * @date: 2021/4/14
 * @see: com.example.JSP.servlet
 * @version: v1.0.0
 */
@WebServlet(name = "p2Servlet", value = "/toP2")
public class P2Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        resp.addIntHeader("refresh", 10); // 10 秒刷新一次
        String strNum = req.getParameter("number");
        if (strNum == null || "".equals(strNum)) {
            resp.sendRedirect("p1.jsp");
        }
        Integer number = Integer.parseInt(strNum);
        req.setAttribute("number", number);
        req.getRequestDispatcher("p2.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }
}
