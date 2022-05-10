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

    /**
     * @description: 你懂的
     * @param :
     * @return void
     * @author: DavidNan
     * @date: 2022/5/9 12:50
     */

    public void JoinCarService(ShopCar shopCar,int num) throws SQLException;

    /**
     * @description: 重置与全局查询
     * @param :
     * @return: 返回重置后全部查询的游标
     * @author: DavidNan
     * @date: 2022/5/9 16:40
     */

    public ResultSet ResetQueryService();
}
