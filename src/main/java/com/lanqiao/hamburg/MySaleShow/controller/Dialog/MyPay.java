/*
 * Created by JFormDesigner on Wed May 04 01:04:14 CST 2022
 */

package com.lanqiao.hamburg.MySaleShow.controller.Dialog;


import cn.juntai.wxpaydemo.pay.WXPay;
import com.lanqiao.hamburg.MySaleShow.entity.ShopCar;
import com.lanqiao.hamburg.MySaleShow.service.Impl.ShopCarServiceImpl;
import com.lanqiao.hamburg.MySaleShow.service.ShopCarService;


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
        button2 = new JButton("OK");  // Send the scanner to get the code segment
        label6 = new JLabel();
        textField2 = new JTextField();

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
        label3.setText("Amount:");
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

        //-----Scanner----
        label6.setText("Scanner:");
        contentPane.add(label6);
        label6.setBounds(30,130,label6.getPreferredSize().width,17);
        contentPane.add(textField2);
        textField2.setBounds(100,130,160,textField2.getPreferredSize().height);
        contentPane.add(button2);
        button2.setBounds(270,130,60,25);
        button2.addActionListener(a->{
            //JOptionPane.showMessageDialog(this,"条形码方式正在建设中！","提示",2);
            ShopCarService scr = new ShopCarServiceImpl();
            scr.Preorder();  // 实现实时添加临时库存item_stock，提供给服务器端在收到支付成功后自动减少库存，并删除购物车数据
            try {
                //实现一维码支付
                new WXPay().OneCodePay(textField2.getText(), (int) car.getPrice());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        //---- button1 ----
        button1.setText("\u5fae\u4fe1\u652f\u4ed8");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(110, 180), button1.getPreferredSize()));
        button1.addActionListener(a->{
            try {
                //确认下单后，将购物车对应的商品ID和库存存入到item_stock中，判断如果里面已经有了ID就不用存入了
                //便于下次确定支付时直接处理库存。
                ShopCarService scr = new ShopCarServiceImpl();
                scr.Preorder();  // 实现实时添加临时库存item_stock，提供给服务器端在收到支付成功后自动减少库存，并删除购物车数据
                //new WXPay().UsePay((int) car.getPrice()); //真用的时候取消注释--版本V1.8的的时候，现在忽略它哦
                new WXPay().TwoCodePay((int) car.getPrice());  //正式版二维码支付环节
                ImageIcon imageIcon  = new ImageIcon("pay.jpg");
                imageIcon.setImage(imageIcon.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT));
                JLabel Ma = new JLabel(imageIcon);
                this.add(Ma);
                Ma.setBounds(new Rectangle(new Point(120,240),Ma.getPreferredSize()));
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
    private JLabel label6;
    private JTextField textField2; //Scanner dedicated text field
    private JTextField textField1;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
