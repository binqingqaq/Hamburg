package com.lanqiao.hamburg.MySaleShow.dao;

import com.lanqiao.hamburg.MySaleShow.entity.CurrentUser;
import com.lanqiao.hamburg.MySaleShow.entity.ShopCar;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @version 1.0
 * @Author qin
 * @Date 2022/5/9 11:25
 */
public interface ShopCarDao {
    
    public void InsertToCart(CurrentUser currentUser,ShopCar shopCar,int num) throws SQLException;


    public ResultSet SelectAll();


    public void ResetQuery();

    public void DeleteRow(ShopCar car);


    public void UpdateNum(ShopCar car);

    public ShopCar Settlement();

    public void DelAll();

    public boolean SelectID(int id);  //根据食物ID判断在购物车中是否存在，若存在则返回true

    public void UpdateAddNum(ShopCar shopCar) throws SQLException;//看实现类


}
