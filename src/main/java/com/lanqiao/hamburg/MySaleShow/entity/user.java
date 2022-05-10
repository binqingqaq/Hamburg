package com.lanqiao.hamburg.MySaleShow.entity;

import java.util.Objects;

/**
 * @version 1.0
 * @Author qin
 * @Date 2022/5/8 17:59
 */
public class user {

    private int user_id;
    private String user_key;
    private int user_power;
    private String user_name="DavidNan";

    public user() {

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

    public user(int user_id, String user_name, String user_key, int user_power) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_key = user_key;
        this.user_power = user_power;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        user user = (user) o;
        return user_id == user.user_id && user_power == user.user_power && Objects.equals(user_name, user.user_name) && Objects.equals(user_key, user.user_key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, user_name, user_key, user_power);
    }

    @Override
    public String toString() {
        return "user{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_key='" + user_key + '\'' +
                ", user_power=" + user_power +
                '}';
    }



}
