package com.lanqiao.hamburg.enti;

import java.util.Objects;

public class Sale {
    private int ID;
    private String title;
    private int  daily;
    private int month;
    private int  year;

    public Sale() {
    }

    public Sale(int id, String title, int  daily, int month, int  year) {
        this.ID = ID;
        this.title = title;
        this.daily = daily;
        this.month= month;
        this.year = year;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDaily() {
        return daily;
    }

    public void setDaily(int daily) {
        this.daily = daily;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sale sale = (Sale) o;
        return ID == sale.ID &&
                daily == sale.daily &&
                month == sale.month &&
                year == sale.year &&
                Objects.equals(title, sale.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, title, daily, month, year);
    }

    @Override
    public String toString() {
        return "Sale{" +
                "ID=" + ID +
                ", title='" + title + '\'' +
                ", daily=" + daily +
                ", month=" + month +
                ", year=" + year +
                '}';
    }
}

