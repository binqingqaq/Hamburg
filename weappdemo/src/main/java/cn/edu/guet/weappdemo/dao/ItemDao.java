package cn.edu.guet.weappdemo.dao;

import java.sql.ResultSet;

/**
 * @version 1.0
 * @Author qin
 * @Date 2022/5/8 22:01
 */
public interface ItemDao {

    /**
     * @description: ��ѯItem�����ڹ����˵�
     * @param : 
     * @return void
     * @author: DavidNan
     * @date: 2022/5/8 22:03
     */
    
    public ResultSet SelectItem();

    /**
     * @description: ������������
     * @param ColName:
     * @return java.sql.ResultSet
     * @author: DavidNan
     * @date: 2022/5/9 10:35
     */

    public ResultSet SelectFoodType(String ColName);

    /**
     * @description: �򵥸���ʳ���ɶ���Ҷ�Ӧ��ͼƬ,
     * Ϊ�������Ա�����Ʒ����ʧ�󣬽���ֻ���ؽ�����ĵ�һ������
     * @param FoodName:
     * @return java.lang.String
     * @author: DavidNan
     * @date: 2022/5/9 11:05
     */

    public String SelectImgAdd(String FoodName);
    
    /**
     * @description: ���ַ�������þò��ܽ����ֻ�ܵ������ݿ���ַ�������
     * @param : 
     * @return java.sql.ResultSet
     * @author: DavidNan
     * @date: 2022/5/11 1:00
     */
    
    public ResultSet SelectFoodType();


}
