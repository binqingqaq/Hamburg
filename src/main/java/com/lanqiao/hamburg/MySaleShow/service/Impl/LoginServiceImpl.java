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
     * @description: ִ�е�¼�Ĳ�ѯ�ȶ���ɹ���¼���¼��¼���ݵ�ҵ��
     * @param user: �����ڿ����������µ�user����ȡ�ڿ������ػ�ı�����
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
            return 0; //˵��userDaoImplִ�еķ���user��δ����ID,��Ĭ��Ϊ0
        }
        System.out.println("��ϲ" + TestUser.getUser_name() + "�����ɹ���¼");
        return 1;  //�ɹ���¼
    }

    /**
     * @description: �û�ע����ҵ���ж������û������ó���ID��1������Ĭ��IDΪ1
     * @param :�����user�������ı����ṩ
     * @return void
     * @author: DavidNan
     * @date: 2022/5/10 11:04
     */
    @Override
    public void RegisteredUser(user user) {
        UserDao userDao = new UserDaoImpl();
        int id = 1;  //Ĭ��Ϊ1����ѯ�����û�������
        if((userDao.SelectEndID().getUser_id())!=0){
            id=userDao.SelectEndID().getUser_id()+1; //��ȡ���һλ�û�����1
        }
        user.setUser_id(id); //����user��id
        userDao.register(user); //����Ϊ���ı����ȡ�û���������������user�Ķ���
    }
}
