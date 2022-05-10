package com.lanqiao.hamburg.FoodManage.impl;



import com.lanqiao.hamburg.Interface.dao.GetDataFromDatabaseDAO;
import com.lanqiao.hamburg.Tools.JDBCtil;
import com.lanqiao.hamburg.entity.Item;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
/**
 * @author Binqing
 * @类说明 实现GetDataFromDatabaseDAO接口，与数据库进行交互，获取数据库表的数据
 * @date 2022/5/7
 */
public class GetDataFromDatabaseImpl implements GetDataFromDatabaseDAO {
    private String head[] = {"序号", "餐品编号", "餐品类别", "餐品名称", "价格", "优惠价","库存","图片"};
    private Object[][] data = null;
    private int mark;
    private int id;
    private String buttonText;

    public GetDataFromDatabaseImpl(int mark, String buttonText) {
        this.buttonText = buttonText;
        this.mark = mark;
    }

    public GetDataFromDatabaseImpl(int mark) {
        this.mark = mark;
    }

    public GetDataFromDatabaseImpl(int mark, int id) {
        this.mark = mark;
        this.id =id;
    }
    public GetDataFromDatabaseImpl(){
    }

    public String[] getHead() {
        return head;
    }

    public void setHead(String[] head) {
        this.head = head;
    }

    public Object[][] getData() {
        return data;
    }

    public void setData(Object[][] data) {
        this.data = data;
    }


    /**
     * @方法说明 从数据库中表中取获取数据，存储到二维数据中（一行接一行）
     * @author Binqing
     * @date 2022/5/7 21:06
     * @param
     * @return java.lang.Object[][]
     */

    @Override
    public  Object[][] getDataFromDatabase() {
        //集合list 存放一条获取出来的记录
        java.util.List<Item> list = new ArrayList<>();
        Connection conn=null;
        String sql=null;
        Statement stmt = null;
        //通过mark 选择所要选择的sql语句
        if (mark==0){
            sql = "SELECT * FROM item";
        }
        if (mark==1){
            sql = "SELECT * FROM item where id"+"="+id;
        }
        if (mark>=10&&mark<=15){
            sql = "SELECT * FROM item where product_category"+"="+"'"+buttonText+"'";
        }

        ResultSet rs = null;
        try {
            conn = JDBCtil.getConnection();
            //获取执行sql的对象Statement
            stmt = conn.createStatement();

            //执行sql，获取结果集
            rs = stmt.executeQuery(sql);
            ////处理结果集
            while (rs.next()) {
                Item item = new Item();//创建一个item实例并赋值
                //获取每一行的字段数据，赋值给item
                item.setId(rs.getInt(1));
                item.setProduct_id(rs.getString(2));
                item.setPro_cate(rs.getString(3));
                item.setPro_name(rs.getString(4));
                item.setPrice(rs.getFloat(5));
                item.setPrefer_price(rs.getFloat(6));
                item.setStock(rs.getInt(7));
                item.setImg_url(rs.getString(8));
                list.add(item);//把item一条数据存放到集合中
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCtil.close(conn,stmt,null,rs);//关闭资源
        }
        // 把集合的数据（商品信息）转换成二维数组
        data = new Object[list.size()][head.length];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < head.length; j++) {
                data[i][0] = list.get(i).getId();
                data[i][1] = list.get(i).getProduct_id();
                data[i][2] = list.get(i).getPro_cate();
                data[i][3] = list.get(i).getPro_name();
                data[i][4] = list.get(i).getPrice();
                data[i][5] = list.get(i).getPrefer_price();
                data[i][6] = list.get(i).getStock();

                ImageIcon icon= new ImageIcon(list.get(i).getImg_url());//获取项目相对路径的图片
                icon.setImage(icon.getImage().getScaledInstance(150, 100, Image.SCALE_DEFAULT));//设置图片的尺寸
                data[i][7] =icon;

                /**
                 * 获取图片的三种方式
                 * 一：绝对路径获取：必须给出照片的绝对路径
                 eg：ImageIcon icon = new ImageIcon（"C:\Users\Acer\Desktop\77777\玫瑰.png"）
                 * 二：绝对路径
                 eg：ImageIcon icon= new ImageIcon(src/main/java/com/lanqiao/hamburg/image/dishes/两份鸡米花.jpg);
                 * 三：网络图片：给出照片的URL地址
                 eg：
                 ImageIcon icon = null;
                 icon = new ImageIcon(new URL("https://raw.githubusercontent.com/binqingqaq/Hamburg/master/%E9%A4%90%E5%93%81images/%E8%8C%89%E8%8E%89%E8%8A%B1.png"));
                 */
            }
        }
        return data;
    }
}
