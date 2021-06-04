package com.example.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckUser extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //为方便起见，这里假设数据库中有这些学号
        //在实际应用中应该是从数据库中查询得来的
        String[] xhs = {"081110", "081111", "081112", "081113"};
        //取得用户填写的学号
        String xh = request.getParameter("xh");
        //设置响应内容
        String responseContext = "true";
        for (int i = 0; i < xhs.length; i++) {
            //如果有该学号，修改响应内容
            if (xh.equals(xhs[i]))
                responseContext = "false";
        }
        //将处理结果返回给客户端
        out.println(responseContext);
        out.flush();
        out.close();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
