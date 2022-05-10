package com.lanqiao.hamburg.MySaleShow.dao;

import com.lanqiao.hamburg.MySaleShow.entity.CurrentUser;
import com.lanqiao.hamburg.MySaleShow.entity.user;

import java.sql.SQLException;

/**
 * @version 1.0
 * @Author qin
 * @Date 2022/5/8 18:36
 */
public interface CurrentUserDao {
    /**
     * @description: 用于登录记录
     * @param user: 你懂的
     * @return void
     * @author: DavidNan
     * @date: 2022/5/8 19:27
     */
    
    public void RegistrationRecord(user user) throws SQLException;

    /**
     * @description: 查询用户和ID
     * @param :
     * @return void
     * @author: DavidNan
     * @date: 2022/5/9 11:55
     */

    public CurrentUser QueryUser() throws SQLException;
    
    /**
     * @description: 清除登录数据
     * @param : 
     * @return void
     * @author: DavidNan
     * @date: 2022/5/9 19:31
     */
    
    public void DelLoginData();
}
