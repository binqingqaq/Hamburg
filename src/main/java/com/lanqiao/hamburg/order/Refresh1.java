package com.lanqiao.hamburg.order;

import com.lanqiao.hamburg.order.order_info;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Refresh1 {
        public Object[][] queryData(String sql) {

            java.util.List<order_info> list = new ArrayList<order_info>();
            Connection conn = null;
            String user = "root";
            String dbPassword = "Binqing31";
            String url = "jdbc:mysql://39.108.193.41:3306/hamburger?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
            Statement stmt = null;//SQL语句对象，拼SQL
            //String sql = "SELECT * FROM order_info WHERE out_trade_no = '0'";
            System.out.println("即将执行的sql：" + sql);
            ResultSet rs = null;
            try {
                conn = DriverManager.getConnection(url, user, dbPassword);
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    //每循环一次就是一个对象，把这个对象放入容器（List（有序可重复）、Set（无序不可重复）、Map（key、value结构）
                    order_info order = new order_info();
                    order.setId(rs.getString(1));
                    order.setItem_id(rs.getInt(7));
                    //order.setTransaction_id(rs.getString(5));
                    order.setItem_price(rs.getFloat(8));
                    order.setAmount(rs.getInt(9));
                    order.setOrder_price(rs.getFloat(10));
                    //order.setOrder_time(rs.getTimestamp(4));
                    Timestamp ts = rs.getTimestamp(4);
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(ts);
                    calendar.add(Calendar.HOUR_OF_DAY,-8);
                    //calendar.getTime();
                    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String format = sdf.format(calendar.getTime());
                    ts = Timestamp.valueOf(format);

                    //Date date = new Date();
                    //long times = date.getTime();
                    //System.out.println(times);
                    order.setOrder_time(ts);
                    list.add(order);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                //释放资源：数据库连接很昂贵
                try {
                    rs.close();
                    stmt.close();
                    conn.close();//关连接
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            data = new Object[list.size()][head.length];
            //把集合里的数据放入Obejct这个二维数组
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < head.length; j++) {
                    data[i][0] = list.get(i).getId();
                    data[i][1] = list.get(i).getItem_id();
                    //data[i][2] = list.get(i).getTransaction_id();
                    data[i][2] = list.get(i).getItem_price();
                    data[i][3] = list.get(i).getAmount();
                    data[i][4] = list.get(i).getOrder_price();
                    data[i][5] = list.get(i).getOrder_time();
                }
            }
            return data;
        }
        private String head[] = {"订单id","商品id","单价","数量","总价","订单时间"};
        private Object[][] data = null;
    }

