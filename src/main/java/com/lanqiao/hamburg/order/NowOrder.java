package com.lanqiao.hamburg.order;

import com.lanqiao.hamburg.order.HistoryOrder;
import com.lanqiao.hamburg.order.Refresh;
import com.lanqiao.hamburg.order.ShopCar;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/*
 * Created by JFormDesigner on Sat Apr 30 10:14:47 CST 2022
 */



/**
 * @author 1
 */
public class NowOrder extends JFrame {
    public NowOrder() {
        initComponents();
    }

    private void initComponents() {

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label1 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        DefaultTableModel tableModel = new DefaultTableModel(queryData(), head) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table1.setModel(tableModel);

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(10, 45, 650, 500);

        //---- label1 ----
        label1.setText("\u5f53\u524d\u8ba2\u5355");
        contentPane.add(label1);
        label1.setBounds(320, 5, 55, 35);

        //---- button1 ----
        button1.setText("\u786e\u8ba4\u6536\u8d27");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(700, 50), button1.getPreferredSize()));
        button1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("确认收货");
                        int rowNo = table1.getSelectedRow();//获取所选的行号
                        int colunm = (int)table1.getValueAt(rowNo,0);
                        String sql = "DELETE from ShopCar WHERE colnum = " + colunm;
                        Connection conn = null;
                        String user = "root";
                        String dbPassword = "Binqing31";
                        String url = "jdbc:mysql://39.108.193.41:3306/hamburger?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
                        Statement statement = null;
                        ResultSet rs = null;
                        try {
                            conn = DriverManager.getConnection(url,user,dbPassword);
                            statement = conn.createStatement();
                            statement.execute(sql);
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        Refresh refresh = new Refresh();
                        DefaultTableModel tableModel = new DefaultTableModel(refresh.queryData("SELECT * FROM ShopCar"), head) {
                            public boolean isCellEditable(int row, int column) {
                                return false;
                            }
                        };
                        table1.setModel(tableModel);
                    }
                }
        );


        //---- button2 ----
        button2.setText("\u5386\u53f2\u8ba2\u5355");
        button2.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("进入历史订单");
                        HistoryOrder historyOrder = new HistoryOrder();
                        historyOrder.setVisible(true);
                    }
                }
        );
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(700, 110), button2.getPreferredSize()));


        contentPane.setPreferredSize(new Dimension(815, 595));
        pack();
        setLocationRelativeTo(getOwner());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    public Object[][] queryData() {

        java.util.List<ShopCar> list = new ArrayList<ShopCar>();
        Connection conn = null;
        String user = "root";
        String dbPassword = "Binqing31";
        String url = "jdbc:mysql://39.108.193.41:3306/hamburger?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        Statement stmt = null;//SQL语句对象，拼SQL
        String sql = "SELECT * FROM ShopCar";
        System.out.println("即将执行的sql：" + sql);
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(url, user, dbPassword);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //每循环一次就是一个对象，把这个对象放入容器（List（有序可重复）、Set（无序不可重复）、Map（key、value结构）
                //order_info order = new order_info();
                ShopCar shopCar = new ShopCar();
                shopCar.setColnum(rs.getInt(1));
                shopCar.setId(rs.getInt(2));
                shopCar.setTitle(rs.getString(7));
                shopCar.setNum(rs.getInt(4));
                shopCar.setPrice(rs.getFloat(3));
                //shopCar.setUser_id(rs.getInt(5));
                // order.setId(rs.getString(1));
                /*order.setItem_id(rs.getInt(7));
                order.setTransaction_id(rs.getString(5));
                order.setItem_price(rs.getFloat(8));
                order.setAmount(rs.getInt(9));
                order.setOrder_price(rs.getFloat(10));*/
                //order.setOrder_time(rs.getTimestamp(4));
                /*Timestamp ts = rs.getTimestamp(4);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(ts);
                calendar.add(Calendar.HOUR_OF_DAY,-8);
                //calendar.getTime();
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String format = sdf.format(calendar.getTime());
                ts = Timestamp.valueOf(format);*/

                //Date date = new Date();
                //long times = date.getTime();
                //System.out.println(times);
                list.add(shopCar);
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
                data[i][0] = list.get(i).getColnum();
                data[i][1] = list.get(i).getId();
                data[i][2] = list.get(i).getTitle();
                data[i][3] = list.get(i).getNum();
                data[i][4] = list.get(i).getPrice();
                /*data[i][1] = list.get(i).getItem_id();
                data[i][2] = list.get(i).getTransaction_id();
                data[i][3] = list.get(i).getItem_price();
                data[i][4] = list.get(i).getAmount();
                data[i][5] = list.get(i).getOrder_price();
                data[i][6] = list.get(i).getOrder_time();*/
            }
        }
        return data;
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variable
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label1;
    private JButton button1;
    private JButton button2;
    private String head[] = {"序号","商品id","商品名称","数量","价钱"};
    private Object[][] data = null;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        new NowOrder();
    }
}





