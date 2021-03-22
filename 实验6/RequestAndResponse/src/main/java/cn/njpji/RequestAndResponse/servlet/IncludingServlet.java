package cn.njpji.RequestAndResponse.servlet;

import cn.njpji.RequestAndResponse.constant.ContentType;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
 * @date: 2021/3/22
 * @see: cn.njpji.RequestAndResponse.servlet
 * @version: v1.0.0
 */
public class IncludingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType(ContentType.HTML_UTF8);
        PrintWriter out = resp.getWriter();
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/includedServlet?p1=abc");
        out.println("before including <br/>");
        requestDispatcher.include(req, resp);
        out.println("after including <br>");
    }
}
