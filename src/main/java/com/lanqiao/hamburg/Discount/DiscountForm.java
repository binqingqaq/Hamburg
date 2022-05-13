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
    public DiscountForm() {
        initComponents();
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label1 = new JLabel();
        scrollPane2 = new JScrollPane();
        textArea1 = new JTextArea();
        comboBox1 = new JComboBox();
        label2 = new JLabel();
        label3 = new JLabel();
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();

        //======== this ========
        setLayout(null);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        add(scrollPane1);
        scrollPane1.setBounds(0, 0, 815, 225);

        //---- label1 ----
        label1.setText("\u6253\u6298");
        add(label1);
        label1.setBounds(new Rectangle(new Point(25, 290), label1.getPreferredSize()));

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(textArea1);
        }
        add(scrollPane2);
        scrollPane2.setBounds(100, 290, 80, scrollPane2.getPreferredSize().height);
        add(comboBox1);
        comboBox1.setBounds(new Rectangle(new Point(100, 235), comboBox1.getPreferredSize()));

        //---- label2 ----
        label2.setText("\u5546\u54c1");
        add(label2);
        label2.setBounds(new Rectangle(new Point(25, 240), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("\u6bcf\u5355\u9650\u8d2d");
        add(label3);
        label3.setBounds(15, 340, label3.getPreferredSize().width, 15);

        //---- radioButton1 ----
        radioButton1.setText("1\u4efd");
        add(radioButton1);
        radioButton1.setBounds(new Rectangle(new Point(95, 335), radioButton1.getPreferredSize()));

        //---- radioButton2 ----
        radioButton2.setText("\u65e0\u9650");
        add(radioButton2);
        radioButton2.setBounds(new Rectangle(new Point(140, 335), radioButton2.getPreferredSize()));

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

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label1;
    private JScrollPane scrollPane2;
    private JTextArea textArea1;
    private JComboBox comboBox1;
    private JLabel label2;
    private JLabel label3;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
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

}

