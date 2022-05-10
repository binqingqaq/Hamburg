package com.lanqiao.hamburg.MySaleShow.service.Impl;

import com.lanqiao.hamburg.MySaleShow.dao.CurrentUserDao;
import com.lanqiao.hamburg.MySaleShow.dao.Impl.CurrentUserDaoImpl;
import com.lanqiao.hamburg.MySaleShow.dao.Impl.UserDaoImpl;
import com.lanqiao.hamburg.MySaleShow.dao.ShopCarDao;
import com.lanqiao.hamburg.MySaleShow.dao.UserDao;
import com.lanqiao.hamburg.MySaleShow.entity.ShopCar;
import com.lanqiao.hamburg.MySaleShow.entity.user;
import com.lanqiao.hamburg.MySaleShow.service.LoginService;
import com.lanqiao.hamburg.entity.User;

import java.sql.SQLException;

/**
 * @version 1.0
 * @Author qin
 * @Date 2022/5/8 19:34
 */
public class LoginServiceImpl implements LoginService {
    /**
     * @description: 执行登录的查询比对与成功登录后记录登录数据的业务
     * @param user: 传入在控制器被更新的user，获取在控制器截获的表单数据
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
            return 0; //说明userDaoImpl执行的返回user表未更新ID,即默认为0
        }
        System.out.println("恭喜" + TestUser.getUser_name() + "先生成功登录");
        return 1;  //成功登录
    }

    /**
     * @description: 用户注册板块业务，判断有误用户有则拿出来ID加1，无则默认ID为1
     * @param :传入的user由密码文本域提供
     * @return void
     * @author: DavidNan
     * @date: 2022/5/10 11:04
     */
    @Override
    public void RegisteredUser(user user) {
        UserDao userDao = new UserDaoImpl();
        int id = 1;  //默认为1若查询到有用户再设置
        if((userDao.SelectEndID().getUser_id())!=0){
            id=userDao.SelectEndID().getUser_id()+1; //获取最后一位用户并加1
        }
        user.setUser_id(id); //更新user的id
        userDao.register(user); //参数为在文本域获取用户名和密码设置在user的对象
    }
}
