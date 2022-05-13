package com.lanqiao.hamburg.Login;

import com.lanqiao.hamburg.Jform.MainForm;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Sat Apr 30 14:48:59 CST 2022
 */



/**
 * @author 1
 */
public class Login extends JFrame {

    public Login() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        textField2 = new JTextField();
        label4 = new JLabel();
        textField3 = new JTextField();
        button1 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u5929\u5929\u534e\u83b1\u58eb");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(165, 35), label1.getPreferredSize()));
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(150, 75), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("\u7528\u6237\u540d");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(130, 85), label3.getPreferredSize()));
        contentPane.add(textField2);
        textField2.setBounds(180, 80, 95, textField2.getPreferredSize().height);
        textField2.setText("tongxin");
        //---- label4 ----
        label4.setText("\u5bc6   \u7801");
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(130, 135), label4.getPreferredSize()));
        contentPane.add(textField3);
        textField3.setBounds(180, 130, 95, textField3.getPreferredSize().height);
        textField3.setText("123456");
        //---- button1 ----
        button1.setText("\u767b\u5165");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(170, 185), button1.getPreferredSize()));
        button1.addActionListener(
                (e)->{
/*
                    实现登录
                    1、先拿到登录界面的用户名和密码
                    2、去数据库比对用户名和密码
                    就是去执行一条SQL语句，但是是什么样的SQL语句呢？
                     */
                    String username = textField2.getText();
                    String password = textField3.getText();

                    String sql = "SELECT * FROM user WHERE user_name='" + username + "' AND user_key='" + password + "'";
                    System.out.println(sql);

                    /*
                    1、连接数据库（添加mysql的maven依赖）
                    2、执行SQL语句，验证用户名和密码
                     */
                    Connection conn = null;
                    String user = "root";
                    String dbPassword = "Binqing31";
                    String url = "jdbc:mysql://39.108.193.41:3306/hamburger?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";

                    Statement statement = null;//语句对象
                    ResultSet rs = null;//结果集：游标（虚拟的指针）

                    try {
                        conn = DriverManager.getConnection(url, user, dbPassword);
                        System.out.println(conn);

                        statement = conn.createStatement();
                        rs = statement.executeQuery(sql);//刚刚执行完查询的时候，游标不指向任何记录

                        // 如何判断用户名和密码是否正确？
                        if (rs.next()) {
                            //登入成功打开主界面
                            System.out.println("登录成功");
                            new MainForm().setVisible(true);
                            login.setVisible(false);
                        } else {
                            System.out.println("用户名或密码错误");
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
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
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        setBounds(750, 350, 400, 300);

        setResizable(false);

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textField2;
    private JLabel label4;
    private JTextField textField3;
    private JButton button1;
    static Login login=new Login();
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        login.setVisible(true);
    }


}
