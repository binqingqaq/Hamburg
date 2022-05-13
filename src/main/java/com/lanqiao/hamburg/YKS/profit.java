/*
 * Created by JFormDesigner on Sat Apr 30 15:34:52 CST 2022
 */

package com.lanqiao.hamburg.YKS;

import com.sun.org.apache.xpath.internal.objects.XString;

import java.awt.*;
import java.sql.*;
import javax.swing.*;

/**
 * @author 1
 */
public class profit extends JPanel {
    public profit() {
        initComponents();
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        textArea1 = new JTextArea();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();

        //======== this ========
        setLayout(null);
        add(textArea1);
        textArea1.setBounds(new Rectangle(new Point(435, 270), textArea1.getPreferredSize()));

        //---- label1 ----
        label1.setText("\u603b\u5229\u6da6\u4e3a\uff1a");
        add(label1);
        label1.setBounds(new Rectangle(new Point(230, 200), label1.getPreferredSize()));
        add(label2);
        label2.setBounds(new Rectangle(new Point(195, 200), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText(getid());
        add(label3);
        label3.setBounds(new Rectangle(new Point(300, 200), label3.getPreferredSize()));

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
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
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
    private static float getprice(float item_id){
        float cost_price=0;
        float num=0;
        Connection conn = getCnnection();
        String sql = "select * from item";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet res = stmt.executeQuery();
            while (res.next()){
                cost_price=Float.valueOf(res.getString(9));
                num++;
                if(num==item_id){
                    return cost_price;
                }
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return cost_price;
    }
    private static String getid(){
        Connection conn = getCnnection();
        String sql = "select * from order_info";
        float order_price;          //点单价格
        float amount;               //点单数量
        float sum_profit=0;            //总利润
        float cost_price;           //点单菜品成本
        float item_id;              //点单菜品ID
        String sum_profit1;
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet res = stmt.executeQuery();
            while (res.next()){
                item_id=Float.valueOf(res.getString(7));//获取ID
                cost_price=getprice(item_id);      //获取成本
                amount =Float.valueOf(res.getString(9));//获取菜品数量
                order_price=Float.valueOf(res.getString(10));//菜品卖出的价格
                sum_profit=sum_profit+(amount*order_price)-(amount*cost_price);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        sum_profit1=String.valueOf(sum_profit);
        System.out.println(sum_profit1);
        return sum_profit1;
    }
    public static void main(String[] args){
        getid();
    }
}
