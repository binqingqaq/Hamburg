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

    /**
     * @description: ���ڲ�ѯ�û�
     * @param user: �û�ʵ����
     * @return int:��������
     * @author: DavidNan
     * @date: 2022/5/8 17:46
     */

   public user LoginSelect(user user) throws SQLException;

   /**
    * @description: �û�ע�ᣬ���û���user����������
    * @param user: �û�ʵ����
    * @return user: ���ر����µ�ʵ����
    * @author: DavidNan
    * @date: 2022/5/8 17:48
    */

   public void register(user user);

   /**
    * @description: ��ѯ���һλ�û�ID
    * @param :
    * @return void
    * @author: DavidNan
    * @date: 2022/5/10 10:52
    */

   public user SelectEndID();


}
