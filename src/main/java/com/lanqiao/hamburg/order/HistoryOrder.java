package com.lanqiao.hamburg.order;

import com.mysql.cj.x.protobuf.MysqlxCursor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/*
 * Created by JFormDesigner on Sat Apr 30 10:49:21 CST 2022
 */



/**
 * @author 1
 */
public class HistoryOrder extends JFrame {
    public HistoryOrder() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label1 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        button1 = new JButton();
        button2 = new JButton();
        button6 = new JButton();
        button7 = new JButton();
        String sql = "SELECT * FROM order_info";
        DefaultTableModel tableModel = new DefaultTableModel(queryData(sql), head) {
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
        scrollPane1.setBounds(20, 105, 750, 450);

        //---- label1 ----
        label1.setText("\u5386\u53f2\u8ba2\u5355");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(320, 15), label1.getPreferredSize()));

        textField1.setText("\u4ece\u51e0\u5468\u524d\u67e5\u8be2");
        contentPane.add(textField1);
        textField1.setBounds(20, 50, 115, textField1.getPreferredSize().height);

        textField2.setText("\u4ece\u51e0\u6708\u524d\u67e5\u8be2");
        contentPane.add(textField2);
        textField2.setBounds(225, 50, 115, textField2.getPreferredSize().height);

        //---- button3 ----
        button3.setText("\u5f53\u524d\u8ba2\u5355");
        button3.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("进入当前订单");
                        setVisible(false);
                    }
                }
        );
        contentPane.add(button3);
        button3.setBounds(new Rectangle(new Point(705, 50), button3.getPreferredSize()));

        //---- button4 ----
        button4.setText("按周查询");
        contentPane.add(button4);
        button4.setBounds(new Rectangle(new Point(140, 50), button4.getPreferredSize()));
        button4.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int time = Integer.parseInt(textField1.getText())*7-1;
                        String sql = "SELECT * FROM order_info WHERE DATE_SUB(CURDATE(), INTERVAL " + time + " DAY ) <= date(order_time)";
                        WeekInquire weekInquire = new WeekInquire(sql);
                        weekInquire.setVisible(true);
                    }
                }
        );

        //---- button5 ----
        button5.setText("按月查询");
        contentPane.add(button5);
        button5.setBounds(new Rectangle(new Point(345, 50), button5.getPreferredSize()));
        button5.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int time = Integer.parseInt(textField2.getText())*30-1;
                        String sql = "SELECT * FROM order_info WHERE DATE_SUB(CURDATE(), INTERVAL " + time + " DAY ) <= date(order_time)";
                        WeekInquire weekInquire = new WeekInquire(sql);
                        weekInquire.setVisible(true);
                    }
                }
        );


        button1.setText("删除");
        button1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int index1 = table1.getSelectedRow();
                        String id= (String)table1.getValueAt(index1, 0);
                        String sql = "delete from order_info WHERE id = '" + id + "'";
                        //连接数据库
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
                        Refresh1 refresh1 = new Refresh1();
                        DefaultTableModel tableModel = new DefaultTableModel(refresh1.queryData("SELECT * FROM order_info"), head) {
                            public boolean isCellEditable(int row, int column) {
                                return false;
                            }
                        };
                        table1.setModel(tableModel);
                    }
                }
        );
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(440, 50), button1.getPreferredSize()));

        button2.setText("添加");
        button2.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        order_info order=new order_info();
                        InsertOrder insertOrder=new InsertOrder(order);
                        insertOrder.setVisible(true);
                    }
                }
        );
        contentPane.add(button2);
        button2.setBounds(510, 50, 55, button2.getPreferredSize().height);

        button6.setText("修改");
        contentPane.add(button6);
        button6.setBounds(575, 50, 55, button6.getPreferredSize().height);
        button6.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int rowNo = table1.getSelectedRow();//获取所选的行号
                        String id = (String)table1.getValueAt(rowNo,0);
                        int item_id=(int)table1.getValueAt(rowNo, 1);
                        //String transaction_id=(String)table1.getValueAt(rowNo, 2);
                        Float item_price=(Float)table1.getValueAt(rowNo, 2);
                        int amount=(int)table1.getValueAt(rowNo, 3);
                        Float order_price=(Float) table1.getValueAt(rowNo, 4);
                        Timestamp order_time=(Timestamp) table1.getValueAt(rowNo, 5);
                        System.out.println(item_id);
                        //System.out.println(transaction_id);
                        System.out.println(item_price);
                        System.out.println(amount);
                        System.out.println(order_price);
                        System.out.println(order_time);

                        order_info order=new order_info(id,item_id,item_price,amount,order_price,order_time);

                        UpdateOrder updateOrder=new UpdateOrder(order);
                        updateOrder.setVisible(true);
                    }
                }
        );
        button7.setText("刷新");
        contentPane.add(button7);
        button7.setBounds(640, 50, 55, button6.getPreferredSize().height);
        button7.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Refresh1 refresh1 = new Refresh1();
                        DefaultTableModel tableModel = new DefaultTableModel(refresh1.queryData("SELECT * FROM order_info"), head) {
                            public boolean isCellEditable(int row, int column) {
                                return false;
                            }
                        };
                        table1.setModel(tableModel);
                    }
                }
        );


        contentPane.setPreferredSize(new Dimension(815, 595));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public Object[][] queryData(String sql) {

        java.util.List<order_info> list = new ArrayList<order_info>();
        Connection conn = null;
        String user = "root";
        String dbPassword = "Binqing31";
        String url = "jdbc:mysql://39.108.193.41:3306/hamburger?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        Statement stmt = null;//SQL语句对象，拼SQL
        //String sql = "SELECT * FROM order_info";
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

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button1;
    private JButton button2;
    private JButton button6;
    private JButton button7;
    private String head[] = {"订单id","商品id","单价","数量","总价","订单时间"};
    private Object[][] data = null;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
