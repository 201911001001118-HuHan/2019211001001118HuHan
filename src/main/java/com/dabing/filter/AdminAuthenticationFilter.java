package com.dabing.filter;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter("/admin/")
public class AdminAuthenticationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        HttpSession session = httpServletRequest.getSession(false);
        boolean isLoggedIn = (session!=null && session.getAttribute("userList")!=null);
        String loginURI = httpServletRequest.getContextPath() + "/admin/login";
        boolean isLoginRequest = httpServletRequest.getRequestURI().equals(loginURI);
        boolean isLoginPage = httpServletRequest.getRequestURI().endsWith("login");
        if(isLoggedIn && (isLoginRequest || isLoginPage)){
            RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/home");
            dispatcher.forward(request,response);
        }else  if(isLoggedIn || isLoginRequest){
            chain.doFilter(request,response);
        }else {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/admin/login");
        }
    }
    public void destroy() {
    }
    public void init(FilterConfig config) throws ServletException {
    }
}