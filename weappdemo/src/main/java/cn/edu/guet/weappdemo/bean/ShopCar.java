package cn.edu.guet.weappdemo.bean;

import java.util.Objects;

/**
 * @version 1.0
 * @Author qin
 * @Date 2022/5/8 19:30
 */
public class ShopCar {
    private int colnum;

    public ShopCar(int colnum, int id, float price, int num, int user_id, String user_name, String title) {
        this.colnum = colnum;
        this.id = id;
        this.price = price;
        this.num = num;
        this.user_id = user_id;
        this.user_name = user_name;
        this.title = title;
    }

    private int id;
    private float price;

    public ShopCar() {

    }



    public int getColnum() {
        return colnum;
    }

    public void setColnum(int colnum) {
        this.colnum = colnum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShopCar shopCar = (ShopCar) o;
        return colnum == shopCar.colnum && id == shopCar.id && Float.compare(shopCar.price, price) == 0 && num == shopCar.num && user_id == shopCar.user_id && Objects.equals(user_name, shopCar.user_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(colnum, id, price, num, user_id, user_name);
    }

    @Override
    public String toString() {
        return "ShopCar{" +
                "colnum=" + colnum +
                ", id=" + id +
                ", price=" + price +
                ", num=" + num +
                ", user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                '}';
    }

    private int num;
    private int user_id;
    private String user_name;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String title;
}
