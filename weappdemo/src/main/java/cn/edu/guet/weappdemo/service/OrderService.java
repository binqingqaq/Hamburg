package cn.edu.guet.weappdemo.service;

import cn.edu.guet.weappdemo.bean.Order;

import java.sql.SQLException;

public interface OrderService {
    void newOrder(Order order, String item_id, String stock) throws SQLException;
}
