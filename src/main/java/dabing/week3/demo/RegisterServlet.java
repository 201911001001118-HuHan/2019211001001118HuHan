package dabing.week3.demo;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.*;

@WebServlet(
        urlPatterns = {"/register"}
)
public class RegisterServlet extends HttpServlet {
    Connection con = null;
    @Override
    public void init() throws ServletException {
          super.init();


//        String driver ="com.microsoft.sqlserver.jdbc.SQLServerDriver";
//        String url = "jdbc:sqlserver://localhost:1433; DatabaseName=userdb";
//        String username ="sa";
//        String password = "123456789";
//        ServletConfig config = getServletConfig();
//        String driver = config.getInitParameter("driver");
//        String url = config.getInitParameter("url");
//        String username = config.getInitParameter("username");
//        String password = config.getInitParameter("password");
//        try {
//            Class.forName(driver);
//            //注册驱动
//            con = DriverManager.getConnection(url,username,password);
//            System.out.println("init()-->"+con);
//        }catch (ClassNotFoundException | SQLException e) { //SQLException异常
//            e.printStackTrace();
//        }
        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        add(request,response);
        response.sendRedirect("login.jsp");

//        request.getRequestDispatcher("userlist.jsp").forward(request,response);

    }




    public void add(HttpServletRequest request,HttpServletResponse response) {
        int resultSet;
        PreparedStatement pre = null;
        String Id=request.getParameter("id");
        String Username=request.getParameter("username");
        String Email=request.getParameter("email");
        String Password=request.getParameter("password");
        String Gender=request.getParameter("gender");
        String Birthdate=request.getParameter("birthDate");
        String sql = "insert into usertable(id,username,email,gender,birthdate,password) values(?,?,?,?,?,?) " ;
        try {
            pre = con.prepareStatement(sql);
            pre.setString(1,Id);
            pre.setString(2,Username);
            pre.setString(3,Email);
            pre.setString(4,Gender);
            pre.setString(5,Birthdate);
            pre.setString(6,Password);
            resultSet = pre.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
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
//
//        try{
//            Statement st=con.createStatement();
//            String sql = "insert into usertable(username,email,gender,birthdate,password) " +
//                    "values ('"+Username+"','"+Password+"','"+Email+"','"+Gender+"','"+Birthdate+"')";
//            int n=st.executeUpdate(sql);
//             sql="select username,email,gender,birthdate,password from usertable";
//            ResultSet rs = st.executeQuery(sql);
//            request.setAttribute("rname",rs);

//            try (PrintWriter writer = response.getWriter()) {
//                while (rs.next()) {
//
//                    writer.println("<tr>");
//                    writer.println("<td>" + rs.getInt("id") + "</td>");
//                    writer.println("<td>" + rs.getString("username") + "</td>");
//                    writer.println("<td>" + rs.getString("password") + "</td>");
//                    writer.println("<td>" + rs.getString("email") + "</td>");
//                    writer.println("<td>" + rs.getString("gender") + "</td>");
//                    writer.println("<td>" + rs.getString("birthdate") + "</td>");
//                    writer.println("<tr>");
//                }
//            }
//            pre = con.prepareStatement(sql);
//            request.setAttribute("rsname",pre);
//            pre.setString(1,Username);
//            pre.setString(2,Email);
//            pre.setString(3,Gender);
//            pre.setString(4,Birthdate);
//            pre.setString(5,Password);


//        } catch (SQLException | IOException throwables) {
//            throwables.printStackTrace();
//        }
//    }


//
//    public void init() throws ServletException {
////        String driver ="com.microsoft.sqlserver.jdbc.SQLServerDriver";
////        String url = "jdbc:sqlserver://localhost:1433; DatabaseName=userdb";
////        String username ="sa";
////        String password = "123456789";
//        ServletConfig config = getServletConfig();
//        String driver = config.getInitParameter("driver");
//        String url = config.getInitParameter("url");
//        String username = config.getInitParameter("username");
//        String password = config.getInitParameter("password");
//        try {
//            Class.forName(driver);
//            //注册驱动
//            con = DriverManager.getConnection(url,username,password);
//            System.out.println("init()-->"+con);
//        }catch (ClassNotFoundException | SQLException e) { //SQLException异常
//            e.printStackTrace();
//        }
//    }
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("i am in doGet()");
//        String sql = "select * from usertable";
//        Writer writer = response.getWriter();
//        try {
//            ResultSet rs = con.createStatement().executeQuery(sql);
//            while (rs.next()){
//                PrintWriter writer1 = response.getWriter();
//                writer1.println("<table border=\"1\">");
//                writer1.println("<tr>");
//                writer1.println("<td>id</td>");
//                writer1.println("<td>userName</td>");
//                writer1.println("<td>email</td>");
//                writer1.println("<td>gender</td>");
//                writer1.println("<td>password</td>");
//                writer1.println("<td>birthday</td>");
//                writer1.println("</tr>");
//                writer.write("<td>"+rs.getInt("id")+"</td>");
//                writer.write("<td>"+rs.getString("username")+"</td>");
//                writer.write("<td>"+rs.getString("email")+"</td>");
//                writer.write("<td>"+rs.getString("gender")+"</td>");
//                writer.write("<td>"+rs.getString("password")+"</td>");
//                writer.write("<td>"+rs.getDate("birthdate")+"</td>");
//                writer.write("\n");
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//    }




//    String Username=request.getParameter("Username");
//    String Email=request.getParameter("Email");
//    String Password=request.getParameter("Password");
//    String Gender=request.getParameter("Gender");
//    String Birthdate=request.getParameter("Birthdate");
//        try {
//                Statement st=con.createStatement();
//                String sql = "insert into usertable(username,email,gender,birthdate,password) " +
//                "values ('"+Username+"','"+Email+"','"+Gender+"','"+Birthdate+"','"+Password+"')";
//                int n=st.executeUpdate(sql);
//                System.out.println("n-->"+n);
//                response.sendRedirect("login.jsp");
//                } catch (SQLException | IOException throwables) {
//                throwables.printStackTrace();
//                }

//        /*
//        request 对象接收来自用户端对服务器的指令，response对象从服务器输出信息到用户端
//         */
//
//        String Username = request.getParameter("Username");//接收从网页收到的Username=**的值
//        String Password = request.getParameter("Password");
//        String Email = request.getParameter("Email");
//        String sex = request.getParameter("sex");
//        String birthday = request.getParameter("birthday");
//        PrintWriter writer = response.getWriter();
//        writer.println("<br/>Username:"+Username);//可识别html语言
//        writer.println("<br/>Password:"+Password);
//        writer.println("<br/>Email:"+Email);
//        writer.println("<br/>sex:"+sex);
//        writer.println("<br/>birthday:"+birthday);
//        writer.close();
//
//    }
