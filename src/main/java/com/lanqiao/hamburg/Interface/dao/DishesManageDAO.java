package com.lanqiao.hamburg.Interface.dao;


/**
 * 与数据库信息进行交互
 */
public interface DishesManageDAO {


    //菜品修改
    void modifyDishes();

    //删除菜品
    void deleteDishes();

    //查询菜品
    void seekDishes();


    //对修改过的菜品进行保存
    //void Savemodify();

}
