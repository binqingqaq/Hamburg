package com.lanqiao.hamburg.MySaleShow.service.Impl;

import com.lanqiao.hamburg.MySaleShow.dao.CurrentUserDao;
import com.lanqiao.hamburg.MySaleShow.dao.Impl.CurrentUserDaoImpl;
import com.lanqiao.hamburg.MySaleShow.dao.Impl.ShopCarDaoImpl;
import com.lanqiao.hamburg.MySaleShow.dao.ShopCarDao;
import com.lanqiao.hamburg.MySaleShow.entity.ShopCar;
import com.lanqiao.hamburg.MySaleShow.service.ShopCarService;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @version 1.0
 * @Author qin
 * @Date 2022/5/9 11:30
 */
public class ShopCarServiceImpl implements ShopCarService {



    @Override
    public void JoinCarService(ShopCar shopCar,int num) throws SQLException {
        CurrentUserDao currentUserDao = new CurrentUserDaoImpl();
        ShopCarDao shopCarDao = new ShopCarDaoImpl();  // ����������
        shopCarDao.InsertToCart(currentUserDao.QueryUser(),shopCar,num); //�����SQL
    }


    @Override
    public ResultSet ResetQueryService() {
        ResultSet rs = null;

        ShopCarDao shopCarDao = new ShopCarDaoImpl();
        shopCarDao.ResetQuery();

        return shopCarDao.SelectAll();
    }


}
