package com.dabing.week2.demo;

import javafx.print.Printer;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorldServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
        PrintWriter writer = response.getWriter();
        writer.println("Hello Client !!!");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }
}
// now its just a java class
//extend HttpServlet
//public class HelloWorldServlet extends HttpServlet {
//    public void doGet(HttpServletRequest request ,HttpServletResponse response) throws IOException {
//        //when client request method is GET-here-inside doGet()
//        // we want to send Hello to client
//        //we need to write Hello in response
//        //we need get writer-java.io
//        PrintWriter writer = response.getWriter();
//        writer.println("Hello client!!!");//that all
//        //next we need to tell about this servlet to tomcat-how?-web.xml
//
//    }
//    public void doPost(HttpServletRequest request ,HttpServletResponse response){
//        //when client request method is GET-here-inside doPost()
//
//    }
//}
