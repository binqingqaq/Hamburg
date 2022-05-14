package com.lanqiao.hamburg.order;

import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.sql.*;
        import java.text.SimpleDateFormat;
        import java.util.ArrayList;
        import java.util.Calendar;
        import javax.swing.*;
        import javax.swing.table.DefaultTableModel;
/*
 * Created by JFormDesigner on Sun May 01 17:12:17 CST 2022
 */



/**
 * @author 1
 */
public class NowOrder1 extends JPanel {
    public NowOrder1() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        DefaultTableModel tableModel = new DefaultTableModel(queryData(), head) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table1.setModel(tableModel);

        //======== this ========
        setLayout(null);

        //---- label1 ----
        label1.setText("\u5f53\u524d\u8ba2\u5355");
        add(label1);
        label1.setBounds(new Rectangle(new Point(385, 30), label1.getPreferredSize()));

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        add(scrollPane1);
        scrollPane1.setBounds(25, 75, 660, 455);

        //---- button1 ----
        button1.setText("\u786e\u8ba4\u6536\u8d27");
        add(button1);
        button1.setBounds(new Rectangle(new Point(710, 105), button1.getPreferredSize()));
        button1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("确认收货");
                        int rowNo = table1.getSelectedRow();//获取所选的行号
                        int colnum = (int)table1.getValueAt(rowNo,0);
                        int id = (int)table1.getValueAt(rowNo,1);
                        int num = (int)table1.getValueAt(rowNo,3);
                        Float price = (Float)table1.getValueAt(rowNo,4);
                        Receive receive = new Receive();
                        receive.insert(id,num,price);
                        String sql = "DELETE from ShopCar WHERE colnum = " + colnum;
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
                        DefaultTableModel tableModel = new DefaultTableModel(refresh.queryData("SELECT * FROM ShopCar "), head) {
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
        add(button2);
        button2.setBounds(new Rectangle(new Point(710, 285), button2.getPreferredSize()));
        button2.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("进入历史订单");
                        HistoryOrder historyOrder = new HistoryOrder();
                        historyOrder.setVisible(true);
                    }
                }
        );

        //---- button3 ----
        button3.setText("刷新");
        add(button3);
        button3.setBounds(710, 465, 55, button3.getPreferredSize().height);
        button3.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
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

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < getComponentCount(); i++) {
                Rectangle bounds = getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            setMinimumSize(preferredSize);
            setPreferredSize(preferredSize);
        }

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
        String sql = "SELECT * FROM order_info WHERE out_trade_no = '0'";
        System.out.println("即将执行的sql：" + sql);
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(url, user, dbPassword);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //每循环一次就是一个对象，把这个对象放入容器（List（有序可重复）、Set（无序不可重复）、Map（key、value结构）
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
            }
        }
        return data;
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private String head[] = {"序号","商品id","商品名称","数量","价钱"};
    private Object[][] data = null;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

}
