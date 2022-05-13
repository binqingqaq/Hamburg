package cn.edu.guet.weappdemo.dao;

import cn.edu.guet.weappdemo.bean.CurrentUser;
import cn.edu.guet.weappdemo.bean.ShopCar;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ShopCarDao {

    
    public void InsertToCart(CurrentUser currentUser, ShopCar shopCar, int num) throws SQLException;



    public ResultSet SelectAll();



    public void ResetQuery();



    public void DeleteRow(ShopCar car);


    public void UpdateNum(ShopCar car);


    public ShopCar Settlement();


    public void DelAll();
}
