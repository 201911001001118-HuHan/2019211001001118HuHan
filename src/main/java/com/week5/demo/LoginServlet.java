package com.week5.demo;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
public class LoginServlet extends HttpServlet {
    Connection con = null;

    @Override
    public void init() throws ServletException {
//        ServletConfig config = getServletConfig();
//        String driver = config.getInitParameter("driver");
//        String url = config.getInitParameter("url");
//        String username = config.getInitParameter("username");
//        String password = config.getInitParameter("password");
//        try {
//            Class.forName(driver);
//            //注册驱动
//            con = DriverManager.getConnection(url, username, password);
//            System.out.println("init()-->" + con);
//        } catch (ClassNotFoundException | SQLException e) { //SQLException异常
//            e.printStackTrace();
//        }
//        con = (Connection) getServletContext().getAttribute("con");
        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultSet resultSet;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username+password);
//        PrintWriter writer = response.getWriter();
        String sql = "select * from usertable where username=? and password=?";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, username);
            pre.setString(2, password);
            resultSet = pre.executeQuery();
            if (resultSet.next()) {
//                writer.println("Login Success!");
//                writer.println(resultSet.getString("username"));
//                writer.println(resultSet.getString("password"));
                request.setAttribute("Id",resultSet.getInt("id"));
                request.setAttribute("Username",resultSet.getString("username"));
                request.setAttribute("Password",resultSet.getString("password"));
                request.setAttribute("Email",resultSet.getString("email"));
                request.setAttribute("Gender",resultSet.getString("gender"));
                request.setAttribute("Birthdate",resultSet.getDate("birthdate"));
                request.getRequestDispatcher("userInfo.jsp").forward(request,response);
            } else {
//                writer.println("Login Fail!");
//                writer.println("The account number or password you entered is wrong");
                request.setAttribute("message","Usename or Password Error!!!");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

//    @Override
//    public void destroy() {
//        try {
//            con.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}