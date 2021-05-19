package com.dabing.controller;
import com.dabing.dao.ProductDao;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name="GetImgServlet",value="/getImg")
public class GetImgServlet extends HttpServlet {
    Connection con=null;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        ProductDao dao = new ProductDao();
        int id = 0;
        if(request.getParameter("id") != null){
            id=Integer.parseInt(request.getParameter("id"));
        }

        try {
            byte[] imgByte = new byte[0];
            imgByte=dao.getPictureById(id,con);
            if(imgByte != null){
                response.setContentType("image/gif");
                OutputStream os = response.getOutputStream();
                os.write(imgByte);
                os.flush();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void init() throws ServletException {
        con= (Connection) getServletContext().getAttribute("con");
    }
}