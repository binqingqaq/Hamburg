package com.lanqiao.hamburg.FoodManage.impl;



import com.lanqiao.hamburg.FoodManage.FoodManagePanel;
import com.lanqiao.hamburg.Interface.dao.DishesManageDAO;
import com.lanqiao.hamburg.Jform.UpdateItemForm;
import com.lanqiao.hamburg.Tools.JDBCtil;
import com.lanqiao.hamburg.entity.Item;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DishesManageImpl implements DishesManageDAO {
    public JTable table1;
    private JTextField textField1;
    public static UpdateItemForm updateItemForm;
    public DishesManageImpl(JTable table1) {
        this.table1 = table1;
    }
    public DishesManageImpl(JTextField textField1) {
        this.textField1 = textField1;
    }
    public DishesManageImpl(){
    }
    /**
     * @方法说明 修改商品信息，获取表中信息并且传给窗口updateItemForm
     * @author Binqing
     * @date 2022/5/7 22:00
     * @param
     * @return void
     */

    @Override
    public void modifyDishes() {
        int rowNo = table1.getSelectedRow();//获取所选的行号
        if (rowNo==-1){
            JOptionPane.showMessageDialog(null, "请选择需要修改的餐品！");
        }else{
            //获取选中行中的各列信息
            int id=(Integer) table1.getValueAt(rowNo, 0) ;
            String product_id=(String)table1.getValueAt(rowNo, 1);
            String pro_cate=(String) table1.getValueAt(rowNo, 2);
            String pro_name=(String)table1.getValueAt(rowNo, 3);
            float price=(Float) table1.getValueAt(rowNo, 4);
            float prefer_price=(Float) table1.getValueAt(rowNo, 5);
            int stock=(Integer) table1.getValueAt(rowNo, 6);
            String img_url=String.valueOf(table1.getValueAt(rowNo, 7));
            Item item=new Item(id,product_id,pro_cate,pro_name,price,prefer_price,stock,img_url);
            updateItemForm =new UpdateItemForm(item);
            updateItemForm.setVisible(true);
        }

    }

    /**
     * @方法说明 与数据库交互删除一条记录
     * @author Binqing
     * @date 2022/5/7 22:01
     * @param
     * @return void
     */

    @Override
    public void deleteDishes() {
        int rowNo = table1.getSelectedRow();//获取所选的行号
        if (rowNo==-1){
            JOptionPane.showMessageDialog(null, "请选择需要删除的餐品！");
        }else{
            int id=(int)table1.getValueAt(rowNo, 0);
            Connection conn=null;
            PreparedStatement pstmt = null;
            String sql = "DELETE  FROM item WHERE id = ?;";
            String sql2 = "ALTER  TABLE  `item` DROP `id`;";
            String sql3 = "ALTER  TABLE  `item` ADD id mediumint(6) PRIMARY KEY NOT NULL AUTO_INCREMENT FIRST;";

            try {
                conn = JDBCtil.getConnection();
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1,id);
                System.out.println(sql);
                pstmt.executeUpdate();
                conn.prepareStatement(sql2).executeUpdate();
                conn.prepareStatement(sql3).executeUpdate();

                FoodManagePanel.updateTable(0);

            } catch (SQLException ex) {
                ex.printStackTrace();
            }finally {
                JDBCtil.close(conn,null,pstmt,null);
            }

        }
    }

    @Override
    public void seekDishes() {

        if (textField1.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "请输入有效信息！");
        }
    }
}
