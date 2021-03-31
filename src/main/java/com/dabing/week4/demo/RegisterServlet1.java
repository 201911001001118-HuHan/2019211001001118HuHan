package com.dabing.week4.demo;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
@WebServlet(
        urlPatterns = {"/register"},
        initParams = {
                @WebInitParam(name = "driver",value = "com.microsoft.sqlserver.jdbc.SQLServerDriver"),
                @WebInitParam(name = "url",value = "jdbc:sqlserver://localhost:1433; DatabaseName=userdb"),
                @WebInitParam(name = "username",value = "sa"),
                @WebInitParam(name = "password",value = "123456789")
        },loadOnStartup = 1
)
public class RegisterServlet1 extends HttpServlet {
    Connection con = null;
    @Override
    public void init() throws ServletException {
//        String driver ="com.microsoft.sqlserver.jdbc.SQLServerDriver";
//        String url = "jdbc:sqlserver://localhost:1433; DatabaseName=userdb";
//        String username ="sa";
//        String password = "123456789";
        ServletConfig config = getServletConfig();
        String driver = config.getInitParameter("driver");
        String url = config.getInitParameter("url");
        String username = config.getInitParameter("username");
        String password = config.getInitParameter("password");
        try {
            Class.forName(driver);
            //注册驱动
            con = DriverManager.getConnection(url,username,password);
            System.out.println("init()-->"+con);
        }catch (ClassNotFoundException | SQLException e) { //SQLException异常
            e.printStackTrace();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("i am in doGet()");
        String sql = "select * from usertable";
        Writer writer = response.getWriter();
        try {
            ResultSet rs = con.createStatement().executeQuery(sql);
            while (rs.next()){
                PrintWriter writer1 = response.getWriter();
                writer1.println("<table border=\"1\">");
                writer1.println("<tr>");
                writer1.println("<td>id</td>");
                writer1.println("<td>userName</td>");
                writer1.println("<td>email</td>");
                writer1.println("<td>gender</td>");
                writer1.println("<td>password</td>");
                writer1.println("<td>birthday</td>");
                writer1.println("</tr>");
                writer.write("<td>"+rs.getInt("id")+"</td>");
                writer.write("<td>"+rs.getString("username")+"</td>");
                writer.write("<td>"+rs.getString("email")+"</td>");
                writer.write("<td>"+rs.getString("gender")+"</td>");
                writer.write("<td>"+rs.getString("password")+"</td>");
                writer.write("<td>"+rs.getDate("birthdate")+"</td>");
                writer.write("\n");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    public void destroy(){
        super.destroy();
        try {
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
