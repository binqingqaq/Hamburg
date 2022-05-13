/*
 * Created by JFormDesigner on Sat Apr 30 15:34:52 CST 2022
 */

package com.lanqiao.hamburg.YKS;

import com.sun.org.apache.xpath.internal.objects.XString;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
/**
 * @author 1
 */
class time{
    public static String startime="2022-05-13 00:00:00";
    public static String endtime="2022-05-14 23:59:59";
}

class price{
    public static float sum_amount=0;               //点单数量
    public static float sum_sales=0;               //点单数量
}

public class profit extends JPanel {
    public profit() {
        initComponents();
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        textArea1 = new JTextArea();
        label2 = new JLabel();
        button1 = new JButton();
        label7 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        label10 = new JLabel();
        label11 = new JLabel();
        label12 = new JLabel();
        label13 = new JLabel();
        label14 = new JLabel();
        textField1 = new JTextField(time.startime);
        textField2 = new JTextField(time.endtime);

        //======== this ========
        setLayout(null);
        add(textArea1);
        textArea1.setBounds(new Rectangle(new Point(435, 270), textArea1.getPreferredSize()));
        add(label2);
        label2.setBounds(new Rectangle(new Point(195, 200), label2.getPreferredSize()));

        //---- button1 ----
        button1.setText("\u67e5\u8be2");
        button1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //System.out.println(getid());

                        String star_time=textField1.getText();
                        String end_time=textField2.getText();
                        time.startime=star_time;
                        time.endtime=end_time;


                        //---- label12 ----
                        label12.setText(getprice());
                        add(label12);
                        label12.setBounds(new Rectangle(new Point(295, 200), label12.getPreferredSize()));


                        //---- label10 ----
                        label10.setText(getsum());
                        add(label10);
                        label10.setBounds(new Rectangle(new Point(295, 140), label10.getPreferredSize()));

                        //---- label11 ----
                        label11.setText(getsales());
                        add(label11);
                        label11.setBounds(new Rectangle(new Point(295, 170), label11.getPreferredSize()));

                        price.sum_sales=0;
                        price.sum_amount=0;

                    }
                }
        );
        add(button1);
        button1.setBounds(new Rectangle(new Point(260, 245), button1.getPreferredSize()));

        //---- label7 ----
        label7.setText("\u603b\u9500\u91cf\u4e3a\uff1a");
        add(label7);
        label7.setBounds(new Rectangle(new Point(215, 140), label7.getPreferredSize()));

        //---- label8 ----
        label8.setText("\u603b\u9500\u552e\u989d\u4e3a\uff1a");
        add(label8);
        label8.setBounds(new Rectangle(new Point(215, 170), label8.getPreferredSize()));

        //---- label9 ----
        label9.setText("\u603b\u5229\u6da6\u4e3a\uff1a");
        add(label9);
        label9.setBounds(new Rectangle(new Point(215, 200), label9.getPreferredSize()));


        //---- label13 ----
        label13.setText("\u5f00\u59cb\u65f6\u95f4");
        add(label13);
        label13.setBounds(new Rectangle(new Point(215, 55), label13.getPreferredSize()));

        //---- label14 ----
        label14.setText("\u7ed3\u675f\u65f6\u95f4");
        add(label14);
        label14.setBounds(new Rectangle(new Point(215, 90), label14.getPreferredSize()));


        add(textField1);
        textField1.setBounds(280, 55, 150, textField1.getPreferredSize().height);
        add(textField2);
        textField2.setBounds(280, 90, 150, textField2.getPreferredSize().height);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < getComponentCount(); i++) {
                Rectangle bounds = getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            setMinimumSize(preferredSize);
            setPreferredSize(preferredSize);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JTextArea textArea1;
    private JLabel label2;
    private JButton button1;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JLabel label11;
    private JLabel label12;
    private JLabel label13;
    private JLabel label14;
    private JTextField textField1;
    private JTextField textField2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static Connection getCnnection(){
        Connection conn = null;
        String name = "root";
        String password = "Binqing31";
        String url = "jdbc:mysql://39.108.193.41:3306/hamburger?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        String sql = "SELECT * FROM user WHERE user_name='" + name + "' AND user_key='" + password + "'";
        System.out.println(sql);
        try {
            conn = DriverManager.getConnection(url,name,password);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return conn;
    }
    public static String getprice(){
        Connection conn = getCnnection();
        String sql = "select * from order_info WHERE order_time >= "+"'"+time.startime +"'"+ " AND order_time <=" +"'"+time.endtime+"'";
        String sql1 = "select * from item";
        float cost_price=0;        //点单菜品成本
        float num=0;            //计数
        float order_price;          //点单价格
        float amount;               //点单数量
        float sum_profit=0;            //总利润
        float item_id;              //点单菜品ID
        String string_sum_profit;
        try {
            PreparedStatement stmt_id = conn.prepareStatement(sql);
            ResultSet res_id = stmt_id.executeQuery();
            while (res_id.next()){
                PreparedStatement stmt_price = conn.prepareStatement(sql1);
                ResultSet res_price = stmt_price.executeQuery();
                item_id=Float.valueOf(res_id.getString(7));//获取ID
                while (res_price.next()){
                    cost_price=Float.valueOf(res_price.getString(9));
                    num++;
                    if(num==item_id){
                        break;
                    }
                }
                num=0;
                amount =Float.valueOf(res_id.getString(9));//获取菜品数量
                order_price=Float.valueOf(res_id.getString(10));//菜品卖出的价格
                price.sum_amount=price.sum_amount+amount;
                price.sum_sales=price.sum_sales+order_price;
                sum_profit=sum_profit+order_price-(amount*cost_price);     //统计利润
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        string_sum_profit=String.format("%.2f",sum_profit);       //保留2位小数
        System.out.println("总利润为："+string_sum_profit);
        return string_sum_profit;
    }

    private static String getsales() {
        String sum_sales;
        sum_sales = String.format("%.2f", price.sum_sales);       //保留2位小数
        System.out.println("总销售额为："+sum_sales);
        return sum_sales;
    }

    private static String getsum(){
        String string_sum_amount;
        string_sum_amount = String.format("%.0f", price.sum_amount);       //保留2位小数
        System.out.println("总销量为："+string_sum_amount);
        return string_sum_amount;
    }

    public static void main(String[] args){
        getprice();
        getsales();
        getsum();
    }
}

