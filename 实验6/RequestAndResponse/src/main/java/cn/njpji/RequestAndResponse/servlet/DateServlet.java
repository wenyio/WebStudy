package cn.njpji.RequestAndResponse.servlet;

import cn.njpji.RequestAndResponse.constant.CharacterEncoding;
import cn.njpji.RequestAndResponse.constant.ContentType;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;
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
public class DateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType(ContentType.HTML);
        resp.setCharacterEncoding(CharacterEncoding.UTF_8);
        resp.addIntHeader("refresh", 5);
        PrintWriter out = resp.getWriter();
        out.print("getMethod:" + req.getMethod() + "<br/>");
        out.print("getMethod:" + req.getRequestURI() + "<br/>");
        out.print("getMethod:" + req.getQueryString() + "<br/>");
        out.print("getMethod:" + req.getProtocol() + "<br/>");
        out.print("getMethod:" + req.getContextPath() + "<br/>");
        out.print("getMethod:" + req.getPathInfo() + "<br/>");
        out.print("getMethod:" + req.getPathTranslated() + "<br/>");
        out.print("getMethod:" + req.getServletPath() + "<br/>");
        out.print("getMethod:" + req.getRemoteAddr() + "<br/>");
        out.print("getMethod:" + req.getRemoteHost() + "<br/>");
        out.print("getMethod:" + req.getRemotePort() + "<br/>");
        out.print("getMethod:" + req.getLocalAddr() + "<br/>");
        out.print("getMethod:" + req.getLocalName() + "<br/>");
        out.print("getMethod:" + req.getLocalPort() + "<br/>");
        out.print("getMethod:" + req.getServerName() + "<br/>");
        out.print("getMethod:" + req.getServerPort() + "<br/>");
        out.print("getMethod:" + req.getScheme() + "<br/>");
        out.print("getMethod:" + req.getRequestURL() + "<br/>");
        out.print("=============================================<br/>");
        out.print("现在时刻：" + new Date());
    }
}
