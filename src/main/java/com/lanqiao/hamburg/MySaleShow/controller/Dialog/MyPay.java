/*
 * Created by JFormDesigner on Wed May 04 01:04:14 CST 2022
 */

package com.lanqiao.hamburg.MySaleShow.controller.Dialog;


import com.lanqiao.hamburg.MySaleShow.entity.ShopCar;


import javax.swing.*;
import java.awt.*;

/**
 * @author DavidNan
 */
public class MyPay extends JDialog {
    ShopCar car;
    public MyPay(ShopCar car) {
        super();
        this.car = car;
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();

        //======== this ========
        setTitle("Pay");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u7528\u6237:");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(30, 25), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText(car.getUser_name());
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(100, 25), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("��֧��:");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(30, 60), label3.getPreferredSize()));

        //---- label4 ----
        label4.setText(String.valueOf(car.getPrice()));
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(100, 60), label4.getPreferredSize()));

        //---- label5 ----
        label5.setText("\u4f1a\u5458\u53f7/8\u6298:");
        contentPane.add(label5);
        label5.setBounds(30, 95, label5.getPreferredSize().width, 17);
        contentPane.add(textField1);
        textField1.setBounds(100, 90, 160, textField1.getPreferredSize().height);

        //---- button1 ----
        button1.setText("\u5fae\u4fe1\u652f\u4ed8");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(110, 145), button1.getPreferredSize()));
        button1.addActionListener(a->{
            //��ʾ΢��֧��ͼƬ
            try {
                //new WXPay().UsePay();
                ImageIcon imageIcon  = new ImageIcon("src/main/java/ImageDemo/new.jpg");
                imageIcon.setImage(imageIcon.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT));
                JLabel Ma = new JLabel(imageIcon);
                this.add(Ma);
                Ma.setBounds(new Rectangle(new Point(150,220),Ma.getPreferredSize()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

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
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JTextField textField1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
