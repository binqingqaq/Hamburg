package com.lanqiao.hamburg.MySaleShow.service;

import com.lanqiao.hamburg.MySaleShow.entity.ShopCar;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @version 1.0
 * @Author qin
 * @Date 2022/5/9 11:29
 */
public interface ShopCarService {

    //The code is a comment, the specific function depends on the implementation class
    public void JoinCarService(ShopCar shopCar,int num) throws SQLException;

    //The code is a comment, the specific function depends on the implementation class
    public ResultSet ResetQueryService();

    //Prepare the order before payment, so as to provide the data required for the payment process
    public void Preorder();
}
