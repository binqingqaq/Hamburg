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

    private static Component login;

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

        //---- label4 ----
        label4.setText("\u5bc6   \u7801");
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(130, 135), label4.getPreferredSize()));
        contentPane.add(textField3);
        textField3.setBounds(180, 130, 95, textField3.getPreferredSize().height);

        //---- button1 ----
        button1.setText("\u767b\u5165");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(170, 185), button1.getPreferredSize()));

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
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        login.setVisible(true);
    }


}
