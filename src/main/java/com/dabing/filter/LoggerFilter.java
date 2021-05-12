package com.dabing.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;
@WebFilter(filterName = "LoggerFilter")
public class LoggerFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("i am in LoggerFilter --> doFilter()- before servlet(request come here ");
        chain.doFilter(request, response);
        System.out.println("i am in LoggerFilter-->doFilter() -After servlet (response come here)");
    }
    public void destroy() {
    }
    public void init(FilterConfig config) throws ServletException {
    }
}

