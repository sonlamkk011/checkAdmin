package com.example.checkadmin.adminFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        HttpSession session = httpServletRequest.getSession();
        boolean havePermission = false;
        if (session.getAttribute("username") != null) {
            String username = (String) session.getAttribute("username");
            System.out.println("hello user :" + username);
            if (username.equals("admin")) {
                havePermission = true;
            }
        }
        if (havePermission) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        }else {
            httpServletResponse.getWriter().println("Permission denied! ");
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
