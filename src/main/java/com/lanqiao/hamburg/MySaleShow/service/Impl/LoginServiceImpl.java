package com.lanqiao.hamburg.MySaleShow.service.Impl;

import com.lanqiao.hamburg.MySaleShow.dao.CurrentUserDao;
import com.lanqiao.hamburg.MySaleShow.dao.Impl.CurrentUserDaoImpl;
import com.lanqiao.hamburg.MySaleShow.dao.Impl.UserDaoImpl;
import com.lanqiao.hamburg.MySaleShow.dao.ShopCarDao;
import com.lanqiao.hamburg.MySaleShow.dao.UserDao;
import com.lanqiao.hamburg.MySaleShow.entity.ShopCar;
import com.lanqiao.hamburg.MySaleShow.entity.user;
import com.lanqiao.hamburg.MySaleShow.service.LoginService;
import com.lanqiao.hamburg.MySaleShow.entity.*;

import java.sql.SQLException;

/**
 * @version 1.0
 * @Author qin
 * @Date 2022/5/8 19:34
 */
public class LoginServiceImpl implements LoginService {
    /**
     * @description: Login and record login service
     * @param user:
     * @return void
     * @author: DavidNan
     * @date: 2022/5/8 20:52
     */

    @Override
    public int LoginAndRecord(user user) throws SQLException {
        UserDao userDao = new UserDaoImpl();
        CurrentUserDao currentUserDao = new CurrentUserDaoImpl();
        user TestUser = userDao.LoginSelect(user);
        currentUserDao.RegistrationRecord(TestUser);
        if(TestUser.getUser_id()==0){
            return 0; //Can not find return zero
        }
        //Congratulations to someone who has successfully logged in
        System.out.println("Congratulations to" + TestUser.getUser_name() + "who has successfully logged in");
        return 1;
    }

    /**
     * @description: register implementation insert
     * @param :
     * @return void
     * @author: DavidNan
     * @date: 2022/5/10 11:04
     */
    @Override
    public void RegisteredUser(user user) {
        UserDao userDao = new UserDaoImpl();
        int id = 1;
        if((userDao.SelectEndID().getUser_id())!=0){
            id=userDao.SelectEndID().getUser_id()+1;
        }
        user.setUser_id(id);
        userDao.register(user);
    }
}
