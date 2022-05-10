package com.lanqiao.hamburg.MySaleShow.dao.Impl;

import com.lanqiao.hamburg.MySaleShow.dao.UserDao;
import com.lanqiao.hamburg.MySaleShow.entity.user;
import com.lanqiao.hamburg.MySaleShow.util.ConnectionHandler;
import com.lanqiao.hamburg.entity.User;

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
     * @description: 查询user表中指定用户名和密码记录
     * @param user: 
     * @return user: 返回被更新的实体类对象
     * @author: DavidNan
     * @date: 2022/5/8 19:44
     */
    
    @Override
    public user LoginSelect(user user){
        Connection conn=null;
        String sql = "SELECT * FROM user WHERE user_name='" +
                user.getUser_name()
                + "' AND user_key='" + user.getUser_key() + "'";
        System.out.println("执行语句:"+sql);
        ResultSet rs = null;//结果集：内存，存储了查询到的数据；内存区有一个游标，执行完查询的时候，不指向任何记录
        Statement stmt = null;//语句对象，容易产生注入攻击
        try {
            conn = ConnectionHandler.getConn(); //需要优化异常所以选择不执行直接抛出
            System.out.println("UserDaoImpl:" + conn.hashCode());
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){    // 若找不到则不执行
                //查询到的关键更新到user表 -- 尽量降低与控制器的耦合度
                user.setUser_id(rs.getInt(1));
                user.setUser_name(rs.getString(2));
                user.setUser_key(rs.getString(3));
                user.setUser_power(rs.getInt(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
      return user;  // 最后返回用户实体类对象
    }

    /**
     * @description: 用于注册时插入user表
     * @param user: 从查询ID和文本域构造并传入
     * @return void
     * @author: DavidNan
     * @date: 2022/5/8 19:46
     */
    
    @Override
    public void register(user user) {
        String sql = "insert into user(user_id,user_name,user_key) values(?,?,?)"; //先修改用户表主键自动增长
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
     * @description: 获取最后一个ID，只有有user表有ID时用到
     * @param :
     * @return void
     * @author: DavidNan
     * @date: 2022/5/10 10:53
     */

    @Override
    public user SelectEndID() {

        user user = new user();
        String sql = "select max(user_id) from user;"; //因为ID有序增长
        System.out.println("执行语句:"+sql);

        try {
            conn = ConnectionHandler.getConn(); //需要优化异常所以选择不执行直接抛出
            System.out.println("UserDaoImpl:" + conn.hashCode());
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){    // 若找不到则不执行
                //查询到的关键更新到user表 -- 尽量降低与控制器的耦合度
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
