package com.dabing.lab2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
@WebFilter(filterName = "HuhanFilter")
public class HuhanFilter implements Filter {
    public void destroy() {
    }
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("i am in HuHanFilter-->before chain");
        chain.doFilter(req, resp);
        System.out.println("i am in HuHanFilter-->after chain");
    }
    public void init(FilterConfig config) throws ServletException {
    }

}