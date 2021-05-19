package com.dabing.controller;
import com.dabing.dao.ProductDao;
import com.dabing.model.Category;
import com.dabing.model.Product;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name="ShopServlet",value="/shop")
public class ShopServlet extends HomeServlet{
    Connection con = null;
    @Override
    public void init() throws ServletException {
        super.init();
        con = (Connection)getServletContext().getAttribute("con");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDao productDao =new ProductDao();
        List<Product> productList = null;
        List<Category> categoryList = null;
        try {
            categoryList = Category.findAllCategory(con);
            request.setAttribute("categoryList",categoryList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(request.getParameter("categoryId") == null){
                productList = productDao.findAll(con);
                request.setAttribute("productList",productList);
            }else {

                int catId = Integer.parseInt(request.getParameter("categoryId"));
                productList = productDao.findByCategoryId(catId,con);
                request.setAttribute("productList",productList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String path = "/WEB-INF/views/shop.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }

}
