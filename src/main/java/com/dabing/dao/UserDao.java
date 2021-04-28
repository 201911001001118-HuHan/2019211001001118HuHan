package com.dabing.dao;

import com.dabing.model.User;
import java.sql.Connection;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
public class UserDao implements IUserDao{
    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        String sql = "insert into usertable(id,username,email,gender,birthdate,password) values(?,?,?,?,?,?) " ;
        PreparedStatement st = con.prepareStatement(sql);
        st.executeUpdate();
        st.setInt(1,user.getId());
        st.setString(2, user.getUsername());
        st.setString(3, user.getEmail());
        st.setString(4, user.getGender());
        st.setDate(5, user.getBirthDate());
        st.setString(6, user.getPassword());
        return true;
//        ResultSet rs = st.executeQuery();
//        if(rs.next()){
//            user = new User();
//            user.setId(rs.getInt("id"));
//            user.setUsername(rs.getString("username"));
//            user.setEmail(rs.getString("email"));
//            user.setGender(rs.getString("gender"));
//            user.setBirthDate(rs.getDate("birthdate"));
//            user.setPassword(rs.getString("password"));
//        }else{
//            return false;
//        }
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        String sql="delete from usertable where id=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setInt(1,user.getId());
        return st.executeUpdate();
//        ResultSet rs=st.executeQuery();
//        if(rs.next()){
//            user = new User();
//            user.setId(rs.getInt("id"));
//            user.setUsername(rs.getString("username"));
//            user.setEmail(rs.getString("email"));
//            user.setGender(rs.getString("gender"));
//            user.setBirthDate(rs.getDate("birthdate"));
//            user.setPassword(rs.getString("password"));
//        }
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        String sql="update usertable set username=?,email=?,gender=?,birthdate=?,password=? where id=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1, user.getUsername());
        st.setString(2, user.getEmail());
        st.setString(3, user.getGender());
        st.setDate(4, user.getBirthDate());
        st.setString(5, user.getPassword());
        st.setInt(6,user.getId());
        return st.executeUpdate();

//        ResultSet rs=st.executeQuery();
//        if(rs.next()){
//            user = new User();
//            user.setId(rs.getInt("id"));
//            user.setUsername(rs.getString("username"));
//            user.setEmail(rs.getString("email"));
//            user.setGender(rs.getString("gender"));
//            user.setBirthDate(rs.getDate("birthdate"));
//            user.setPassword(rs.getString("password"));
//        }
//        return 0;
    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        String sql = "select * from usertable where id =?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, id);
        ResultSet rs = st.executeQuery();
        User user = null;
        if(rs.next())
        {
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));
            user.setPassword(rs.getString("password"));
        }
        return user;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        String sql = "select * from usertable where username=? and password=?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, username);
        st.setString(2, password);
        ResultSet rs = st.executeQuery();
        User user = null;
        if(rs.next())
        {
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));
            user.setPassword(rs.getString("password"));
        }
        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        List<User> UserList = new ArrayList<User>();
        String sql="select * from usertable where username=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,username);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));
            user.setPassword(rs.getString("password"));
        }
        return UserList;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        List<User> UserList = new ArrayList<User>();
        String sql="select * from usertable where password=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,password);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));
            user.setPassword(rs.getString("password"));
        }
        return UserList;
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        List<User> UserList = new ArrayList<User>();
        String sql="select * from usertable where email=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,email);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));
            user.setPassword(rs.getString("password"));
        }
        return UserList;
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        List<User> UserList = new ArrayList<User>();
        String sql="select * from usertable where gender=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,gender);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));
            user.setPassword(rs.getString("password"));
        }
        return UserList;
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        List<User> UserList = new ArrayList<User>();
        String sql="select * from usertable where birthdate=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setDate(1, birthDate);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));
            user.setPassword(rs.getString("password"));
        }
        return UserList;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        List<User> UserList = new ArrayList<User>();
        String sql="select * from usertable ";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));
            user.setPassword(rs.getString("password"));
        }
        return UserList;
    }
}
