package com.lanqiao.hamburg.MySaleShow.controller;

import com.lanqiao.hamburg.MySaleShow.controller.Frame.MainForm;
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
 * @author 1
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
        var contentPane = getContentPane();
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
                        user.setUser_key(password);   // 更新临时user表
                        //删除先前用户--多用户登录时可能会出问题，主要是数据表会自动提交时出现，算了出bug再说
                        CurrentUserDao cud = new CurrentUserDaoImpl();
                        if((cud.QueryUser().getUser_name())!=null){
                            //如果当前用户表内存在数据，则删除所有
                            cud.DelLoginData();
                        }
                        if(loginService.LoginAndRecord(user)==1){ // 启动登录与记录服务)
                            new MainForm().setVisible(true);
                            this.setVisible(false);
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
        this.setVisible(true);//设置组件可见
    }

    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JButton button1;

    public static void main(String[] args) {
        new MyLogin();
    }
}
