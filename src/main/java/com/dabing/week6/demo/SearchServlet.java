package com.dabing.week6.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "SearchServlet", value = "/SearchServlet")
public class SearchServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String url = (String)request.getParameter("search");
//        String txt = (String)request.getParameter("text");
        String search = request.getParameter("search");
        String txt = request.getParameter("txt");
        if(txt==""){
            response.sendRedirect("index.jsp");
        }else {
            if(search.equals("baidu")){
                response.sendRedirect("http://www.baidu.com/s?wd="+txt);
            }
            else if(search.equals("google")){
                response.sendRedirect("htpp://www.google.com/search?q="+txt);
            }else if (search.equals("bing")) {
                response.sendRedirect("https://cn.bing.com/search?q="+txt);
        }
        }
    }
}
