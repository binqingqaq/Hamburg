package com.lanqiao.hamburg.MySaleShow.dao.Impl;

import com.lanqiao.hamburg.MySaleShow.dao.CurrentUserDao;
import com.lanqiao.hamburg.MySaleShow.entity.CurrentUser;
import com.lanqiao.hamburg.MySaleShow.entity.user;
import com.lanqiao.hamburg.MySaleShow.util.ConnectionHandler;

import java.sql.*;

/**
 * @version 1.0
 * @Author qin
 * @Date 2022/5/8 19:39
 */
public class CurrentUserDaoImpl implements CurrentUserDao {
    ResultSet rs=null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    Connection conn=null;
    /**
     * @description: 登录成功时记录实现接口方法,注意关系表执行有先后不要贪杯
     * @param user: 
     * @return void
     * @author: DavidNan
     * @date: 2022/5/8 19:48
     */

    @Override
    public void RegistrationRecord(user user){
        String SQL[]={"SELECT NOW()","insert into CurrentUser(user_id,user_name,Logintime) values(?,?,?)"};
        String date = "";
        try {
            conn = ConnectionHandler.getConn();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL[0]);
            while(rs.next()){
                System.out.println(rs.getString(1));//测试获取当前时间查询一定会成功因此用while;
                date = rs.getString(1);
            }
            pstmt = conn.prepareStatement(SQL[1]);
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
     * @description: 查询当前用户和ID,只要第一行,每次切换用户记得删除该表数据再插入
     * @param : 
     * @return void
     * @author: DavidNan
     * @date: 2022/5/9 11:56
     */
    
    @Override
    public CurrentUser QueryUser(){
      
        CurrentUser currentUser = new CurrentUser();
        String sql = "select distinct * from CurrentUser";
        try {
            conn = ConnectionHandler.getConn();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getString(1));
                currentUser.setUser_id(rs.getInt(2));
                currentUser.setUser_name(rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return currentUser;
    }
    /**
     * @description: 简单粗暴删除整个表数据，保证每次登录数据的唯一性
     * @param : 
     * @return void
     * @author: DavidNan
     * @date: 2022/5/9 19:00
     */
    
    @Override
    public void DelLoginData() {
        String sql = "delete from CurrentUser";
        try {
            conn = ConnectionHandler.getConn();
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            pstmt.close();
            ConnectionHandler.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @description: 测试代码
     * @param args: 
     * @return void
     * @author: DavidNan
     * @date: 2022/5/8 20:19
     */
    
    public static void main(String[] args) throws SQLException {
        CurrentUserDao test = new CurrentUserDaoImpl();
        test.RegistrationRecord(new user());
    }
}
