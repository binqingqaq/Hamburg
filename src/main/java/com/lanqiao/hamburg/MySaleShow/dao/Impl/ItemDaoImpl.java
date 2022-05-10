package com.lanqiao.hamburg.MySaleShow.dao.Impl;

import com.lanqiao.hamburg.MySaleShow.dao.ItemDao;
import com.lanqiao.hamburg.MySaleShow.util.ConnectionHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @version 1.0
 * @Author qin
 * @Date 2022/5/8 22:03
 */
public class ItemDaoImpl implements ItemDao {

    Connection conn = null;
    Statement stmt=null;
    ResultSet rs = null;

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
}
