package cn.edu.guet.weappdemo.bean;

import java.util.Objects;

/**
 * @version 1.0
 * @Author qin
 * @Date 2022/5/8 19:27
 */
public class CurrentUser {
    public CurrentUser() {

    }



    public int getLoginNum() {
        return loginNum;
    }

    public void setLoginNum(int loginNum) {
        this.loginNum = loginNum;
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

    public String getLoginTime() {
        return LoginTime;
    }

    public void setLoginTime(String loginTime) {
        LoginTime = loginTime;
    }

    private int loginNum;

    public CurrentUser(int loginNum, int user_id, String user_name, String loginTime) {
        this.loginNum = loginNum;
        this.user_id = user_id;
        this.user_name = user_name;
        LoginTime = loginTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrentUser that = (CurrentUser) o;
        return loginNum == that.loginNum && user_id == that.user_id && Objects.equals(user_name, that.user_name) && Objects.equals(LoginTime, that.LoginTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loginNum, user_id, user_name, LoginTime);
    }

    @Override
    public String toString() {
        return "CurrentUser{" +
                "loginNum=" + loginNum +
                ", user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", LoginTime='" + LoginTime + '\'' +
                '}';
    }

    private int user_id;
    private String user_name="DavidNan";
    private String LoginTime;
}
