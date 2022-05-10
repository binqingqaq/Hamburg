package com.lanqiao.hamburg.MySaleShow.dao.Impl;

import com.lanqiao.hamburg.MySaleShow.dao.UserDao;
import com.lanqiao.hamburg.MySaleShow.entity.user;
import com.lanqiao.hamburg.MySaleShow.util.ConnectionHandler;
import com.lanqiao.hamburg.MySaleShow.entity.*;

import java.sql.*;

/**
 * @version 1.0
 * @Author qin
 * @Date 2022/5/8 17:43
 */
public class UserDaoImpl implements UserDao {

    ResultSet rs=null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    Connection conn=null;
    
    /**
     * @description: According to the name and password, go
     * to the database to find the same data and load it with
     * the user object and return it
     * @param user: 
     * @return user:
     * @author: DavidNan
     * @date: 2022/5/8 19:44
     */
    
    @Override
    public user LoginSelect(user user){
        String sql = "SELECT * FROM user WHERE user_name='" +
                user.getUser_name()
                + "' AND user_key='" + user.getUser_key() + "'";

        try {
            conn = ConnectionHandler.getConn();
            System.out.println("UserDaoImpl:" + conn.hashCode());
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                user.setUser_id(rs.getInt(1));
                user.setUser_name(rs.getString(2));
                user.setUser_key(rs.getString(3));
                user.setUser_power(rs.getInt(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
      return user;
    }

    /**
     * @description: register insert user table
     * @param user:
     * @return void
     * @author: DavidNan
     * @date: 2022/5/8 19:46
     */
    
    @Override
    public void register(user user) {
        String sql = "insert into user(user_id,user_name,user_key) values(?,?,?)";
        String date = "";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,user.getUser_id());
            pstmt.setString(2,user.getUser_name());
            pstmt.setString(3,date);
            pstmt.executeUpdate();
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

    /**
     * @description: Query the last ID of the table
     * Returns a user object for loading other data
     * @param :
     * @return void
     * @author: DavidNan
     * @date: 2022/5/10 10:53
     */

    @Override
    public user SelectEndID() {

        user user = new user();
        String sql = "select max(user_id) from user;";
        try {
            conn = ConnectionHandler.getConn();
            System.out.println("UserDaoImpl:" + conn.hashCode());
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){
               user.setUser_id(rs.getInt(1));
            }
            ConnectionHandler.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


    public static void main(String[] args) throws SQLException {
        UserDao test = new UserDaoImpl();
        System.out.println(test.LoginSelect(new user()));
    }
}
