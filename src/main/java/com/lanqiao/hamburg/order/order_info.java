package com.lanqiao.hamburg.order;

import java.sql.Timestamp;
import java.util.Objects;

public class order_info {
    private String id;
    private String out_trade_on;
    private Timestamp order_time;
    private String transaction_id;
    private int item_id;

    public String getOut_trade_on() {
        return out_trade_on;
    }

    public void setOut_trade_on(String out_trade_on) {
        this.out_trade_on = out_trade_on;
    }

    private float item_price;
    private int amount;
    private float order_price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public order_info() {
    }

    public order_info(String id,int item_id, float item_price, int amount, float order_price, Timestamp order_time) {
        this.id = id;
        this.item_id = item_id;
        this.transaction_id = transaction_id;
        this.item_price = item_price;
        this.amount = amount;
        this.order_price = order_price;
        this.order_time = order_time;
    }

    public Timestamp getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Timestamp order_time) {
        this.order_time = order_time;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }


    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public float getItem_price() {
        return item_price;
    }

    public void setItem_price(float item_price) {
        this.item_price = item_price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getOrder_price() {
        return order_price;
    }

    public void setOrder_price(float order_price) {
        this.order_price = order_price;
    }

    @Override
    public String toString() {
        return "order_info{" +
                ", order_time=" + order_time +
                ", transaction_id='" + transaction_id + '\'' +
                ", item_id=" + item_id +
                ", item_price=" + item_price +
                ", amount=" + amount +
                ", order_price=" + order_price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        order_info that = (order_info) o;
        return item_id == that.item_id &&
                Float.compare(that.item_price, item_price) == 0 &&
                amount == that.amount &&
                Float.compare(that.order_price, order_price) == 0 &&
                Objects.equals(order_time, that.order_time) &&
                Objects.equals(transaction_id, that.transaction_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order_time, transaction_id, item_id, item_price, amount, order_price);
    }
}
