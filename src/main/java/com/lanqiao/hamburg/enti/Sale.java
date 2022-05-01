package com.lanqiao.hamburg.enti;

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

}

