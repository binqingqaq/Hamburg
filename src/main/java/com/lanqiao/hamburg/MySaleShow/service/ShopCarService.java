package com.lanqiao.hamburg.MySaleShow.service;

import com.lanqiao.hamburg.MySaleShow.entity.ShopCar;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @version 1.0
 * @Author qin
 * @Date 2022/5/9 11:29
 */
public interface ShopCarService {

    /**
     * @description: �㶮��
     * @param :
     * @return void
     * @author: DavidNan
     * @date: 2022/5/9 12:50
     */

    public void JoinCarService(ShopCar shopCar,int num) throws SQLException;

    /**
     * @description: ������ȫ�ֲ�ѯ
     * @param :
     * @return: �������ú�ȫ����ѯ���α�
     * @author: DavidNan
     * @date: 2022/5/9 16:40
     */

    public ResultSet ResetQueryService();
}
