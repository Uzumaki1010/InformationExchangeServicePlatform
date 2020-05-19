package com.example.informationexchangeserviceplatform.data;

public class Book {
    private String title;
    private String pay;
    private int coverResourceID;

    public Book(String title, String pay, int coverResourceID) {
        this.title = title;
        this.pay = pay;
        this.coverResourceID = coverResourceID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public int getCoverResourceID() {
        return coverResourceID;
    }

    public void setCoverResourceID(int coverResourceID) {
        this.coverResourceID = coverResourceID;
    }
}
