package cn.njpji.HttpServlet.servlet;

import javax.servlet.ServletConfig;
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
 * @date: 2021/3/11
 * @see: cn.njpji.HttpServlet.servlet
 * @version: v1.0.0
 */
public class PrimeNumberServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        ServletConfig config = this.getServletConfig();
        String start = config.getInitParameter("start");
        String end = config.getInitParameter("end");

        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println(start + "到" + end + "之间的素数是：");
        int s = Integer.parseInt(start);
        int e = Integer.parseInt(end);
        for (int i = s; i < e; i++) {
            if (isPrime(i)) {
                out.println(i);
            }
        }
        out.println("</body></html>");
    }

    /*
    小于等于3的自然数只有2和3是质数
    从2开始，一直到小于其自身，依次判断能否被n整除即可，能够整除则不是质数，否则是质数
     */
    public boolean isPrime(int n){
        if (n <= 3) {
            return n > 1;
        }
        for(int i = 2; i < n; i++){
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
