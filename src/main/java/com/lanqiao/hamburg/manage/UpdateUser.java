package com.lanqiao.hamburg.manage;

import com.lanqiao.hamburg.Jform.MainForm;
import com.lanqiao.hamburg.entity.User;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

/**
 * @Author Administrator
 * @Date
 * @Version
 */
public class UpdateUser extends JFrame {
    User user;
    int way;
    Manage manage;
    public UpdateUser(User user,int way,Manage manage) {
        this.user = user;
        this.way=way;
        this.manage=manage;
        initComponents();
    }
    private void initComponents() {
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        textField3 = new JTextField();
        label4 = new JLabel();
        textField4 = new JTextField();
        button1 = new JButton();

        //======== this ========
        JPanel contentPane = (JPanel) getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("用户ID");
        contentPane.add(label1);
        label1.setBounds(20, 20, 55, 20);
        contentPane.add(textField1);
        textField1.setBounds(70, 20, 130, 20);
        textField1.setText(String.valueOf(user.getUser_id()));

        //---- label2 ----
        label2.setText("用户名");
        contentPane.add(label2);
        label2.setBounds(240, 20, 90, 20);
        contentPane.add(textField2);
        textField2.setBounds(300, 20, 130, 20);
        textField2.setText(user.getUser_name());

        //---- label3 ----
        label3.setText("账号密码");
        contentPane.add(label3);
        label3.setBounds(20, 80, 55, 20);
        contentPane.add(textField3);
        textField3.setBounds(70, 80, 130, 20);
        textField3.setText(user.getUser_key());

        //---- label4 ----
        label4.setText("用户权限");
        contentPane.add(label4);
        label4.setBounds(240, 80, 90, 20);
        contentPane.add(textField4);
        textField4.setBounds(300, 80, 130, 20);
        textField4.setText(String.valueOf(user.getUser_power()));


        //---- button1 ----
        button1.setText("保存");
        contentPane.add(button1);
        button1.setBounds(200, 300, 100, 30);
        button1.addActionListener(
                (e)-> {
                    if (way == 1){
                        System.out.println("准备保存");
                    Connection conn = null;
                    String dbuser = "root";
                    String dbPassword = "Binqing31";
                    String url = "jdbc:mysql://39.108.193.41:3306/hamburger?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
                    PreparedStatement stmt = null;
                    String sql = "UPDATE user SET user_name = ?, user_key = ?,user_power=? WHERE user_id =" + textField1.getText();
                    try {
                        conn = DriverManager.getConnection(url, dbuser, dbPassword);
                        stmt = conn.prepareStatement(sql);
                        stmt.setString(1, textField2.getText());
                        stmt.setString(2, textField3.getText());
                        stmt.setString(3, textField4.getText());
                        stmt.executeUpdate();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    } finally {
                        try {

                            stmt.close();
                            conn.close();
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }

                    }

                    setVisible(false);
                    manage.refresh();
                    }
                    else
                    {
                        System.out.println("添加中...");
                        Connection conn = null;
                        String dbuser = "root";
                        String dbPassword = "Binqing31";
                        String url = "jdbc:mysql://39.108.193.41:3306/hamburger?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
                        PreparedStatement stmt = null;
                        String sql = "INSERT into user VALUES(?,?,?,?)";
                        try {
                            conn = DriverManager.getConnection(url, dbuser, dbPassword);
                            stmt = conn.prepareStatement(sql);
                            stmt.setInt(1, Integer.parseInt(textField1.getText()));
                            stmt.setString(2, textField2.getText());
                            stmt.setString(3, textField3.getText());
                            stmt.setInt(4, Integer.parseInt(textField4.getText()));
                            stmt.executeUpdate();
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        } finally {
                            try {

                                stmt.close();
                                conn.close();
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }

                        }
                        setVisible(false);

                        manage.refresh();
                    }
                }
        );

        {
            // compute preferred size
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
        pack();
        setLocationRelativeTo(getOwner());
        this.setBounds(600, 300, 480, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JTextField textField3;
    private JLabel label4;
    private JTextField textField4;
    private JButton button1;
}
