package com.example.filter.myfilter;

import com.example.filter.util.SensitiveWordsUtil;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

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
@WebFilter(urlPatterns = "/newliuyan.jsp")
public class LiuYanFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setAttribute("title",
                SensitiveWordsUtil.filterSensitiveWords(
                        servletRequest.getParameter("title")
                )
        );
        servletRequest.setAttribute("content",
                SensitiveWordsUtil.filterSensitiveWords(
                        servletRequest.getParameter("content")
                )
        );
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
