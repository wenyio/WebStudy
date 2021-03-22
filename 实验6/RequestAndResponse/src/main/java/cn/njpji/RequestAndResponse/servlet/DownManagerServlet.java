package cn.njpji.RequestAndResponse.servlet;

import cn.njpji.RequestAndResponse.constant.ContentType;

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
public class DownManagerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType(ContentType.HTML_UTF8);
        PrintWriter out = resp.getWriter();
        String referer = req.getHeader("Referer");
        String sitePart = "http://" + req.getServerName();
        if (referer != null && referer.startsWith(sitePart)) {
            out.println("正在下载。。。");
        } else {
            req.setAttribute("error", "非法请求");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }
}
