package com.dabing.model;


import java.sql.Date;

public class User {
    private   int id;
    private  String username;
    private  String email ;
    private  String gender ;
    private  Date birthdate ;
    private  String password;

    public User(int id, String username, String email, String gender, Date birthdate, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.gender = gender;
        this.birthdate = birthdate;
        this.password = password;
    }

    public User() {

    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthDate() {
        return birthdate;
    }

    public void setBirthDate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", birthdate=" + birthdate +
                ", password='" + password + '\'' +
                '}';
    }
}
