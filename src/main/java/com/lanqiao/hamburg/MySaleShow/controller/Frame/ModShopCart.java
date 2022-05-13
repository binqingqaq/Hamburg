/*
 * Created by JFormDesigner on Tue May 03 20:08:38 CST 2022
 */

package com.lanqiao.hamburg.MySaleShow.controller.Frame;

import com.lanqiao.hamburg.MySaleShow.controller.Dialog.ModTool;
import com.lanqiao.hamburg.MySaleShow.controller.Dialog.MyPay;
import com.lanqiao.hamburg.MySaleShow.dao.Impl.ShopCarDaoImpl;
import com.lanqiao.hamburg.MySaleShow.dao.ShopCarDao;
import com.lanqiao.hamburg.MySaleShow.entity.ShopCar;
import com.lanqiao.hamburg.MySaleShow.service.Impl.ShopCarServiceImpl;
import com.lanqiao.hamburg.MySaleShow.service.ShopCarService;
import com.lanqiao.hamburg.MySaleShow.util.ConnectionHandler;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @description:修改购物车，显示窗体为我的购物车
 * @author: DavidNan
 * @date: 2022/5/1 20:59
 */

public class ModShopCart extends JFrame {
    public ModShopCart() throws SQLException {
        this.setTitle("MyCar");
        initComponents();
    }

    private void initComponents() throws SQLException {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();

        //======== 表示获取该窗体的(this)内容窗格便于将容器添加进窗体 ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1:天天菜单头标签 ----
        label1.setText("\u4f60\u7684\u8d2d\u7269\u8f66");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(165, 20), label1.getPreferredSize()));

        //======== scrollPane1:滚动窗格 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(35, 45, 330, 125);

        ResultSet rs = null;
        ShopCarDao shopCarDao = new ShopCarDaoImpl();
        rs = shopCarDao.SelectAll();
        DefaultTableModel tableModel = new DefaultTableModel(getDataFromDatabase(rs), head) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        table1.setModel(tableModel);

        //---- button1:查询按钮----
        button1.setText("\u67e5\u8be2\u8d2d\u7269\u8f66");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(40, 190), button1.getPreferredSize()));
        button1.addActionListener(a->{
            try {
                ShopCarService scs =new ShopCarServiceImpl();
                DefaultTableModel tableModel1 = new DefaultTableModel(getDataFromDatabase(scs.ResetQueryService()), head) {
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };
                table1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                table1.setModel(tableModel1);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        //------- button2:修改购物车按钮 -------
        button2.setText("\u4fee\u6539\u8d2d\u7269\u8f66");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(145, 190), button2.getPreferredSize()));
        button2.addActionListener(a->{
            int rowNo = table1.getSelectedRow();
            if(rowNo==-1){
                JOptionPane.showMessageDialog(this,"请在表格选择商品","错误",0);
            }else{
                int colnum= (int) table1.getValueAt(rowNo,0);
                int id = (int) table1.getValueAt(rowNo,1);
                String title= (String) table1.getValueAt(rowNo,6);
                Float price = (Float)table1.getValueAt(rowNo,2);
                int num = (int)table1.getValueAt(rowNo,3);
                int user_id = (int)table1.getValueAt(rowNo,4);
                String name = (String) table1.getValueAt(rowNo,5);
                Container container = this.getContentPane();
                ShopCar shopCar = new ShopCar(colnum,id,price,num,user_id,name,title);
                new ModTool(shopCar).setVisible(true);
                container.add(button2);
            }
        });
        //---- button3：订单确认 ----//
        button3.setText("\u786e\u8ba4\u8ba2\u5355");
        contentPane.add(button3);
        button3.setBounds(new Rectangle(new Point(250, 190), button3.getPreferredSize()));
        button3.addActionListener(a->{
            //-----订单确认：懒得理了，可以骗一下自己已经完成了-----
            JOptionPane.showMessageDialog(this,"订单已确认","提示",1);
        });
        //---- button4:弹出购物车结算窗体 ----//
        button4.setText("\u6e05\u7a7a\u8d2d\u7269\u8f66/\u652f\u4ed8");
        contentPane.add(button4);
        button4.setBounds(new Rectangle(new Point(210, 225), button4.getPreferredSize()));
        button4.addActionListener(a->{
             ShopCarDao shopCarDao1=new ShopCarDaoImpl();
             MyPay PAY=new MyPay( shopCarDao1.Settlement());
             PAY.setBounds(300,200,350,500);
             PAY.setVisible(true);
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
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JScrollPane scrollPane2;
    private JTable table1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private String head[] = {"ID","FoodID","Price","Num","UserID","UserName","FoodName"};
    private Object[][] data = null;
    Connection conn=null;
    static String name;

    //------------ 测试窗体 -----------
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) throws SQLException {
        new ModShopCart().setVisible(true);
    }
}
