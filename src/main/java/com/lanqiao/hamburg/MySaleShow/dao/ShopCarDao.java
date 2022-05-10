package com.lanqiao.hamburg.MySaleShow.dao;

import com.lanqiao.hamburg.MySaleShow.entity.CurrentUser;
import com.lanqiao.hamburg.MySaleShow.entity.ShopCar;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @version 1.0
 * @Author qin
 * @Date 2022/5/9 11:25
 */
public interface ShopCarDao {
    /**
     * @description: ���ػ�����ݲ���ShopCar��
     * @param : 
     * @return void
     * @author: DavidNan
     * @date: 2022/5/9 11:29
     */
    
    public void InsertToCart(CurrentUser currentUser,ShopCar shopCar,int num) throws SQLException;

    /**
     * @description: ��ѯ����
     * @param :
     * @return void
     * @author: DavidNan
     * @date: 2022/5/9 14:07
     */

    public ResultSet SelectAll();

    /**
     * @description: ���ò�ѯ��������ɾ�Ĳ�ʱ�Զ���������������
     * @param :
     * @return java.sql.ResultSet
     * @author: DavidNan
     * @date: 2022/5/9 14:14
     */

    public void ResetQuery();

    /**
     * @description: ɾ������
     * @param :
     * @return void
     * @author: DavidNan
     * @date: 2022/5/9 17:16
     */

    public void DeleteRow(ShopCar car);

    /**
     * @description:
     * @param : �޸�����
     * @return void
     * @author: DavidNan
     * @date: 2022/5/9 17:17
     */

    public void UpdateNum(ShopCar car);

    /**
     * ���㹺�ﳵ
     */
    public ShopCar Settlement();

    /**
     * @description: ɾ�����й��ﳵ--�����¼ǰ���˳�ǰִ��
     * @param :
     * @return void
     * @author: DavidNan
     * @date: 2022/5/9 19:16
     */

    public void DelAll();
}
