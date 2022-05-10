package com.lanqiao.hamburg.entity;

import java.util.Objects;

/**
 * 数据库表 item的实体类
 */
public class Item {
    private int id;//序号
    private String product_id;//餐品编号
    private String pro_cate;//餐品种类
    private String pro_name;//菜品名称
    private Float price;//价格
    private Float prefer_price;//优惠价
    private int stock;//库存
    private String img_url;//图片路径
    private float cost_price;//成本价
    private String taste;
    private String specification;

    public Item(int id, String product_id, String pro_cate, String pro_name, Float price, Float prefer_price, int stock, String img_url) {
        this.id = id;
        this.product_id = product_id;
        this.pro_cate = pro_cate;
        this.pro_name = pro_name;
        this.price = price;
        this.prefer_price = prefer_price;
        this.stock = stock;
        this.img_url = img_url;
    }

    public Item() {

    }


    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getPro_cate() {
        return pro_cate;
    }

    public void setPro_cate(String pro_cate) {
        this.pro_cate = pro_cate;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getPrefer_price() {
        return prefer_price;
    }

    public void setPrefer_price(Float prefer_price) {
        this.prefer_price = prefer_price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public float getCost_price() {
        return cost_price;
    }

    public void setCost_price(float cost_price) {
        this.cost_price = cost_price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id &&
                stock == item.stock &&
                Float.compare(item.cost_price, cost_price) == 0 &&
                Objects.equals(product_id, item.product_id) &&
                Objects.equals(pro_cate, item.pro_cate) &&
                Objects.equals(pro_name, item.pro_name) &&
                Objects.equals(price, item.price) &&
                Objects.equals(prefer_price, item.prefer_price) &&
                Objects.equals(img_url, item.img_url) &&
                Objects.equals(specification, item.specification) &&
                Objects.equals(taste, item.taste);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product_id, pro_cate, pro_name, price, prefer_price, stock, img_url, cost_price, specification, taste);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", product_id='" + product_id + '\'' +
                ", pro_cate='" + pro_cate + '\'' +
                ", pro_name='" + pro_name + '\'' +
                ", price=" + price +
                ", prefer_price=" + prefer_price +
                ", stock=" + stock +
                ", img_url='" + img_url + '\'' +
                ", cost_price=" + cost_price +
                ", specification='" + specification + '\'' +
                ", taste='" + taste + '\'' +
                '}';
    }
}
