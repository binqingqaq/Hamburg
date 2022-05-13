package com.lanqiao.hamburg.entity;

public class User {
    private int user_id;
    private String user_name;
    private String user_key;
    private int  user_power;
    public User() {

    }
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_key() {
        return user_key;
    }

    public void setUser_key(String user_key) {
        this.user_key = user_key;
    }

    public int getUser_power() {
        return user_power;
    }

    public void setUser_power(int user_power) {
        this.user_power = user_power;
    }
    public User(int user_id, String user_name, String user_key, int user_power) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_key = user_key;
        this.user_power = user_power;
    }
}
