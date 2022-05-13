package cn.edu.guet.weappdemo.dao.impl;

import cn.edu.guet.weappdemo.dao.OrderDao;
import cn.edu.guet.weappdemo.util.ConnectionHandler;
import cn.edu.guet.weappdemo.bean.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderDaoImpl implements OrderDao {
    @Override
    public void newOrder(Order order) throws SQLException {

        try {
            conn= ConnectionHandler.getConn();
            System.out.println("OrderDaoImpl:"+conn.hashCode());
            String sql="INSERT INTO order_info VALUES(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,order.getId());
            pstmt.setInt(2,order.getMch_id());
            pstmt.setString(3,order.getOut_trade_no());
            pstmt.setTimestamp(4,order.getOrder_time());
            pstmt.setString(5,order.getTransaction_id());
            pstmt.setInt(6,order.getUserId());
            pstmt.setInt(7,order.getItem_id());
            pstmt.setFloat(8,order.getItem_price());
            pstmt.setInt(9,order.getAmount());
            pstmt.setFloat(10,order.getOrder_price());

            pstmt.executeUpdate();//真正执行sql语句

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new SQLException("新增订单失败");
        }
    }

    Connection conn = null;
}
