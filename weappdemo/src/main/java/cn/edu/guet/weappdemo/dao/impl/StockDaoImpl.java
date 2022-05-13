package cn.edu.guet.weappdemo.dao.impl;

import cn.edu.guet.weappdemo.dao.StockDao;
import cn.edu.guet.weappdemo.util.ConnectionHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StockDaoImpl implements StockDao {
    @Override
    public void updateStock(int item_id, int stock) throws SQLException {
        try {
            conn = ConnectionHandler.getConn();
            System.out.println("StockDaoImpl:"+conn.hashCode());
            String sql = "UPDATE item_stock SET stock=stock-? WHERE item_id=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, stock);
            pstmt.setInt(2, item_id);
            pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new SQLException("库存更新失败");
        }
    }
    Connection conn = null;
}
