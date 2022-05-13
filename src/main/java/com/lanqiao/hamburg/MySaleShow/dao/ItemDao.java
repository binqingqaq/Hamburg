package com.lanqiao.hamburg.MySaleShow.dao;

import java.sql.ResultSet;

/**
 * @version 1.0
 * @Author qin
 * @Date 2022/5/8 22:01
 */
public interface ItemDao {

    /**
     * @description: 查询Item表，用于构建菜单
     * @param : 
     * @return void
     * @author: DavidNan
     * @date: 2022/5/8 22:03
     */
    
    public ResultSet SelectItem();

    /**
     * @description: 查找类型数据
     * @param ColName:
     * @return java.sql.ResultSet
     * @author: DavidNan
     * @date: 2022/5/9 10:35
     */

    public ResultSet SelectFoodType(String ColName);

    /**
     * @description: 简单根据食物叫啥查找对应的图片,
     * 为避免管理员添加商品操作失误，建议只返回结果集的第一行数据
     * @param FoodName:
     * @return java.lang.String
     * @author: DavidNan
     * @date: 2022/5/9 11:05
     */

    public String SelectImgAdd(String FoodName);
    
    /**
     * @description: 因字符集问题久久不能解决，只能调用数据库的字符来避免
     * @param : 
     * @return java.sql.ResultSet
     * @author: DavidNan
     * @date: 2022/5/11 1:00
     */
    
    public ResultSet SelectFoodType();

    public int SelectSock(String name);

    //用于判断item_stock的库存并选用是否插入还是更新
    public void InventoryData(int stock,int item_id);

}
