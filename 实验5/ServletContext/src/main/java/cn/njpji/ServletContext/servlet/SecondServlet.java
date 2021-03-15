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
@WebServlet(value = "/second")
public class SecondServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType(ContentType.HTML);
        resp.setCharacterEncoding("UTF-8");

        ServletContext context = this.getServletContext();
        Enumeration<String> attributeNames = context.getAttributeNames();

        PrintWriter out = resp.getWriter();
        out.println("<html><body>");

        out.println("<h1>保存的信息如下：</h1>");
        out.println("Idnum" + " : " + context.getAttribute("Idnum") + "<br/>");
        out.println("Name" + " : " + context.getAttribute("Name") + "<br/>");
        out.println("Address" + " : " + context.getAttribute("Address") + "<br/>");
        out.println("Role" + " : " + context.getAttribute("Role") + "<br/>");
        out.println("<hr/>");

        out.println("<h1>ServletContext 所有的 Attribute：</h1>");
        while (attributeNames.hasMoreElements()) {
            String name = attributeNames.nextElement();
            out.println(name + " : " + context.getAttribute(name) + "<br/>");
        }
        out.println("</body></html>");
    }
}
