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
     * @description: ��ѯuser����ָ���û����������¼
     * @param user: 
     * @return user: ���ر����µ�ʵ�������
     * @author: DavidNan
     * @date: 2022/5/8 19:44
     */
    
    @Override
    public user LoginSelect(user user){
        Connection conn=null;
        String sql = "SELECT * FROM user WHERE user_name='" +
                user.getUser_name()
                + "' AND user_key='" + user.getUser_key() + "'";
        System.out.println("ִ�����:"+sql);
        ResultSet rs = null;//��������ڴ棬�洢�˲�ѯ�������ݣ��ڴ�����һ���αִ꣬�����ѯ��ʱ�򣬲�ָ���κμ�¼
        Statement stmt = null;//���������ײ���ע�빥��
        try {
            conn = ConnectionHandler.getConn(); //��Ҫ�Ż��쳣����ѡ��ִ��ֱ���׳�
            System.out.println("UserDaoImpl:" + conn.hashCode());
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){    // ���Ҳ�����ִ��
                //��ѯ���Ĺؼ����µ�user�� -- �������������������϶�
                user.setUser_id(rs.getInt(1));
                user.setUser_name(rs.getString(2));
                user.setUser_key(rs.getString(3));
                user.setUser_power(rs.getInt(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
      return user;  // ��󷵻��û�ʵ�������
    }

    /**
     * @description: ����ע��ʱ����user��
     * @param user: �Ӳ�ѯID���ı����첢����
     * @return void
     * @author: DavidNan
     * @date: 2022/5/8 19:46
     */
    
    @Override
    public void register(user user) {
        String sql = "insert into user(user_id,user_name,user_key) values(?,?,?)"; //���޸��û��������Զ�����
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
     * @description: ��ȡ���һ��ID��ֻ����user����IDʱ�õ�
     * @param :
     * @return void
     * @author: DavidNan
     * @date: 2022/5/10 10:53
     */

    @Override
    public user SelectEndID() {

        user user = new user();
        String sql = "select max(user_id) from user;"; //��ΪID��������
        System.out.println("ִ�����:"+sql);

        try {
            conn = ConnectionHandler.getConn(); //��Ҫ�Ż��쳣����ѡ��ִ��ֱ���׳�
            System.out.println("UserDaoImpl:" + conn.hashCode());
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){    // ���Ҳ�����ִ��
                //��ѯ���Ĺؼ����µ�user�� -- �������������������϶�
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
