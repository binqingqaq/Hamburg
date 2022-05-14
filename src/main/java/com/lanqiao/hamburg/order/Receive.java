package com.lanqiao.hamburg.order;

import java.sql.*;
import java.util.Date;

public class Receive {
    public void insert(int id,int num,Float price){
        java.util.Date sysdate = new Date();
        String time = String.format("%tF %tT", sysdate, sysdate);
        System.out.println(time);
        Connection conn = null;
        String user = "root";
        String dbPassword = "Binqing31";
        String url = "jdbc:mysql://39.108.193.41:3306/hamburger?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        Statement stmt = null;//SQL语句对象，拼SQL
        String sql = "insert into order_info Values('0',0,'0','" + time +
                "','0',0," + id + "," + price/num + "," + num + "," + price + ")";
        System.out.println("即将执行的sql：" + sql);
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(url, user, dbPassword);
            stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

