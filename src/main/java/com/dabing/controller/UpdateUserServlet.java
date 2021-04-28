package com.dabing.controller;

import com.dabing.dao.UserDao;
import com.dabing.model.User;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Date;



@WebServlet(name = "UpdateUserServlet", value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    Connection con = null;


    @Override
    public void init() throws ServletException {
        con = (Connection)getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
//        Date birthDate = Date.valueOf(request.getParameter("birthDate"));
        String password = request.getParameter("password");
        User user =new User();
        user.setId(id);
        user.setUsername(username);
        user.setEmail(email);
        user.setGender(gender);
        user.setPassword(password);
//        user.setBirthDate(birthDate);
//        SimpleDateFormat num = new SimpleDateFormat();
//        Date birthDate = null;
//        try {
//            birthDate = num.parse(birthdate);
//        } catch (ParseException | java.text.ParseException e) {
//            e.printStackTrace();
//        }
        UserDao userDao = new UserDao();
        try {
            userDao.updateUser(con,user);
            HttpSession session=request.getSession();
            session.setMaxInactiveInterval(30);
            session.setAttribute("user",user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
    }



}
