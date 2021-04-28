package com.week5.demo;
import com.dabing.dao.UserDao;
import com.dabing.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.*;
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
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserDao userDao =  new UserDao();
        try {
            User user = userDao.findByUsernamePassword(con,username,password);
            if(user!=null){
                String rememberMe = request.getParameter("rememberMe");
                if(rememberMe!=null && rememberMe.equals("1")){
                    Cookie usernameCookie=new Cookie("cUsername",user.getUsername());
                    Cookie passwordCookie=new Cookie("cPassword",user.getPassword());
                    Cookie rememberMeCookie = new Cookie("cRememberMe",rememberMe);
                    usernameCookie.setMaxAge(5);
                    passwordCookie.setMaxAge(5);
                    rememberMeCookie.setMaxAge(5);
                    response.addCookie(usernameCookie);
                    response.addCookie(passwordCookie);
                    response.addCookie(rememberMeCookie);
                }
                HttpSession session = request.getSession();
                System.out.println("session id-->"+session.getId());
                session.setMaxInactiveInterval(10);
                session.setAttribute("user",user);
                request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
            } else {
                request.setAttribute("message","Usename or Password Error!!!");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
//        ResultSet resultSet;
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        System.out.println(username+password);
//        PrintWriter writer = response.getWriter();
//        String sql = "select * from usertable where username=? and password=?";
//        try {
//            PreparedStatement pre = con.prepareStatement(sql);
//            pre.setString(1, username);
//            pre.setString(2, password);
//            resultSet = pre.executeQuery();
//            if (resultSet.next()) {
//                writer.println("Login Success!");
//                writer.println(resultSet.getString("username"));
//                writer.println(resultSet.getString("password"));
//                request.setAttribute("Id",resultSet.getInt("id"));
//                request.setAttribute("Username",resultSet.getString("username"));
//                request.setAttribute("Password",resultSet.getString("password"));
//                request.setAttribute("Email",resultSet.getString("email"));
//                request.setAttribute("Gender",resultSet.getString("gender"));
//                request.setAttribute("Birthdate",resultSet.getDate("birthdate"));
//                request.getRequestDispatcher("userInfo.jsp").forward(request,response);
//            } else {
//                writer.println("Login Fail!");
//                writer.println("The account number or password you entered is wrong");
//                request.setAttribute("message","Usename or Password Error!!!");
//                request.getRequestDispatcher("login.jsp").forward(request,response);
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
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