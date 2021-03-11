package cn.njpji.HttpServlet.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * xx
 * <p>
 * Description:
 * </p>
 *
 * @author: https://github.com/wenyio
 * @date: 2021/3/11
 * @see: cn.njpji.HttpServlet.servlet
 * @version: v1.0.0
 */
@WebServlet(name = "ImgServlet", value = "/images")
public class ImgServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        for (int i = 1; i <= 6; i++) {
            out.print("<img src='./images/" + i + ".jpg' width='100px' height='100px' />");
            if (i % 3 == 0) {
                out.print("<br/>");
            }
        }
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        for (int i = 1; i <= 6; i++) {
            out.print("<img src='./images/" + i + ".jpg' width='100px' height='100px' />");
            if (i % 3 == 0) {
                out.print("<br/>");
            }
        }
        out.println("</body></html>");
    }
}
