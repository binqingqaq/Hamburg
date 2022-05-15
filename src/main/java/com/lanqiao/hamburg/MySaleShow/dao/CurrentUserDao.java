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
     * @description: ���ڵ�¼��¼
     * @param user: �㶮��
     * @return void
     * @author: DavidNan
     * @date: 2022/5/8 19:27
     */
    
    public void RegistrationRecord(user user) throws SQLException;

    /**
     * @description: ��ѯ�û���ID
     * @param :
     * @return void
     * @author: DavidNan
     * @date: 2022/5/9 11:55
     */

    public CurrentUser QueryUser() throws SQLException;
    
    /**
     * @description: �����¼����
     * @param : 
     * @return void
     * @author: DavidNan
     * @date: 2022/5/9 19:31
     */
    
    public void DelLoginData();
}
