package com.lanqiao.hamburg.enti;

import java.util.Objects;

/**
 * @Author Lenovo
 * @Date 2022/5/6 13:11
 * @Version 1.0
 */
public class Orde {

    private int id;
    private int mch_id;
    private int  out_trade_no;
    private String order_time;
    private String transaction_id;
    private int user_id;
    private int  time_id;
    private int item_price;
    private int amount;
    private int order_price;

    public Orde() {
    }

    public Orde(int id, int mch_id, int  out_trade_no, String order_time, String transaction_id,int user_id,int  time_id,int item_price,int amount,int order_price) {
        this.id = id;
        this.mch_id = mch_id;
        this.out_trade_no = out_trade_no;
        this.order_time= order_time;
        this.transaction_id = transaction_id;
        this.user_id = user_id;
        this.time_id = time_id;
        this.item_price = item_price;
        this.amount= amount;
        this.order_price = order_price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMch_id() {
        return mch_id;
    }

    public void setMch_id(int mch_id) {
        this.mch_id = mch_id;
    }

    public int getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(int out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getOrder_time() {
        return order_time;
    }

    public void setOrder_time(String order_time) {
        this.order_time = order_time;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getTime_id() {
        return time_id;
    }

    public void setTime_id(int time_id) {
        this.time_id = time_id;
    }

    public int getItem_price() {
        return item_price;
    }

    public void setItem_price(int item_price) {
        this.item_price = item_price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getOrder_price() {
        return order_price;
    }

    public void setOrder_price(int order_price) {
        this.order_price = order_price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orde orde = (Orde) o;
        return id == orde.id &&
                mch_id == orde.mch_id &&
                out_trade_no == orde.out_trade_no &&
                user_id == orde.user_id &&
                time_id == orde.time_id &&
                item_price == orde.item_price &&
                amount == orde.amount &&
                order_price == orde.order_price &&
                Objects.equals(order_time, orde.order_time) &&
                Objects.equals(transaction_id, orde.transaction_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mch_id, out_trade_no, order_time, transaction_id, user_id, time_id, item_price, amount, order_price);
    }

    @Override
    public String toString() {
        return "Orde{" +
                "id=" + id +
                ", mch_id=" + mch_id +
                ", out_trade_no=" + out_trade_no +
                ", order_time='" + order_time + '\'' +
                ", transaction_id='" + transaction_id + '\'' +
                ", user_id=" + user_id +
                ", time_id=" + time_id +
                ", item_price=" + item_price +
                ", amount=" + amount +
                ", order_price=" + order_price +
                '}';
    }
}
