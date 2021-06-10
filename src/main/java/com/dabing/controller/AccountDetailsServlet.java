package com.dabing.controller;


import com.dabing.dao.OrderDao;
import com.dabing.model.Order;
import com.dabing.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;


@WebServlet(name = "AccountDetailsServlet",value = "/accountDetails")
public class AccountDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 5812011973673550742L;
    private Connection con;

    @Override
    public void destroy() {
        super.destroy();
    }
    @Override
    public void init() throws ServletException {
        super.init();
        con = (Connection) getServletContext().getAttribute("con");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if(session!=null&&session.getAttribute("user")!=null){
            User user = (User)session.getAttribute("user");
            int userId= user.getId();
            request.setAttribute("user",user);
            OrderDao orderDao = new OrderDao();
            List<Order> orderList = orderDao.findByUserId(con,userId);
            request.setAttribute("orderList",orderList);
            String path = "/WEB-INF/views/accountDetails.jsp";
            request.getRequestDispatcher(path).forward(request,response);
        }else {
            response.sendRedirect("login");
        }

    }
}