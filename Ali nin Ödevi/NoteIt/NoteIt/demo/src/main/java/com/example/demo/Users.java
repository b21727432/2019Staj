package com.example.demo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Entity;


@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    private String username;
    private String password;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    private String role;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }



    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Users(String username, String password,String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
    public Users(int id,String username,String password){
        this.id = id;
        this.username = username;
        this.password = password;
    }
    public Users() {
    }
}
