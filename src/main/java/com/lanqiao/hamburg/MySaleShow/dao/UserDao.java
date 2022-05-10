package com.lanqiao.hamburg.MySaleShow.dao;

import com.lanqiao.hamburg.MySaleShow.entity.user;
import com.lanqiao.hamburg.MySaleShow.entity.*;

import java.sql.SQLException;

/**
 * @version 1.0
 * @Author qin
 * @Date 2022/5/8 17:19
 */
public interface UserDao {


   //See implementation class UserDaoImpl

   public user LoginSelect(user user) throws SQLException;

   //See implementation class UserDaoImpl

   public void register(user user);

   //See implementation class UserDaoImpl

   public user SelectEndID();


}
