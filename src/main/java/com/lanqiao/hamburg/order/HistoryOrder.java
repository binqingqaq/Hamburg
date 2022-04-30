package com.lanqiao.hamburg.order;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/*
 * Created by JFormDesigner on Sat Apr 30 10:49:21 CST 2022
 */



/**
 * @author 1
 */
public class HistoryOrder extends JFrame {
    public HistoryOrder() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label1 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(20, 105, 650, 330);

        //---- label1 ----
        label1.setText("\u5386\u53f2\u8ba2\u5355");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(320, 15), label1.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(20, 50, 175, textField1.getPreferredSize().height);
        contentPane.add(textField2);
        textField2.setBounds(295, 50, 160, textField2.getPreferredSize().height);

        //---- button3 ----
        button3.setText("\u5f53\u524d\u8ba2\u5355");
        button3.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("进入当前订单");
                        NowOrder nowOrder = new NowOrder();
                        nowOrder.setVisible(true);
                    }
                }
        );
        contentPane.add(button3);
        button3.setBounds(new Rectangle(new Point(595, 50), button3.getPreferredSize()));

        //---- button4 ----
        button4.setText("\u6309\u5468\u67e5\u8be2");
        button4.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("按周查询");
                    }
                }
        );
        contentPane.add(button4);
        button4.setBounds(new Rectangle(new Point(205, 50), button4.getPreferredSize()));

        //---- button5 ----
        button5.setText("\u6309\u6708\u67e5\u8be2");
        button5.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("按月查询");
                    }
                }
        );
        contentPane.add(button5);
        button5.setBounds(new Rectangle(new Point(475, 50), button5.getPreferredSize()));

        contentPane.setPreferredSize(new Dimension(690, 500));
        pack();
        setLocationRelativeTo(getOwner());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(false);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        new HistoryOrder();
    }
}
