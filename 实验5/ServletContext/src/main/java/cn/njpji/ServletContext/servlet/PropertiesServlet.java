package cn.njpji.ServletContext.servlet;

import cn.njpji.ServletContext.constant.ContentType;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Properties;

/**
 * xx
 * <p>
 * Description:
 * </p>
 *
 * @author: https://github.com/wenyio
 * @date: 2021/3/15
 * @see: cn.njpji.ServletContext.servlet
 * @version: v1.0.0
 */
@WebServlet(value = "/pros")
public class PropertiesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType(ContentType.HTML);
        resp.setCharacterEncoding("UTF-8");

        ServletContext context = this.getServletContext();
        InputStream resource = context.getResourceAsStream("/WEB-INF/struts.properties");
        Properties pros = new Properties();
        pros.load(resource);

        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("struts.i18n.reload = " + pros.getProperty("struts.i18n.reload"));
        out.println("struts.devMode = " + pros.getProperty("struts.devMode"));
        out.println("struts.objectFactory = " + pros.getProperty("struts.objectFactory"));
        out.println("struts.multipart.maxSize = " + pros.getProperty("struts.multipart.maxSize"));
        out.println("struts.custom.i18n.resources = " + pros.getProperty("struts.custom.i18n.resources"));
        Enumeration<?> enumeration = pros.propertyNames();

        out.println("<h1>遍历打印 ↓</h1>");
        while (enumeration.hasMoreElements()) {
            Object nextElement = enumeration.nextElement();
            out.println(nextElement.toString() + " = " + pros.getProperty(nextElement.toString()) + "<br/>");
        }
        out.println("</body></html>");
    }
}
