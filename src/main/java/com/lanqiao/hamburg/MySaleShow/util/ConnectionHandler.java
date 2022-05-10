package com.lanqiao.hamburg.MySaleShow.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @version 1.0
 * @Author qin
 * @Date 2022/5/2 19:57
 */
public class ConnectionHandler {

    public static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    public static Connection getConn() throws SQLException {

        Connection conn=threadLocal.get();

        if(conn==null){
            String user = "root";
            String dbPassword = "Binqing31";
            String url = "jdbc:mysql://39.108.193.41:3306/hamburger?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
            conn = DriverManager.getConnection(url, user, dbPassword);
            threadLocal.set(conn);
        }
        return conn;
    }
    public static void closeConnection() throws SQLException {
        Connection conn=threadLocal.get();
        if(conn!=null){
            conn.close();
            threadLocal.remove();
        }
    }
}

