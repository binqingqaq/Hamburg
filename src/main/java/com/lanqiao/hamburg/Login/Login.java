package com.lanqiao.hamburg.Login;

import com.lanqiao.hamburg.Jform.MainForm;
import com.lanqiao.hamburg.MySaleShow.dao.CurrentUserDao;
import com.lanqiao.hamburg.MySaleShow.dao.Impl.CurrentUserDaoImpl;
import com.lanqiao.hamburg.MySaleShow.entity.user;
import com.lanqiao.hamburg.MySaleShow.service.Impl.LoginServiceImpl;
import com.lanqiao.hamburg.MySaleShow.service.LoginService;

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
        textField1 = new JTextField("tongxin");
        label2 = new JLabel();
        textField2 = new JTextField("123456");
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();

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
                            JOptionPane.showMessageDialog(this,"恭喜"+username+"成功登录","提示",JOptionPane.PLAIN_MESSAGE);
                            new MainForm().setVisible(true);
                            this.setVisible(false);
                        }else {
                            JOptionPane.showMessageDialog(this,"用户名错误或密码错误","警告",2);
                        }

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                }
        );
        button1.setText("\u767b\u5f55");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(90, 185), button1.getPreferredSize()));

        //---- 注册-----
        button2.setText("注册");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(170,185),button2.getPreferredSize()));
        button2.addActionListener(a->{
            JOptionPane.showMessageDialog(this,"联系管理员DavidNan:2926594808@qq.com","温馨提示",2);
        });

        //--- 忘记密码----
        button3.setText("忘记密码");
        contentPane.add(button3);
        button3.setBounds(new Rectangle(new Point(260,185),button3.getPreferredSize()));
        button3.addActionListener(a->{
            JOptionPane.showMessageDialog(this,"联系管理员DavidNan:2926594808@qq.com","温馨提示",2);
        });

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
    private JButton button2; //注册
    private JButton button3; //忘记密码

    public static void main(String[] args) {
        new Login();
    }
    
}
