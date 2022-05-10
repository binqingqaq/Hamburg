package com.lanqiao.hamburg.MySaleShow.dao;

import com.lanqiao.hamburg.MySaleShow.entity.user;
import com.lanqiao.hamburg.entity.User;

import java.sql.SQLException;

/**
 * @version 1.0
 * @Author qin
 * @Date 2022/5/8 17:19
 */
public interface UserDao {

    /**
     * @description: 用于查询用户
     * @param user: 用户实体类
     * @return int:返回整数
     * @author: DavidNan
     * @date: 2022/5/8 17:46
     */

   public user LoginSelect(user user) throws SQLException;

   /**
    * @description: 用户注册，向用户表user插入新数据
    * @param user: 用户实体类
    * @return user: 返回被更新的实体类
    * @author: DavidNan
    * @date: 2022/5/8 17:48
    */

   public void register(user user);

   /**
    * @description: 查询最后一位用户ID
    * @param :
    * @return void
    * @author: DavidNan
    * @date: 2022/5/10 10:52
    */

   public user SelectEndID();


}
