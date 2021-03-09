package cn.mypji.GenericServlet.servlet;

import cn.mypji.GenericServlet.util.RMBUtils;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 1. 将非负整数转换成人民币大写的功能
 * <p>
 * Description:
 * </p>
 *
 * @author: https://github.com/wenyio
 * @date: 2021/3/9
 * @see: cn.mypji.GenericServlet
 * @version: v1.0.0
 */
public class RMBServlet extends GenericServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("init....");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setCharacterEncoding("gbk");
        PrintWriter out = servletResponse.getWriter();
        int money = 12345;

        String result = RMBUtils.toChinese(String.valueOf(money));
        out.println(money + "：" + result);
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("destroy...");
    }
}
