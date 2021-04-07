package dabing.week3.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        request 对象接收来自用户端对服务器的指令，response对象从服务器输出信息到用户端
         */

        String Username = request.getParameter("Username");//接收从网页收到的Username=**的值
        String Password = request.getParameter("Password");
        String Email = request.getParameter("Email");
        String sex = request.getParameter("sex");
        String birthday = request.getParameter("birthday");
        PrintWriter writer = response.getWriter();
        writer.println("<br/>Username:"+Username);//可识别html语言
        writer.println("<br/>Password:"+Password);
        writer.println("<br/>Email:"+Email);
        writer.println("<br/>sex:"+sex);
        writer.println("<br/>birthday:"+birthday);
        writer.close();

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
