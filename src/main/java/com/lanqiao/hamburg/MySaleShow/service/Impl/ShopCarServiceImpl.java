package com.lanqiao.hamburg.MySaleShow.service.Impl;

import com.lanqiao.hamburg.MySaleShow.dao.CurrentUserDao;
import com.lanqiao.hamburg.MySaleShow.dao.Impl.CurrentUserDaoImpl;
import com.lanqiao.hamburg.MySaleShow.dao.Impl.ItemDaoImpl;
import com.lanqiao.hamburg.MySaleShow.dao.Impl.ShopCarDaoImpl;
import com.lanqiao.hamburg.MySaleShow.dao.ItemDao;
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

    //由于我只有临时库存表的权限，也就是说
    @Override
    public void Preorder() {
        ShopCarDao shopCarDao = new ShopCarDaoImpl();
        ItemDao itemDao = new ItemDaoImpl();
        try {
            ResultSet rs = shopCarDao.SelectAll();
            while(rs.next()){   //只有找到购物车表有结果集时才传，所以要保证购物车商品ID的唯一性，即独占一行
                //这就要求在加入购物车时，是否是直接插入还是先判断后更新了。
               //传入在购物车按行搜到的结果集，从结果集中得到菜名，根据菜名去item表中找到库存
                //在结果集中找到id,与库存一起传入item_stock表中，注意是表中查不到ID时才传。
                System.out.println("查到数据商品名:"+rs.getString(7)+"   查到商品ID:"+rs.getInt(2));
                itemDao.InventoryData(itemDao.SelectSock(rs.getString(7)),rs.getInt(2));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
