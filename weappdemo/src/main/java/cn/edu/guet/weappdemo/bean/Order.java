package cn.edu.guet.weappdemo.bean;

import java.sql.Timestamp;
import java.util.Objects;

public class Order {
    private String id;
    private int mch_id;
    private String out_trade_no;
    private Timestamp order_time;
    private String transaction_id;
    private int userId;
    private int item_id;
    private float item_price;
    private int amount;
    private float order_price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMch_id() {
        return mch_id;
    }

    public void setMch_id(int mch_id) {
        this.mch_id = mch_id;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return mch_id == order.mch_id && transaction_id == order.transaction_id && item_id == order.item_id && Float.compare(order.item_price, item_price) == 0 && amount == order.amount && Float.compare(order.order_price, order_price) == 0 && Objects.equals(id, order.id) && Objects.equals(out_trade_no, order.out_trade_no) && Objects.equals(order_time, order.order_time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mch_id, out_trade_no, order_time, transaction_id, item_id, item_price, amount, order_price);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", mch_id=" + mch_id +
                ", out_trade_no='" + out_trade_no + '\'' +
                ", order_time=" + order_time +
                ", transaction_id=" + transaction_id +
                ", item_id=" + item_id +
                ", item_price=" + item_price +
                ", amount=" + amount +
                ", order_price=" + order_price +
                '}';
    }
}
