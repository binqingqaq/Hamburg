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
 * @author DavidNan
 */
public class MyLogin extends JFrame {
    public MyLogin() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        textField1 = new JTextField("DavidNan");
        label2 = new JLabel();
        //textField2 = new JTextField("666");
        JPasswordField textField2 = new JPasswordField("666");
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        this.setTitle("Login");
        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //--- 头像 ----
        ImageIcon imageIcon  = new ImageIcon("DavidNan.jpg");
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(80,80,Image.SCALE_DEFAULT));
        JLabel Ma = new JLabel(imageIcon);
        contentPane.add(Ma);
        Ma.setBounds(new Rectangle(new Point(155,20),Ma.getPreferredSize()));

        //---- label1 ----
        label1.setText("\u7528\u6237\u540d\uff1a");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(90, 120), label1.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(150, 115, 100, textField1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("\u5bc6\u7801\uff1a");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(90, 155), label2.getPreferredSize()));
        contentPane.add(textField2);
        textField2.setBounds(150, 150, 100, textField2.getPreferredSize().height);

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
                            cud.DelLoginData();
                        }
                        if(loginService.LoginAndRecord(user)==1){
                            JOptionPane.showMessageDialog(this,"登录成功,请稍等！","提示",JOptionPane.PLAIN_MESSAGE);
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
        button1.setBounds(new Rectangle(new Point(130, 185), button1.getPreferredSize()));

        button2.setText("注册");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(200,185),button2.getPreferredSize()));
        button2.addActionListener(a->{
            JOptionPane.showMessageDialog(this,"请联系DavidNan","提示",JOptionPane.PLAIN_MESSAGE);
        });
        button3.setText("忘记密码");
        button3.setBounds(new Rectangle(new Point(130,220),button3.getPreferredSize()));
        contentPane.add(button3);
        button3.addActionListener(a->{
            JOptionPane.showMessageDialog(this,"请联系DavidNan","提示",JOptionPane.PLAIN_MESSAGE);
        });

        contentPane.setPreferredSize(new Dimension(400, 330));
        pack();
        setLocationRelativeTo(getOwner());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    //private JTextField textField2;
    private JButton button1;
    private JButton button2;
    private JButton button3;

    public static void main(String[] args) {
        new MyLogin();
    }
}
