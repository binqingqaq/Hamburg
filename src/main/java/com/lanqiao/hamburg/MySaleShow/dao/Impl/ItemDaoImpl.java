package com.lanqiao.hamburg.MySaleShow.dao.Impl;

import com.lanqiao.hamburg.MySaleShow.dao.ItemDao;
import com.lanqiao.hamburg.MySaleShow.util.ConnectionHandler;

import java.sql.*;

/**
 * @version 1.0
 * @Author qin
 * @Date 2022/5/8 22:03
 */
public class ItemDaoImpl implements ItemDao {

    Connection conn = null;
    Statement stmt=null;
    ResultSet rs = null;
    PreparedStatement pstmt = null;

    /**
     * @description: 查询Item表数据
     * @param : 
     * @return java.sql.ResultSet
     * @author: DavidNan
     * @date: 2022/5/9 10:34
     */
    
    @Override
    public ResultSet SelectItem() {

        String sql = "select * from item";
        try {
            conn = ConnectionHandler.getConn();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;

    }

   /**
    * @description: 根据商品类型查找相关商品数据
    * @param ColName: 
    * @return java.sql.ResultSet
    * @author: DavidNan
    * @date: 2022/5/9 10:34
    */
   
    @Override
    public ResultSet SelectFoodType(String ColName) {

        String sql = "select * from item where product_category='"+ColName+"'";
        Statement stmt=null;
        ResultSet rs = null;
        try {
            conn = ConnectionHandler.getConn();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    /**
     * @description: 根据给定商品名查询图片的相对地址位
     * @param FoodName:
     * @return ImgPath:返回图片的相对地址
     * @author: DavidNan
     * @date: 2022/5/9 11:13
     */

    @Override
    public String SelectImgAdd(String FoodName) {

        String sql = "select img_url from item where product_name='"+FoodName+"'";
        String ImgPath="";
        try {
            conn = ConnectionHandler.getConn();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                ImgPath=rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ImgPath;
    }

    /**
     * @description: 解决字符集问题，避免中文字符异常
     * @param :
     * @return java.sql.ResultSet
     * @author: DavidNan
     * @date: 2022/5/11 0:41
     */

    @Override
    public ResultSet SelectFoodType() {
        try {
            String sql = "SELECT DISTINCT product_category FROM item;";
            conn = ConnectionHandler.getConn();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public int SelectSock(String name) {
        int sk=0;
        try {
            String sql = "SELECT stock FROM item where product_name='"+name+"'";
            conn = ConnectionHandler.getConn();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                sk=rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sk;
    }

    @Override
    public void InventoryData(int stock,int item_id) {
        String sql="select * from item_stock where item_id="+item_id;
        String sql1="insert into item_stock(stock,item_id) values(?,?)";
        try {
            conn = ConnectionHandler.getConn();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                //若过查到的行为非空集则跳过本次插入
                System.out.println("InventoryData测试item_stock表对应数据不为空");
            }else{
                //若查到的为空集，则直接插入
                System.out.println("InventoryData测试item_stock表对应数据为空");
                pstmt =conn.prepareStatement(sql1);
                pstmt.setInt(1,stock);
                pstmt.setInt(2,item_id);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
