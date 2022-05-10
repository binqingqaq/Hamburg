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
    @Override
    public void modifyDishes() {
        System.out.println("ִ�е�����");
        int rowNo = table1.getSelectedRow();//��ȡ��ѡ���к�

        if (rowNo==-1){
            JOptionPane.showMessageDialog(null, "��ѡ����Ҫ�޸ĵĲ�Ʒ��");
        }else{
            //��ȡѡ����
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

    @Override
    public void deleteDishes() {
        int rowNo = table1.getSelectedRow();//��ȡ��ѡ���к�
        if (rowNo==-1){
            JOptionPane.showMessageDialog(null, "��ѡ����Ҫɾ���Ĳ�Ʒ��");
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
            JOptionPane.showMessageDialog(null, "��������Ч��Ϣ��");
        }
    }
}
