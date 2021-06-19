package com.dabing.lab3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CalServlet", value = "/CalServlet")
public class CalServlet extends HttpServlet {
    private int add(int firstVal,int secondVal) {
        return firstVal+secondVal;
    }
    private int Sub(int firstVal,int secondVal){
        return firstVal - secondVal;
    }
    private int Multiply(int firstVal,int secondVal){
        return firstVal * secondVal;
    }
    private int Divide(int firstVal,int secondVal){
        return firstVal / secondVal;
    }
    public int ComputeLength(String string){
        return string.length();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int firstVal = request.getParameter("firstVal")!=null?Integer.parseInt(request.getParameter("firstVal")):0;
        int secondVal = request.getParameter("secondVal")!=null?Integer.parseInt(request.getParameter("secondVal")):0;
        String name = request.getParameter("name");
        String action = request.getParameter("action");
        int result=0;
        int length=0;
        if (action.equals("add")){
            result = add(firstVal,secondVal);
        }else if (action.equals("sub")){
            result = Sub(firstVal,secondVal);
        }else if (action.equals("multiply")){
            result = Multiply(firstVal,secondVal);
        }else if (action.equals("divide")){
            result = Divide(firstVal,secondVal);
        }else if (action.equals("computeLength")){
            length = ComputeLength(name);
        }else {
            request.getRequestDispatcher(request.getContextPath()+"/lab3/cal.jsp").forward(request,response);
        }
        if (action.equals("add")||action.equals("sub")||action.equals("multiply")||action.equals("divide")){
            Cookie cFirstVal = new Cookie("cFirstVal",String.valueOf(firstVal));
            Cookie cSecondVal = new Cookie("cSecondVal", String.valueOf(secondVal));
            Cookie cResult = new Cookie("cResult", String.valueOf(result));
            cFirstVal.setMaxAge(5);
            cSecondVal.setMaxAge(5);
            cResult.setMaxAge(5);
            response.addCookie(cFirstVal);
            response.addCookie(cSecondVal);
            response.addCookie(cResult);
        }
        if (action.equals("computeLength")){
            Cookie cName = new Cookie("cName", name);
            Cookie cLength = new Cookie("cLength", String.valueOf(length));
            cName.setMaxAge(5);
            cLength.setMaxAge(5);
            response.addCookie(cName);
            response.addCookie(cLength);
        }
        response.sendRedirect(request.getContextPath()+"/lab3/cal.jsp");
    }
}
