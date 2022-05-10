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
    /**
     * @description: 将截获的数据插入ShopCar表
     * @param : 
     * @return void
     * @author: DavidNan
     * @date: 2022/5/9 11:29
     */
    
    public void InsertToCart(CurrentUser currentUser,ShopCar shopCar,int num) throws SQLException;

    /**
     * @description: 查询所有
     * @param :
     * @return void
     * @author: DavidNan
     * @date: 2022/5/9 14:07
     */

    public ResultSet SelectAll();

    /**
     * @description: 重置查询，避免增删改查时自动增长主键继增长
     * @param :
     * @return java.sql.ResultSet
     * @author: DavidNan
     * @date: 2022/5/9 14:14
     */

    public void ResetQuery();

    /**
     * @description: 删除整行
     * @param :
     * @return void
     * @author: DavidNan
     * @date: 2022/5/9 17:16
     */

    public void DeleteRow(ShopCar car);

    /**
     * @description:
     * @param : 修改数量
     * @return void
     * @author: DavidNan
     * @date: 2022/5/9 17:17
     */

    public void UpdateNum(ShopCar car);

    /**
     * 结算购物车
     */
    public ShopCar Settlement();

    /**
     * @description: 删除所有购物车--建议登录前或退出前执行
     * @param :
     * @return void
     * @author: DavidNan
     * @date: 2022/5/9 19:16
     */

    public void DelAll();
}
