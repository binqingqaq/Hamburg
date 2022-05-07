package com.lanqiao.hamburg.Supply;

import java.util.Objects;

public class Item_stock {
    private int id;
    private int stock;
    private String item_id;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item_stock that = (Item_stock) o;
        return id == that.id && stock == that.stock && item_id == that.item_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, stock, item_id);
    }

    @Override
    public String toString() {
        return "Item_stock{" +
                "id=" + id +
                ", stock=" + stock +
                ", item_id=" + item_id +
                '}';
    }

}