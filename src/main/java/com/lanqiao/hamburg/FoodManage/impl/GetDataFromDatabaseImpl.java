package com.lanqiao.hamburg.FoodManage.impl;



import com.lanqiao.hamburg.Interface.dao.GetDataFromDatabaseDAO;
import com.lanqiao.hamburg.Tools.JDBCtil;
import com.lanqiao.hamburg.entity.Item;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

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


    @Override
    public  Object[][] getDataFromDatabase() {
        java.util.List<Item> list = new ArrayList<Item>();
        Connection conn=null;
        String sql=null;
        Statement stmt = null;
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
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Item item = new Item();
                item.setId(rs.getInt(1));
                item.setProduct_id(rs.getString(2));
                item.setPro_cate(rs.getString(3));
                item.setPro_name(rs.getString(4));
                item.setPrice(rs.getFloat(5));
                item.setPrefer_price(rs.getFloat(6));
                item.setStock(rs.getInt(7));
                item.setImg_url(rs.getString(8));
                list.add(item);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
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
                data[i][7] = list.get(i).getImg_url();
                //ImageIcon imageIcon = new ImageIcon(getClass().getResource("/com/sad/面板/img/dishes/兰花.png"));
               // ImageIcon imageIcon = new ImageIcon(getClass().getResource("/com/sad/面板/img/dishes/兰花.png"));
                //https://github.com/binqingqaq/Hamburg/blob/master/%E9%A4%90%E5%93%81images/%E5%85%B0%E8%8A%B1.png
                //https://avatar.csdnimg.cn/3/F/F/3_toto1297488504_1548903051.jpg
          /*      ImageIcon icon = null;
                try {
                    icon = new ImageIcon(new URL("https://raw.githubusercontent.com/binqingqaq/Hamburg/master/%E9%A4%90%E5%93%81images/%E8%8C%89%E8%8E%89%E8%8A%B1.png"));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }*/

              //  ImageIcon imageIcon = new ImageIcon( list.get(i).getImg_url());

                //String url_dishes = "\""+list.get(i).getImg_url()+"\"";
             //   String url_dishes = list.get(i).getImg_url();
               // System.out.println( url_dishes);


               // String path = "src/main/java/com/lanqiao/hamburg/image/dishes/两份鸡米花.jpg";
               // System.out.println(ClassLoader.getSystemResource(path));
                ImageIcon icon= new ImageIcon(list.get(i).getImg_url());
                //ImageIcon icon= new ImageIcon(path);
                     //   new ImageIcon(ClassLoader.getSystemResource(path));


                /*try {


                    URL url1 = new URL("https://i.postimg.cc/yYdYbMX1/image.png");*/
                  //  icon = new ImageIcon(this.getClass().getResource());


                //imageIcon.setImage(imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
                icon.setImage(icon.getImage().getScaledInstance(150, 100, Image.SCALE_DEFAULT));
                //icon.setImage(imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
                data[i][7] = icon;

                //System.out.println(data[i][7]);
            }
        }
        return data;
    }
}
