/*
 * Created by JFormDesigner on Sat Apr 30 16:37:40 CST 2022
 */

package com.lanqiao.hamburg.Discount;

import java.awt.*;
import java.sql.*;
import javax.swing.*;

/**
 * @author 1
 */


public class DiscountForm extends JPanel {

    public static Connection getCnnection(){
        Connection conn = null;
        String name = "root";
        String password = "Binqing31";
        String url = "jdbc:mysql://39.108.193.41:3306/hamburger?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        String sql = "SELECT * FROM user WHERE user_name='" + name + "' AND user_key='" + password + "'";
        System.out.println(sql);
        try {
            conn = DriverManager.getConnection(url,name,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }

    public static void main(String[] args){
        Connection conn = getCnnection();
        String sql = "select * from item";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet res = stmt.executeQuery();
            while (res.next()){
                System.out.println(res.getFloat("price"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public DiscountForm() {
        initComponents();
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        button1 = new JButton();
        button2 = new JButton();
        label5 = new JLabel();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        button6 = new JButton();
        button7 = new JButton();
        button8 = new JButton();
        button9 = new JButton();
        button10 = new JButton();

        //======== this ========
        setLayout(null);

        //---- button1 ----
        button1.setText("\u62531\u6298");
        add(button1);
        button1.setBounds(new Rectangle(new Point(350, 120), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("\u62532\u6298");
        add(button2);
        button2.setBounds(new Rectangle(new Point(260, 120), button2.getPreferredSize()));

        //---- label5 ----
        label5.setText("\u6d3b\u52a8\u4f18\u60e0");
        add(label5);
        label5.setBounds(315, 15, 75, 35);

        //---- button3 ----
        button3.setText("\u62533\u6298");
        add(button3);
        button3.setBounds(new Rectangle(new Point(170, 120), button3.getPreferredSize()));

        //---- button4 ----
        button4.setText("\u62534\u6298");
        add(button4);
        button4.setBounds(new Rectangle(new Point(80, 120), button4.getPreferredSize()));

        //---- button5 ----
        button5.setText("\u62535\u6298");
        add(button5);
        button5.setBounds(new Rectangle(new Point(440, 80), button5.getPreferredSize()));

        //---- button6 ----
        button6.setText("\u62536\u6298");
        add(button6);
        button6.setBounds(new Rectangle(new Point(350, 80), button6.getPreferredSize()));

        //---- button7 ----
        button7.setText("\u62537\u6298");
        add(button7);
        button7.setBounds(new Rectangle(new Point(260, 80), button7.getPreferredSize()));

        //---- button8 ----
        button8.setText("\u62538\u6298");
        add(button8);
        button8.setBounds(new Rectangle(new Point(170, 80), button8.getPreferredSize()));

        //---- button9 ----
        button9.setText("\u62539\u6298");
        add(button9);
        button9.setBounds(new Rectangle(new Point(80, 80), button9.getPreferredSize()));

        //---- button10 ----
        button10.setText("\u64a4\u9500\u6253\u6298");
        add(button10);
        button10.setBounds(new Rectangle(new Point(440, 120), button10.getPreferredSize()));

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
        button1.addActionListener(a->{
            Connection conn = getCnnection();
            String sql = "update item set Preferential_price=price*0.1";
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                int rest = stmt.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        button2.addActionListener(a->{
            Connection conn = getCnnection();
            String sql = "update item set Preferential_price=price*0.2";
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                int rest = stmt.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        button3.addActionListener(a->{
            Connection conn = getCnnection();
            String sql = "update item set Preferential_price=price*0.3";
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                int rest = stmt.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        button4.addActionListener(a->{
            Connection conn = getCnnection();
            String sql = "update item set Preferential_price=price*0.4";
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                int rest = stmt.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        button5.addActionListener(a->{
            Connection conn = getCnnection();
            String sql = "update item set Preferential_price=price*0.5";
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                int rest = stmt.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        button6.addActionListener(a->{
            Connection conn = getCnnection();
            String sql = "update item set Preferential_price=price*0.6";
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                int rest = stmt.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        button7.addActionListener(a->{
            Connection conn = getCnnection();
            String sql = "update item set Preferential_price=price*0.7";
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                int rest = stmt.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        button8.addActionListener(a->{
            Connection conn = getCnnection();
            String sql = "update item set Preferential_price=price*0.8";
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                int rest = stmt.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        button9.addActionListener(a->{
            Connection conn = getCnnection();
            String sql = "update item set Preferential_price=price*0.9";
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                int rest = stmt.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        button10.addActionListener(a->{
            Connection conn = getCnnection();
            String sql = "update item set Preferential_price=price";
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                int rest = stmt.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JButton button1;
    private JButton button2;
    private JLabel label5;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton button10;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


}

