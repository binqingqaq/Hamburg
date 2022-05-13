package cn.edu.guet.weappdemo.dao.impl;



import cn.edu.guet.weappdemo.dao.ItemDao;
import cn.edu.guet.weappdemo.util.ConnectionHandler;

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
     * @description: ��ѯItem������
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
    * @description: ������Ʒ���Ͳ��������Ʒ����
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
     * @description: ���ݸ�����Ʒ����ѯͼƬ����Ե�ַλ
     * @param FoodName:
     * @return ImgPath:����ͼƬ����Ե�ַ
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
     * @description: ����ַ������⣬���������ַ��쳣
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
