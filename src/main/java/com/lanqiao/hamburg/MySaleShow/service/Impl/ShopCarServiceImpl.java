package com.lanqiao.hamburg.MySaleShow.service.Impl;

import com.lanqiao.hamburg.MySaleShow.dao.CurrentUserDao;
import com.lanqiao.hamburg.MySaleShow.dao.Impl.CurrentUserDaoImpl;
import com.lanqiao.hamburg.MySaleShow.dao.Impl.ShopCarDaoImpl;
import com.lanqiao.hamburg.MySaleShow.dao.ShopCarDao;
import com.lanqiao.hamburg.MySaleShow.entity.ShopCar;
import com.lanqiao.hamburg.MySaleShow.service.ShopCarService;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @version 1.0
 * @Author qin
 * @Date 2022/5/9 11:30
 */
public class ShopCarServiceImpl implements ShopCarService {

    /**
     * @description: ʵ���û����빺�ﳵ��ҵ��
     * @param shopCar: �ӿ���������ShopCar��������
     * @return void
     * @author: DavidNan
     * @date: 2022/5/9 12:50
     */

    @Override
    public void JoinCarService(ShopCar shopCar,int num) throws SQLException {
        CurrentUserDao currentUserDao = new CurrentUserDaoImpl();
        ShopCarDao shopCarDao = new ShopCarDaoImpl();  // ����������
        shopCarDao.InsertToCart(currentUserDao.QueryUser(),shopCar,num); //�����SQL
    }

    /**
     * @description: ʵ�ֹ��ﳵ�����ò�ѯ
     * @param :
     * @return java.sql.ResultSet
     * @author: DavidNan
     * @date: 2022/5/9 16:44
     */

    @Override
    public ResultSet ResetQueryService() {
        ResultSet rs = null;
        //������
        ShopCarDao shopCarDao = new ShopCarDaoImpl();
        shopCarDao.ResetQuery();
        //��ѯ���ؽ����
        return shopCarDao.SelectAll();
    }


}
