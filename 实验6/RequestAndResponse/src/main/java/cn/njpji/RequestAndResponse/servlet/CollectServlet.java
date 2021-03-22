package cn.njpji.RequestAndResponse.servlet;

import cn.njpji.RequestAndResponse.constant.CharacterEncoding;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
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
 * @date: 2021/3/18
 * @see: cn.njpji.RequestAndResponse.servlet
 * @version: v1.0.0
 */
public class CollectServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding(CharacterEncoding.UTF_8);
        resp.setCharacterEncoding(CharacterEncoding.UTF_8);

        String number = req.getParameter("number");
        String username = req.getParameter("username");
        String sex = req.getParameter("sex");
        String[] hobbies = req.getParameterValues("hobby");
        if (number.equals("1001") && username.equals("张大胆")) {
            req.setAttribute("number", number);
            req.setAttribute("username", username);
            req.setAttribute("sex", sex);
            req.setAttribute("hobby", hobbies);
            req.getRequestDispatcher("info.jsp").forward(req, resp);
        } else {
            req.setAttribute("errorMsg", "用户名密码错误，请重新输入");
            req.getRequestDispatcher("collect.jsp").forward(req, resp);
        }
    }
}
