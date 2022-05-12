package com.lanqiao.hamburg.MySaleShow.dao.Impl;

import com.lanqiao.hamburg.MySaleShow.dao.ShopCarDao;
import com.lanqiao.hamburg.MySaleShow.entity.CurrentUser;
import com.lanqiao.hamburg.MySaleShow.entity.ShopCar;
import com.lanqiao.hamburg.MySaleShow.util.ConnectionHandler;

import java.sql.*;

/**
 * @version 1.0
 * @Author qin
 * @Date 2022/5/9 11:26
 */
public class ShopCarDaoImpl implements ShopCarDao {

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement pstmt = null;
    /**
     * @description: 向购物车插入数据
     * @param currentUser: 
     * @return void
     * @author: DavidNan
     * @date: 2022/5/9 12:18
     */
    
    @Override
    public void InsertToCart(CurrentUser currentUser,ShopCar shopCar,int num) throws SQLException {
        String sql = "insert into ShopCar values(?,?,?,?,?,?,?)";
        conn=ConnectionHandler.getConn();
        PreparedStatement pstmt=conn.prepareStatement(sql);
        pstmt.setNull(1,shopCar.getColnum());
        pstmt.setInt(2,shopCar.getId());
        pstmt.setFloat(3,shopCar.getPrice());
        pstmt.setInt(4,num);
        pstmt.setInt(5,currentUser.getUser_id());
        pstmt.setString(6,currentUser.getUser_name());
        pstmt.setString(7, shopCar.getTitle());
        pstmt.executeUpdate();

    }

    /**
     * @description: 查询所有购物车表数据
     * @param :
     * @return java.sql.ResultSet
     * @author: DavidNan
     * @date: 2022/5/9 16:35
     */

    @Override
    public ResultSet SelectAll() {
        String sql = "select * from ShopCar";
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
     * @description: 重置主键，避免自动增长错序
     * @param :
     * @return java.sql.ResultSet
     * @author: DavidNan
     * @date: 2022/5/9 16:36
     */

    @Override
    public void ResetQuery() {
        try {
            conn = ConnectionHandler.getConn();
            String sql2[] ={"SET @auto_id = 0;",
                    "UPDATE ShopCar  SET colnum = (@auto_id := @auto_id + 1);",
                    "ALTER TABLE ShopCar  AUTO_INCREMENT = 1;"};
            for(String item:sql2){
                pstmt = conn.prepareStatement(item);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @description: 删除特定行数据
     * @param : 
     * @return void
     * @author: DavidNan
     * @date: 2022/5/9 17:19
     */
    
    @Override
    public void DeleteRow(ShopCar car) {
        try {
            conn = ConnectionHandler.getConn();
            String sql = "delete from ShopCar where colnum=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,car.getColnum());
            pstmt.executeUpdate();
            ConnectionHandler.closeConnection();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * @description: 更新加入购物车的商品数量
     * @param :
     * @return void
     * @author: DavidNan
     * @date: 2022/5/9 17:19
     */

    @Override
    public void UpdateNum(ShopCar car) {
        try {
            conn = ConnectionHandler.getConn();
            String sql = "update ShopCar u set u.num=? where u.colnum=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(2,car.getColnum());
            pstmt.setInt(1,car.getNum());
            pstmt.executeUpdate();
            ConnectionHandler.closeConnection();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @description: 结算购物车发出清理购物请求
     * @param :
     * @return void
     * @author: DavidNan
     * @date: 2022/5/9 17:43
     */

    @Override
    public ShopCar Settlement() {
        String sql = "select user_name,sum(price*num) " +
                "from ShopCar where user_name=" +
                "(select distinct c.user_name " +
                "from CurrentUser c) GROUP BY(user_name)";
        //建一个ShopCar便于返回给别人调用
        ShopCar carA = new ShopCar();
        try {
            conn = ConnectionHandler.getConn();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                //只生成一行
                carA.setUser_name(rs.getString(1));
                carA.setPrice(rs.getFloat(2));
            }
            stmt.close();
            rs.close();
            ConnectionHandler.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carA;
    }

    @Override
    public void DelAll() {
        String sql = "delete from ShopCar";
        try {
            conn = ConnectionHandler.getConn();
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            pstmt.close();
            ConnectionHandler.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean SelectID(int id) {
        String sql = "select * from ShopCar where id='"+id+"'";
        try {
            conn = ConnectionHandler.getConn();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                return true;
            }else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //有就拿出来，然后再在原来的基础上加上现有的数据
    public void UpdateAddNum(ShopCar shopCar) throws SQLException {
        conn = ConnectionHandler.getConn();
        stmt = conn.createStatement();
        String sql = "select num from ShopCar where id= '"+shopCar.getId()+"'";
        rs = stmt.executeQuery(sql);
        int num=0;
        if(rs.next()){
           num= rs.getInt(1);    //将当前商品ID查到的数量用num保存
        }
        String sql2 = "update ShopCar set num='"+(shopCar.getNum()+num)+"'"+"where id='"+shopCar.getId()+"'";
        pstmt = conn.prepareStatement(sql2);
        pstmt.executeUpdate(sql2);  //数据更新完毕
        stmt.close();
        pstmt.close();
        ConnectionHandler.closeConnection();
    }

}
