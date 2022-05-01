/*
 * Created by JFormDesigner on Sat Apr 30 15:34:52 CST 2022
 */

package com.lanqiao.hamburg.YKS;

import com.lanqiao.hamburg.Jform.MainForm;

import java.awt.*;
import java.sql.*;
import javax.swing.*;

/**
 * @author 1
 */
public class profit extends JPanel {
    public profit() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label3 = new JLabel();
        comboBox1 = new JComboBox();
        textArea1 = new JTextArea();
        scrollPane1 = new JScrollPane();
        list1 = new JList();
        comboBox2 = new JComboBox();
        label4 = new JLabel();

        //======== this ========
        setLayout(null);

        //---- label3 ----
        label3.setText("\u9009\u62e9\u65e5\u671f");
        add(label3);
        label3.setBounds(new Rectangle(new Point(85, 55), label3.getPreferredSize()));

        //---- comboBox1 ----
        comboBox1.setToolTipText("\u6700\u4f4e\u65e5\u671f");
        add(comboBox1);
        comboBox1.setBounds(new Rectangle(new Point(145, 50), comboBox1.getPreferredSize()));
        add(textArea1);
        textArea1.setBounds(new Rectangle(new Point(435, 270), textArea1.getPreferredSize()));

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(list1);
        }
        add(scrollPane1);
        scrollPane1.setBounds(195, 125, 160, scrollPane1.getPreferredSize().height);

        //---- comboBox2 ----
        comboBox2.setToolTipText("\u6700\u9ad8\u65e5\u671f");
        add(comboBox2);
        comboBox2.setBounds(new Rectangle(new Point(295, 50), comboBox2.getPreferredSize()));

        //---- label4 ----
        label4.setText("----");
        add(label4);
        label4.setBounds(new Rectangle(new Point(255, 55), label4.getPreferredSize()));

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
    private JLabel label3;
    private JComboBox comboBox1;
    private JTextArea textArea1;
    private JScrollPane scrollPane1;
    private JList list1;
    private JComboBox comboBox2;
    private JLabel label4;
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
        } catch (SQLException throwable) {
            throwable.printStackTrace();
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
                System.out.println(res.getFloat(3));
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
}
