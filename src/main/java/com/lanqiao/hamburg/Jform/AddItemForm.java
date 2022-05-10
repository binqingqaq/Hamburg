/*
 * Created by JFormDesigner on Fri May 06 13:19:16 CST 2022
 */

package com.lanqiao.hamburg.Jform;

import com.lanqiao.hamburg.FoodManage.FoodManagePanel;
import com.lanqiao.hamburg.Tools.JDBCtil;
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * @author Binqing
 * @类说明 新增商品界面
 * @date 2022/5/7
 */
public class AddItemForm extends JFrame {
    public AddItemForm() {
        initComponents();
    }

    /**
     * @方法说明 商品信息填完后，执行刷新，与数据库交互，添加一条记录
     * @author Binqing
     * @date 2022/5/7 21:57
     * @param
     * @return void
     */

    public void refreshItem(){

        //只要新增界面没有填完信息，就会提示
        if (textField1.getText().equals("")||(textField2.getText().equals("")||textField4.getText().equals("")||textField6.getText().equals("")
                ||textField7.getText().equals("")||textField8.getText().equals(""))){
            JOptionPane.showMessageDialog(null, "请填完信息！");
        }else{
            Connection conn = JDBCtil.getConnection();
            String sql="INSERT INTO item VALUES(null,?,?,?,?,0,0,?,?,?,?)";
            PreparedStatement pstmt= null;
            try {
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,textField2.getText());
                pstmt.setString(2,textField7.getText() );
                pstmt.setString(3,textField1.getText());
                pstmt.setFloat(4,Float.valueOf(textField3.getText()));
                pstmt.setString(5,textField4.getText());
                pstmt.setFloat(6,Float.valueOf( textField5.getText()));
                pstmt.setString(7,textField8.getText());
                pstmt.setString(8,textField6.getText());

                System.out.println(sql);
                pstmt.executeUpdate();

                JOptionPane.showMessageDialog(null, "已保存！");

                this.dispose();
                FoodManagePanel.updateTable(0);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }finally {
                JDBCtil.close(conn,null,pstmt,null);
            }
        }
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        textField3 = new JTextField();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        textField4 = new JTextField();
        label8 = new JLabel();
        textField5 = new JTextField();
        label9 = new JLabel();
        label10 = new JLabel();
        textField6 = new JTextField();
        button1 = new JButton();
        textField7 = new JTextField();
        textField8 = new JTextField();



        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u9910\u54c1\u7f16\u53f7\uff1a");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(90, 25), label1.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(180, 65, 175, textField1.getPreferredSize().height);
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(35, 65), label2.getPreferredSize()));
        contentPane.add(textField2);
        textField2.setBounds(180, 25, 175, textField2.getPreferredSize().height);

        //---- label3 ----
        label3.setText("\u9910\u54c1\u540d\u79f0\uff1a");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(90, 65), label3.getPreferredSize()));
        contentPane.add(textField3);
        textField3.setBounds(180, 145, 175, textField3.getPreferredSize().height);

        //---- label4 ----
        label4.setText("\u9910\u54c1\u7c7b\u522b\uff1a");
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(90, 105), label4.getPreferredSize()));

        //---- label5 ----
        label5.setText("\u9910\u54c1\u4ef7\u683c\uff1a");
        contentPane.add(label5);
        label5.setBounds(new Rectangle(new Point(90, 145), label5.getPreferredSize()));
        contentPane.add(label6);
        label6.setBounds(new Rectangle(new Point(95, 175), label6.getPreferredSize()));

        //---- label7 ----
        label7.setText("\u56fe\u7247\uff1a");
        contentPane.add(label7);
        label7.setBounds(new Rectangle(new Point(90, 225), label7.getPreferredSize()));
        contentPane.add(textField4);
        textField4.setBounds(180, 225, 175, textField4.getPreferredSize().height);

        //---- label8 ----
        label8.setText("\u6210\u672c\uff1a");
        contentPane.add(label8);
        label8.setBounds(new Rectangle(new Point(90, 185), label8.getPreferredSize()));
        contentPane.add(textField5);
        textField5.setBounds(180, 185, 175, textField5.getPreferredSize().height);

        //---- label9 ----
        label9.setText("\u9910\u54c1\u7684\u53e3\u5473\uff1a");
        contentPane.add(label9);
        label9.setBounds(new Rectangle(new Point(90, 265), label9.getPreferredSize()));

        //---- label10 ----
        label10.setText("\u9910\u54c1\u89c4\u683c\uff1a");
        contentPane.add(label10);
        label10.setBounds(new Rectangle(new Point(90, 305), label10.getPreferredSize()));
        contentPane.add(textField6);
        textField6.setBounds(180, 305, 175, textField6.getPreferredSize().height);

        //---- button1 ----
        button1.setText("保存");
        contentPane.add(button1);
        button1.setBounds(160, 360, 145, button1.getPreferredSize().height);
        button1.addActionListener(e->{
            refreshItem();


        });
        contentPane.add(textField7);
        textField7.setBounds(180, 105, 175, textField7.getPreferredSize().height);
        contentPane.add(textField8);
        textField8.setBounds(180, 265, 175, textField8.getPreferredSize().height);

        contentPane.setPreferredSize(new Dimension(500, 420));
        pack();
        setTitle("新增餐品");
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JTextField textField3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JTextField textField4;
    private JLabel label8;
    private JTextField textField5;
    private JLabel label9;
    private JLabel label10;
    private JTextField textField6;
    private JButton button1;
    private JTextField textField7;
    private JTextField textField8;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
