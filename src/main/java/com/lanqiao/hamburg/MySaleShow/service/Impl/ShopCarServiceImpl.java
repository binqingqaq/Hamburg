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


    //添加服务，若购物车有数据，则更新对应num,若无数据则直接插入
    @Override
    public void JoinCarService(ShopCar shopCar,int num) throws SQLException {
        CurrentUserDao currentUserDao = new CurrentUserDaoImpl();
        ShopCarDao shopCarDao = new ShopCarDaoImpl();
        if(shopCarDao.SelectID(shopCar.getId())){  //购物车无对应ID
            System.out.println("购物车有ID");
            shopCarDao.UpdateAddNum(shopCar);
        }else{
            System.out.println(shopCar.getId()+"购物车无ID");
            shopCarDao.InsertToCart(currentUserDao.QueryUser(),shopCar,num);
        }
    }


    @Override
    public ResultSet ResetQueryService() {
        ResultSet rs = null;

        ShopCarDao shopCarDao = new ShopCarDaoImpl();
        shopCarDao.ResetQuery();

        return shopCarDao.SelectAll();
    }


}
