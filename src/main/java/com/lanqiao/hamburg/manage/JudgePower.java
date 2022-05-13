package com.lanqiao.hamburg.manage;

import com.lanqiao.hamburg.entity.User;

import javax.swing.*;
import java.sql.*;

/**
 * @Author Administrator
 * @Date
 * @Version
 */
public class JudgePower extends JFrame {
    public int select(){
        int user_id = 404;
        Connection conn = null;
        String dbuser = "root";
        String dbPassword = "Binqing31";
        String url = "jdbc:mysql://39.108.193.41:3306/hamburger?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        Statement stmt = null;
        String sql = "SELECT * FROM CurrentUser ORDER BY loginNum DESC LIMIT 0,1;";
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(url, dbuser, dbPassword);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                
                user_id=rs.getInt(2);
                System.out.println("当前账户ID："+user_id);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        return user_id;
    }
    public int judge(int user_id){
        int power=0;
        Connection conn = null;
        String dbuser = "root";
        String dbPassword = "Binqing31";
        String url = "jdbc:mysql://39.108.193.41:3306/hamburger?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        Statement stmt = null;
        String sql = "SELECT * FROM user WHERE user_id="+user_id;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(url, dbuser, dbPassword);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {

                power=rs.getInt(4);
                System.out.println("当前账户权限："+power);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        return power;
    }
}
