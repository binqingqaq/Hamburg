package cn.edu.guet.weappdemo.dao.impl;


import cn.edu.guet.weappdemo.bean.CurrentUser;
import cn.edu.guet.weappdemo.bean.ShopCar;
import cn.edu.guet.weappdemo.dao.ShopCarDao;
import cn.edu.guet.weappdemo.util.ConnectionHandler;

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
     * @description: ���ﳵ��������
     * @param currentUser: 
     * @return void
     * @author: DavidNan
     * @date: 2022/5/9 12:18
     */
    
    @Override
    public void InsertToCart(CurrentUser currentUser, ShopCar shopCar, int num) throws SQLException {
        String sql = "insert into ShopCar values(?,?,?,?,?,?,?)";
        conn= ConnectionHandler.getConn();
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
     * @description: ��ѯ���й��ﳵ������
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
     * @description: ���������������Զ���������
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
     * @description: ɾ���ض�������
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
     * @description: ���¼��빺�ﳵ����Ʒ����
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
     * @description: ���㹺�ﳵ��������������
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
        //��һ��ShopCar���ڷ��ظ����˵���
        ShopCar carA = new ShopCar();
        try {
            conn = ConnectionHandler.getConn();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                //ֻ����һ��
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
            conn.commit();  //可能是外部自动提交失败
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
