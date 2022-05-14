package com.lanqiao.hamburg.order;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

import static java.lang.String.valueOf;
/*
 * Created by JFormDesigner on Mon May 02 20:35:41 CST 2022
 */



/**
 * @author 1
 */
public class InsertOrder extends JFrame {
    order_info order;
    public InsertOrder(order_info order) {
        this.order = order;
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        textField3 = new JTextField();
        label4 = new JLabel();
        textField4 = new JTextField();
        label5 = new JLabel();
        textField5 = new JTextField();
        label6 = new JLabel();
        textField6 = new JTextField();
        button1 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u5546\u54c1ID:");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(20, 30), label1.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(70, 30, 130, textField1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("订单ID");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(230, 30), label2.getPreferredSize()));
        contentPane.add(textField2);
        textField2.setBounds(310, 30, 130, textField2.getPreferredSize().height);

        //---- label3 ----
        label3.setText("\u5355\u4ef7\uff1a");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(20, 70), label3.getPreferredSize()));
        contentPane.add(textField3);
        textField3.setBounds(70, 70, 130, textField3.getPreferredSize().height);

        //---- label4 ----
        label4.setText("\u6570\u91cf\uff1a");
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(230, 70), label4.getPreferredSize()));
        contentPane.add(textField4);
        textField4.setBounds(310, 70, 130, textField4.getPreferredSize().height);

        //---- label5 ----
        label5.setText("\u603b\u4ef7\uff1a");
        contentPane.add(label5);
        label5.setBounds(new Rectangle(new Point(20, 110), label5.getPreferredSize()));
        contentPane.add(textField5);
        textField5.setBounds(70, 110, 130, textField5.getPreferredSize().height);

        //---- label6 ----
        label6.setText("\u8ba2\u5355\u65f6\u95f4\uff1a");
        contentPane.add(label6);
        label6.setBounds(new Rectangle(new Point(230, 110), label6.getPreferredSize()));
        contentPane.add(textField6);
        textField6.setBounds(310, 110, 130, textField6.getPreferredSize().height);

        //---- button1 ----
        button1.setText("\u4fdd\u5b58");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(195, 220), button1.getPreferredSize()));
        button1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String sql = "SELECT * FROM order_info";
                        Connection conn = null;
                        String user = "root";
                        String dbPassword = "Binqing31";
                        String url = "jdbc:mysql://39.108.193.41:3306/hamburger?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
                        Statement stmt = null;
                        ResultSet rs = null;
                        try {
                            conn = DriverManager.getConnection(url, user, dbPassword);
                            stmt = conn.createStatement();
                            rs = stmt.executeQuery(sql);
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        String sql2 = "insert into order_info Values('" + textField2.getText() + "',0,'1','" +
                                textField6.getText() + "','0',0," +
                                textField1.getText() + "," + textField3.getText() + "," +
                                textField4.getText() + "," + textField5.getText() + ")";
                        System.out.println(sql2);
                        try {
                            conn = DriverManager.getConnection(url, user, dbPassword);
                            stmt = conn.createStatement();
                            stmt.execute(sql2);
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        setVisible(false);
                    }
                }
        );

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
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
        pack();
        setLocationRelativeTo(getOwner());

        this.setVisible(true);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JTextField textField3;
    private JLabel label4;
    private JTextField textField4;
    private JLabel label5;
    private JTextField textField5;
    private JLabel label6;
    private JTextField textField6;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
