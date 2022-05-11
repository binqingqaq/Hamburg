/*
 * Created by JFormDesigner on Tue May 10 18:21:04 CST 2022
 */

package com.lanqiao.hamburg.manage;
import com.lanqiao.hamburg.entity.Item;
import com.lanqiao.hamburg.entity.User;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author 1
 */
public class Manage extends JPanel {
    public Manage() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();

        DefaultTableModel tableModel = new DefaultTableModel(getDataFromDatabase(), head) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        table1.setModel(tableModel);
        //======== this ========
        JPanel contentPane = new JPanel();

        setLayout(null);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        add(scrollPane1);
        scrollPane1.setBounds(0, 0, 400, 155);
        {
            Dimension preferredSize = new Dimension();
            for (int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        //---- button1 ----
        button1.setText("\u6dfb\u52a0");
        add(button1);
        button1.setBounds(new Rectangle(new Point(50, 180), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("\u4fee\u6539");
        add(button2);
        button2.setBounds(new Rectangle(new Point(150, 180), button2.getPreferredSize()));

        //---- button3 ----
        button3.setText("\u5220\u9664");
        add(button3);
        button3.setBounds(new Rectangle(new Point(250, 180), button3.getPreferredSize()));

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
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    public Object[][] getDataFromDatabase() {

        java.util.List<User> list = new ArrayList<>();
        Connection conn = null;
        String dbuser = "root";
        String dbPassword = "Binqing31";
        String url = "jdbc:mysql://39.108.193.41:3306/hamburger?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        Statement stmt = null;
        String sql = "SELECT * FROM user";
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(url, dbuser, dbPassword);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                User user = new User();
                user.setUser_id(rs.getInt(1));
                user.setUser_name(rs.getString(2));
                user.setUser_key(rs.getString(3));
                user.setUser_power(rs.getInt(4));
                list.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        // 把集合的数据（商品信息）转换成二维数组
        data = new Object[list.size()][head.length];

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < head.length; j++) {
                data[i][0] = list.get(i).getUser_id();
                data[i][1] = list.get(i).getUser_name();
                data[i][2] = list.get(i).getUser_key();
                data[i][3] = list.get(i).getUser_power();
            }
        }
        return data;
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private String head[] = {"id", "用户名", "用户密码", "权限"};
    private Object[][] data = null;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        Frame frame=new Frame();
        frame.add(new Manage(),BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}
