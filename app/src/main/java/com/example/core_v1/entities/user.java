package com.example.core_v1.entities;

public class user {

    private int user_id;
    private String name;
    private String password;

    public user(int user_id, String name, String password) {
        this.user_id = user_id;
        this.name = name;
        this.password = password;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
