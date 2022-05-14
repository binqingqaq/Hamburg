/*
 * Created by JFormDesigner on Sat Apr 30 16:37:40 CST 2022
 */

package com.lanqiao.hamburg.Discount;

import com.lanqiao.hamburg.MySaleShow.dao.Impl.ShopCarDaoImpl;
import com.lanqiao.hamburg.MySaleShow.dao.ShopCarDao;
import com.lanqiao.hamburg.MySaleShow.entity.ShopCar;
import com.lanqiao.hamburg.MySaleShow.util.ConnectionHandler;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author 1
 */


public class DiscountForm extends JPanel {

    private String head[] = {"ID","FoodID","Price","Num","UserID","UserName","FoodName"};
    private Object[][] data = null;

    public static Connection getCnnection(){
        Connection conn = null;
        String name = "root";
        String password = "Binqing31";
        String url = "jdbc:mysql://39.108.193.41:3306/hamburger?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        String sql = "SELECT * FROM user WHERE user_name='" + name + "' AND user_key='" + password + "'";
        System.out.println(sql);
        try {
            conn = DriverManager.getConnection(url,name,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }

    public static void main(String[] args){
        Connection conn = getCnnection();
        String sql = "select * from item";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet res = stmt.executeQuery();
            while (res.next()){
                System.out.println(res.getFloat("price"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public DiscountForm() {
        try {
            initComponents();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    private void initComponents() throws SQLException {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        button1 = new JButton();
        button2 = new JButton();
        label5 = new JLabel();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        button6 = new JButton();
        button7 = new JButton();
        button8 = new JButton();
        button9 = new JButton();
        button10 = new JButton();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        textField1 = new JTextField();
        label4 = new JLabel();
        textField2 = new JTextField();
        button11 = new JButton();
        button12 = new JButton();

        //======== this ========
        setLayout(null);

        //---- button1 ----
        button1.setText("\u62531\u6298");
        add(button1);
        button1.setBounds(new Rectangle(new Point(490, 120), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("\u62532\u6298");
        add(button2);
        button2.setBounds(new Rectangle(new Point(400, 120), button2.getPreferredSize()));

        //---- label5 ----
        label5.setText("\u6d3b\u52a8\u4f18\u60e0");
        add(label5);
        label5.setBounds(315, 15, 75, 35);

        //---- button3 ----
        button3.setText("\u62533\u6298");
        add(button3);
        button3.setBounds(new Rectangle(new Point(310, 120), button3.getPreferredSize()));

        //---- button4 ----
        button4.setText("\u62534\u6298");
        add(button4);
        button4.setBounds(new Rectangle(new Point(220, 120), button4.getPreferredSize()));

        //---- button5 ----
        button5.setText("\u62535\u6298");
        add(button5);
        button5.setBounds(new Rectangle(new Point(580, 80), button5.getPreferredSize()));

        //---- button6 ----
        button6.setText("\u62536\u6298");
        add(button6);
        button6.setBounds(new Rectangle(new Point(490, 80), button6.getPreferredSize()));

        //---- button7 ----
        button7.setText("\u62537\u6298");
        add(button7);
        button7.setBounds(new Rectangle(new Point(400, 80), button7.getPreferredSize()));

        //---- button8 ----
        button8.setText("\u62538\u6298");
        add(button8);
        button8.setBounds(new Rectangle(new Point(310, 80), button8.getPreferredSize()));

        //---- button9 ----
        button9.setText("\u62539\u6298");
        add(button9);
        button9.setBounds(new Rectangle(new Point(220, 80), button9.getPreferredSize()));

        //---- button10 ----
        button10.setText("\u64a4\u9500\u6253\u6298");
        add(button10);
        button10.setBounds(new Rectangle(new Point(580, 120), button10.getPreferredSize()));

        //---- label1 ----
        label1.setText("\u4e00\u952e\u6253\u6298");
        add(label1);
        label1.setBounds(new Rectangle(new Point(45, 105), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText("\u6307\u5b9a\u5546\u54c1\u6253\u6298");
        add(label2);
        label2.setBounds(new Rectangle(new Point(40, 240), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("\u5546\u54c1ID");
        add(label3);
        label3.setBounds(new Rectangle(new Point(160, 240), label3.getPreferredSize()));

        //---- textField1 ----
        textField1.setAlignmentX(10.0F);
        textField1.setAlignmentY(10.0F);
        textField1.setText("                    ");
        add(textField1);
        textField1.setBounds(new Rectangle(new Point(210, 235), textField1.getPreferredSize()));

        //---- label4 ----
        label4.setText("\u6298\u6263");
        add(label4);
        label4.setBounds(new Rectangle(new Point(300, 240), label4.getPreferredSize()));

        //---- textField2 ----
        textField2.setText("                    ");
        add(textField2);
        textField2.setBounds(new Rectangle(new Point(345, 235), textField2.getPreferredSize()));

        //---- button11 ----
        button11.setText("\u6253\u6298\uff01");
        add(button11);
        button11.setBounds(new Rectangle(new Point(450, 235), button11.getPreferredSize()));

        //---- button12 ----
        button12.setText("\u56de\u5230\u539f\u59cb\u4ef7\u683c");
        add(button12);
        button12.setBounds(new Rectangle(new Point(560, 235), button12.getPreferredSize()));

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
        button1.addActionListener(a->{
            Connection conn = getCnnection();
            String sql = "update item set Preferential_price=price*0.1";
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                int rest = stmt.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        button2.addActionListener(a->{
            Connection conn = getCnnection();
            String sql = "update item set Preferential_price=price*0.2";
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                int rest = stmt.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        button3.addActionListener(a->{
            Connection conn = getCnnection();
            String sql = "update item set Preferential_price=price*0.3";
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                int rest = stmt.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        button4.addActionListener(a->{
            Connection conn = getCnnection();
            String sql = "update item set Preferential_price=price*0.4";
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                int rest = stmt.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        button5.addActionListener(a->{
            Connection conn = getCnnection();
            String sql = "update item set Preferential_price=price*0.5";
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                int rest = stmt.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        button6.addActionListener(a->{
            Connection conn = getCnnection();
            String sql = "update item set Preferential_price=price*0.6";
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                int rest = stmt.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        button7.addActionListener(a->{
            Connection conn = getCnnection();
            String sql = "update item set Preferential_price=price*0.7";
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                int rest = stmt.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        button8.addActionListener(a->{
            Connection conn = getCnnection();
            String sql = "update item set Preferential_price=price*0.8";
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                int rest = stmt.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        button9.addActionListener(a->{
            Connection conn = getCnnection();
            String sql = "update item set Preferential_price=price*0.9";
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                int rest = stmt.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        button10.addActionListener(a->{
            Connection conn = getCnnection();
            String sql = "update item set Preferential_price=price";
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                int rest = stmt.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        button11.addActionListener(a->{
            Connection conn = getCnnection();
            String textField1Val=textField1.getText();
            String textField2Val=textField2.getText();
            String sql = "update item set Preferential_price=price*0."+textField2Val+" where id="+textField1Val;
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                int rest = stmt.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        button12.addActionListener(a->{
            Connection conn = getCnnection();
            String textField1Val=textField1.getText();
            String sql = "update item set Preferential_price=price"+" where id="+textField1Val;
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                int rest = stmt.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }
    public Object[][] getDataFromDatabase(ResultSet rs) throws SQLException {
        java.util.List<ShopCar> list = new ArrayList<ShopCar>();

        try {
            while (rs.next()) {

                ShopCar car = new ShopCar();
                car.setColnum(rs.getInt(1));
                car.setId(rs.getInt(2));
                car.setPrice(rs.getFloat(3));
                car.setNum(rs.getInt(4));
                car.setUser_id(rs.getInt(5));
                car.setUser_name(rs.getString(6));
                car.setTitle(rs.getString(7));
                list.add(car);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                rs.close();
                ConnectionHandler.closeConnection();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        data = new Object[list.size()][head.length];

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < head.length; j++) {
                data[i][0] = list.get(i).getColnum();
                data[i][1] = list.get(i).getId();
                data[i][2] = list.get(i).getPrice();
                data[i][3] = list.get(i).getNum();
                data[i][4] = list.get(i).getUser_id();
                data[i][5] = list.get(i).getUser_name();
                data[i][6] = list.get(i).getTitle();
            }
        }
        return data;
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JButton button1;
    private JButton button2;
    private JLabel label5;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton button10;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textField1;
    private JLabel label4;
    private JTextField textField2;
    private JButton button11;
    private JButton button12;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


}

