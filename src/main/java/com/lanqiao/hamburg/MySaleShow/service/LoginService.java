package com.lanqiao.hamburg.MySaleShow.service;

import com.lanqiao.hamburg.MySaleShow.entity.user;

import java.sql.SQLException;

/**
 * @version 1.0
 * @Author qin
 * @Date 2022/5/8 19:35
 */
public interface LoginService {
    
    public int LoginAndRecord(user user) throws SQLException;



    public void RegisteredUser(user user);
}
