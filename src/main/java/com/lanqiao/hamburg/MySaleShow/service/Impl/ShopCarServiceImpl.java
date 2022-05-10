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

    /**
     * @description: 实现用户加入购物车的业务
     * @param shopCar: 从控制器输入ShopCar类型数据
     * @return void
     * @author: DavidNan
     * @date: 2022/5/9 12:50
     */

    @Override
    public void JoinCarService(ShopCar shopCar,int num) throws SQLException {
        CurrentUserDao currentUserDao = new CurrentUserDaoImpl();
        ShopCarDao shopCarDao = new ShopCarDaoImpl();  // 数据生成器
        shopCarDao.InsertToCart(currentUserDao.QueryUser(),shopCar,num); //输出到SQL
    }

    /**
     * @description: 实现购物车的重置查询
     * @param :
     * @return java.sql.ResultSet
     * @author: DavidNan
     * @date: 2022/5/9 16:44
     */

    @Override
    public ResultSet ResetQueryService() {
        ResultSet rs = null;
        //先重置
        ShopCarDao shopCarDao = new ShopCarDaoImpl();
        shopCarDao.ResetQuery();
        //查询返回结果集
        return shopCarDao.SelectAll();
    }


}
