package com.example.filter.myfilter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * xx
 * <p>
 * Description:
 * </p>
 *
 * @author: https://github.com/wenyio
 * @date: 2021/5/24
 * @see: com.example.filter.myfilter
 * @version: v1.0.0
 */
@WebFilter(urlPatterns = {"/*"}, initParams = { @WebInitParam(name = "times", value = "10000")})
public class ViewerFilter implements Filter {
    private static Integer times;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        times = Integer.valueOf(filterConfig.getInitParameter("times"));
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        times++;
        PrintWriter out = servletResponse.getWriter();
        out.print("网站访问次数为：" + times);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
