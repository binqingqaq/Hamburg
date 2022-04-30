package com.lanqiao.hamburg.order;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/*
 * Created by JFormDesigner on Sat Apr 30 10:14:47 CST 2022
 */



/**
 * @author 1
 */
public class NowOrder extends JFrame {
    public NowOrder() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label1 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(10, 45, 535, 380);

        //---- label1 ----
        label1.setText("\u5f53\u524d\u8ba2\u5355");
        contentPane.add(label1);
        label1.setBounds(320, 5, 55, 35);

        //---- button1 ----
        button1.setText("\u786e\u8ba4\u6536\u8d27");
        button1.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("确认收货");
                    }
                }
        );
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(570, 50), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("\u5386\u53f2\u8ba2\u5355");
        button2.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("进入历史订单");
                    }
                }
        );
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(570, 110), button2.getPreferredSize()));

        contentPane.setPreferredSize(new Dimension(690, 500));
        pack();
        setLocationRelativeTo(getOwner());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label1;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        new NowOrder();
    }
}





