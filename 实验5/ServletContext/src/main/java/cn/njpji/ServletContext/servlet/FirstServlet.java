package cn.njpji.ServletContext.servlet;

import cn.njpji.ServletContext.constant.ContentType;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * xx
 * <p>
 * Description:
 * </p>
 *
 * @author: https://github.com/wenyio
 * @date: 2021/3/15
 * @see: cn.njpji.HttpServlet.servlet
 * @version: v1.0.0
 */
@WebServlet(value = "/first")
public class FirstServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType(ContentType.HTML);
        resp.setCharacterEncoding("UTF-8");

        ServletContext context = this.getServletContext();
        context.setAttribute("Idnum", "100001");
        context.setAttribute("Name", "Bear");
        context.setAttribute("Address", "jiangsunanjing ");
        context.setAttribute("Role", "student");

        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>信息已保存，点击下方链接查看</h1>");
        out.println("<a href='/second'>我是链接，点我，点我</a>");
        out.println("</body></html>");
    }
}
