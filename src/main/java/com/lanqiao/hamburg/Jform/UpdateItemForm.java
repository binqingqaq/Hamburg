package com.lanqiao.hamburg.Jform;

import com.lanqiao.hamburg.FoodManage.FoodManagePanel;
import com.lanqiao.hamburg.FoodManage.impl.DishesManageImpl;
import com.lanqiao.hamburg.Tools.JDBCtil;
import com.lanqiao.hamburg.entity.Item;


import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * @author Binqing
 * @类说明 修改餐品界面
 * @date 2022/5/7
 */
public class UpdateItemForm extends JFrame {
    Item item;

    public UpdateItemForm(Item item)  {
        this.item = item;
        initComponents();
    }


    /**
     * @方法说明 保存修改后的商品信息，与数据库交互
     * @author Binqing
     * @date 2022/5/7 20:34
     * @param
     * @return void
     */
    public void Savemodify() {
        Connection conn = JDBCtil.getConnection();
        String sql = "UPDATE item SET product_name =? , product_category = ? , price = ? , img_url = ?, Preferential_price =? , product_id =?  WHERE id="+item.getId();
        PreparedStatement pstmt= null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,textField2.getText());
            pstmt.setString(2,textField1.getText());
            pstmt.setFloat(3,Float.valueOf(textField3.getText()) );
            pstmt.setString(4,textField4.getText());
            pstmt.setFloat(5,Float.valueOf(textField6.getText()));
            pstmt.setString(6,textField5.getText());

            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "已保存！");
            this.dispose();//调用方法关闭当前窗口


            FoodManagePanel.updateTable(0);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally {
            JDBCtil.close(conn,null,pstmt,null);
        }

    }
    private void initComponents() {
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        textField3 = new JTextField();
        label4 = new JLabel();
        textField4 = new JTextField();
        label5 = new JLabel();
        textField5 = new JTextField();
        label6 = new JLabel();
        textField6 = new JTextField();
        button1 = new JButton();

        //======== this ========
        JPanel contentPane = (JPanel) getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("餐品总类");
        contentPane.add(label1);
        label1.setBounds(20, 20, 55, 20);
        contentPane.add(textField1);
        textField1.setBounds(70, 20, 130, 30);
        textField1.setText(item.getPro_cate());

        //---- label2 ----
        label2.setText("餐品名称");
        contentPane.add(label2);
        label2.setBounds(240, 20, 90, 20);
        contentPane.add(textField2);
        textField2.setBounds(300, 20, 130, 30);
        textField2.setText(item.getPro_name());

        //---- label3 ----
        label3.setText("价格");
        contentPane.add(label3);
        label3.setBounds(20, 80, 55, 20);
        contentPane.add(textField3);
        textField3.setBounds(70, 80, 130, 30);
        textField3.setText(String.valueOf(item.getPrice()));

        //---- label4 ----
        label4.setText("图片");
        contentPane.add(label4);
        label4.setBounds(240, 80, 90, 20);
        contentPane.add(textField4);
        textField4.setBounds(300, 80, 130, 30);
        textField4.setText(item.getImg_url());

        //---- label5 ----
        label5.setText("餐品编号");
        contentPane.add(label5);
        label5.setBounds(20, 140, 55, 20);
        contentPane.add(textField5);
        textField5.setBounds(70, 140, 130, 30);
        textField5.setText(String.valueOf(item.getProduct_id()));

        //---- label6 ----
        label6.setText("优惠价");
        contentPane.add(label6);
        label6.setBounds(240, 140, 90, 20);
        contentPane.add(textField6);
        textField6.setBounds(300, 140, 130, 30);
        textField6.setText(String.valueOf( item.getPrefer_price()));

        //---- button1 ----
        button1.setText("保存");
        contentPane.add(button1);
        button1.setBounds(200, 300, 100, 30);
        button1.addActionListener((e)->Savemodify());
        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for (int i = 0; i < contentPane.getComponentCount(); i++) {
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
        //pack();
        setTitle("餐品信息修改");
        setLocationRelativeTo(null);
        this.setBounds(600, 300, 480, 400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }



    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JTextField textField3;
    private JLabel label4;
    private JTextField textField4;
    private JLabel label5;
    private JTextField textField5;
    private JLabel label6;
    private JTextField textField6;
    private JButton button1;
}
