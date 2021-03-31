package com.dabing.week4.demo;

public class student {
    public int id;
    public String username;
    public String email ;
    public String gender ;
    public String birthDate ;
    public String password;
    //id,username,email,gender,birthdate,password

    public int getid() {
        return id;
    }

    public void setId(int id) {
        id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
