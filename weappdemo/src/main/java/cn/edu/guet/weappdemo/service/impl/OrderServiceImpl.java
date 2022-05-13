package cn.edu.guet.weappdemo.service.impl;

import cn.edu.guet.weappdemo.dao.impl.StockDaoImpl;
import cn.edu.guet.weappdemo.dao.OrderDao;
import cn.edu.guet.weappdemo.dao.StockDao;
import cn.edu.guet.weappdemo.dao.impl.OrderDaoImpl;
import cn.edu.guet.weappdemo.service.OrderService;
import cn.edu.guet.weappdemo.util.ConnectionHandler;
import cn.edu.guet.weappdemo.bean.Order;

import java.sql.Connection;
import java.sql.SQLException;

public class OrderServiceImpl implements OrderService {

    Connection conn = null;
    @Override
    public void newOrder(Order order, String item_id, String stock) {

        try {
            OrderDao orderDao = new OrderDaoImpl();
            StockDao stockDao = new StockDaoImpl();

            conn = ConnectionHandler.getConn();
            System.out.println("OrderService:" + conn.hashCode());
            //开启事务（必须先有Connection）
            conn.setAutoCommit(false);

            orderDao.newOrder(order);

            stockDao.updateStock(Integer.parseInt(item_id), Integer.parseInt(stock));

            conn.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            try {
                conn.rollback();
                System.out.println("事务回滚.................................................");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            // ConnectionHandler.closeConnection();
        }

    }
}
