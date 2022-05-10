package com.lanqiao.hamburg.MySaleShow.service;

import com.lanqiao.hamburg.MySaleShow.entity.user;

import java.sql.SQLException;

/**
 * @version 1.0
 * @Author qin
 * @Date 2022/5/8 19:35
 */
public interface LoginService {
    /**
     * @description: 登录和登录记录
     * @param : 
     * @return void
     * @author: DavidNan
     * @date: 2022/5/8 19:37
     */
    
    public int LoginAndRecord(user user) throws SQLException;

    /**
     * @description: 用户注册板块业务
     * @param :
     * @return void
     * @author: DavidNan
     * @date: 2022/5/10 11:04
     */

    public void RegisteredUser(user user);
}
