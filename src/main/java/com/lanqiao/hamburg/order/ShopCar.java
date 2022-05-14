package com.lanqiao.hamburg.order;

import java.util.Objects;

public class ShopCar {
    private int colnum;
    private int id;
    private float price;
    private int num;
    private int user_id;
    private String user_name;
    private String title;

    public int getColnum() {
        return colnum;
    }

    public void setColnum(int colnum) {
        this.colnum = colnum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShopCar shopCar = (ShopCar) o;
        return colnum == shopCar.colnum &&
                id == shopCar.id &&
                Float.compare(shopCar.price, price) == 0 &&
                num == shopCar.num &&
                user_id == shopCar.user_id &&
                Objects.equals(user_name, shopCar.user_name) &&
                Objects.equals(title, shopCar.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(colnum, id, price, num, user_id, user_name, title);
    }
}
