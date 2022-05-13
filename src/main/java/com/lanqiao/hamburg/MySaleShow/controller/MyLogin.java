package com.lanqiao.hamburg.MySaleShow.controller;

import com.lanqiao.hamburg.Jform.MainForm;
import com.lanqiao.hamburg.MySaleShow.dao.CurrentUserDao;
import com.lanqiao.hamburg.MySaleShow.dao.Impl.CurrentUserDaoImpl;
import com.lanqiao.hamburg.MySaleShow.entity.user;
import com.lanqiao.hamburg.MySaleShow.service.Impl.LoginServiceImpl;
import com.lanqiao.hamburg.MySaleShow.service.LoginService;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
/*
 * Created by JFormDesigner on Sat Apr 02 15:41:52 CST 2022
 */


/**
 * @description: 登录窗体
 * @author: DavidNan
 * @date: 2022/5/13 21:20
 */

public class MyLogin extends JFrame {
    public MyLogin() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        textField1 = new JTextField("tongxin");
        label2 = new JLabel();
        textField2 = new JTextField("123456");
        button1 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u7528\u6237\u540d\uff1a");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(115, 90), label1.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(185, 85, 100, textField1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("\u5bc6\u7801\uff1a");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(120, 125), label2.getPreferredSize()));
        contentPane.add(textField2);
        textField2.setBounds(185, 120, 100, textField2.getPreferredSize().height);

        //---- button1 ----
        button1.addActionListener(
                (e) -> {
                    String username = textField1.getText();
                    String password = textField2.getText();
                    LoginService loginService = new LoginServiceImpl();
                    try {
                        user user = new user();
                        user.setUser_name(username);
                        user.setUser_key(password);
                        CurrentUserDao cud = new CurrentUserDaoImpl();
                        if((cud.QueryUser().getUser_name())!=null){
                            cud.DelLoginData();  //删除之前登录用户的数据，操作的是CurrentUser表
                        }
                        if(loginService.LoginAndRecord(user)==1){
                            JOptionPane.showMessageDialog(this,"登录成功","提示",JOptionPane.PLAIN_MESSAGE);
                            new MainForm().setVisible(true);
                            this.setVisible(false);
                        }else{
                            JOptionPane.showMessageDialog(this,"用户名或密码错误！","错误 ",0);
                        }

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                }
        );
        button1.setText("\u767b\u5f55");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(170, 185), button1.getPreferredSize()));
        contentPane.setPreferredSize(new Dimension(400, 300));
        pack();
        setLocationRelativeTo(getOwner());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JButton button1;

    // ---- 测试窗体 -------
    public static void main(String[] args) {
        new MyLogin();
    }
}
