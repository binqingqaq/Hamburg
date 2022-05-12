/*
 * Created by JFormDesigner on Tue May 03 14:08:50 CST 2022
 */

package com.lanqiao.hamburg.MySaleShow.controller.Dialog;

import com.lanqiao.hamburg.MySaleShow.dao.Impl.ItemDaoImpl;
import com.lanqiao.hamburg.MySaleShow.dao.Impl.ShopCarDaoImpl;
import com.lanqiao.hamburg.MySaleShow.dao.ItemDao;
import com.lanqiao.hamburg.MySaleShow.dao.ShopCarDao;
import com.lanqiao.hamburg.MySaleShow.entity.ShopCar;
import com.lanqiao.hamburg.MySaleShow.service.Impl.ShopCarServiceImpl;
import com.lanqiao.hamburg.MySaleShow.service.ShopCarService;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author qin
 */
public class ShopCarD extends JDialog {
    static Object k;
    String img="";
    ShopCar shopCar;
    public ShopCarD(ShopCar shopCar,String img) {
        this.shopCar=shopCar;
        this.img=img;
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        this.setTitle("ModCar");
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        label4 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        textField4 = new JTextField();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("FoodID:");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(20, 30), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText("FoodName:");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(20, 65), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("Total:");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(20, 95), label3.getPreferredSize()));

        //--- button2---
        button2.setText("Cancel");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(190, 175), button2.getPreferredSize()));
        button2.addActionListener(a->{
            this.setVisible(false);
        });

        ImageIcon image= new ImageIcon(img);
        image.setImage(image.getImage().getScaledInstance(130,100,Image.SCALE_DEFAULT));
        JLabel FoodJL = new JLabel(image);
        this.add(FoodJL);
        FoodJL.setBounds(new Rectangle(new Point(250, 30), FoodJL.getPreferredSize()));

     /*   //插入前需要，保证主键的唯一性又要保证商品ID的唯一性，这个时候就会涉及到
        //插入前判断购物车表是否含有该数据单元的信息，若有则启动更新程序，若无则直接插入
        ShopCarDao shopCarDao = new ShopCarDaoImpl();
        if(shopCarDao.SelectID(shopCar.getId())){ //返回true则添加
            System.out.println("购物车里有了"); //直接添加
        }else{

        }*/

        //---- button1 ----
        button1.setText("OK");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(120, 175), button1.getPreferredSize()));
        button1.addActionListener(a->{

            ShopCarService shopCarService = new ShopCarServiceImpl();
            //库存不够提醒，库存等于或低于添加才放行加入购物
            ItemDao itemDao = new ItemDaoImpl();
            int stock=itemDao.SelectSock(textField2.getText());
            try {
                if(stock>=Integer.parseInt(textField3.getText())){
                    shopCarService.JoinCarService(shopCar,Integer.parseInt(textField3.getText()));
                }else{
                    JOptionPane.showMessageDialog(this,"你胃口真大!","警告",2);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            this.setVisible(false);
        });
        //---- label4 ----
        label4.setText("Price:");
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(20, 120), label4.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(110, 25, 110, textField1.getPreferredSize().height);
        contentPane.add(textField2);
        textField1.setText(String.valueOf(shopCar.getId()));
        textField2.setBounds(110, 60, 110, textField2.getPreferredSize().height);
        textField2.setText(shopCar.getTitle());
        contentPane.add(textField3);
        textField3.setBounds(110, 95, 110, textField3.getPreferredSize().height);
        contentPane.add(textField4);
        textField3.setText(String.valueOf(shopCar.getNum()));
        textField4.setBounds(110, 130, 110, textField4.getPreferredSize().height);
        textField4.setText(String.valueOf(shopCar.getPrice()));
        contentPane.setPreferredSize(new Dimension(400, 300));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JButton button1;
    private JButton button2;
    private JLabel label4;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    Connection conn=null;
    int id=0;
    String name="";
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Container container = frame.getContentPane();
        JButton jButton = new JButton();
        jButton.setBounds(10,10,100,20);
        jButton.addActionListener(a->
        {
            new ShopCarD(new ShopCar(),"").setVisible(true);
        });
        container.add(jButton);
        frame.setTitle("------shopCat-----");
        frame.pack();
        frame.setVisible(true);
        frame.setBounds(200,200,200,200);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
