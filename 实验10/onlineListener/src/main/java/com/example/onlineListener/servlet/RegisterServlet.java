package com.example.onlineListener.servlet;

import com.example.onlineListener.constant.ContentType;
import com.example.onlineListener.dao.UserDao;
import com.example.onlineListener.vo.User;

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
 * @date: 2021/4/29
 * @see: com.example.easybook.servlet
 * @version: v1.0.0
 */
@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {

    private UserDao userDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userDao = new UserDao();
        resp.setContentType(ContentType.HTML_UTF8);

        if (req.getSession().getAttribute("user") != null) {
            resp.sendRedirect("/main");
        }

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String rpassword = req.getParameter("rpassword");
        if (password.equals(rpassword)) {
            User user = userDao.getByUserName(username);
            if (user != null) {
                // 已经存在
                req.setAttribute("errMsg", "该用户已经存在！");
            } else {
                user = new User();
                user.setUsername(username);
                user.setPassword(password);
                userDao.saveUser(user);
                req.setAttribute("errMsg", "注册成功！");
            }
        } else {
            // 两次密码不一样
            req.setAttribute("errMsg", "两次密码不一样！");
        }
        req.getRequestDispatcher("register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
