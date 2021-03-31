package dabing.week3.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
//@WebServlet(
//        urlPatterns = {"/register"},
//        initParams = {
//                @WebInitParam(name = "driver",value = "com.microsoft.sqlserver.jdbc.SQLServerDriver"),
//                @WebInitParam(name = "url",value = "jdbc:sqlserver://localhost:1433; DatabaseName=userdb"),
//                @WebInitParam(name = "username",value = "sa"),
//                @WebInitParam(name = "password",value = "123456789")
//        },loadOnStartup = 1
//)

public class RegisterServlet extends HttpServlet {
    Connection con = null;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String sql = "insert into usertable(id,username,email,gender,birthdate,password)\n" +
//                "values('1','sa','123@qq.com','male','2000.1.1','123456789')";
        String sql = "select * from usertable";
        try {
            ResultSet rs = con.createStatement().executeQuery(sql);
            while (rs.next()){
                String id = request.getParameter("id");
                String username = request.getParameter("username");
                String email = request.getParameter("email");
                String gender = request.getParameter("gender");
                String birthDate = request.getParameter("birthDate");
                String password = request.getParameter("password");
                PrintWriter writer = response.getWriter();
                writer.println("id :"+id);
                writer.println("username :"+username);
                writer.println("email :"+email);
                writer.println("gender :"+gender);
                writer.println("birthDate :"+birthDate);
                writer.println("password :"+password);
                writer.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }





    }
}
