package com.example.amazon_app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Product implements Serializable {
    private ArrayList<String> photoUrl;
    private String title;
    private int price;
    private HashMap<String, Integer> stars;
    private ArrayList<String> options;
    private String detail;
    private String maker;

    @Override
    public String toString() {
        return "Product{" +
                "photoUrl=" + photoUrl +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", stars=" + stars +
                ", options=" + options +
                ", detail='" + detail + '\'' +
                ", maker='" + maker + '\'' +
                '}';
    }

    public ArrayList<String> getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(ArrayList<String> photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Map<String, Integer> getStars() {
        return stars;
    }

    public void setStars(HashMap<String, Integer> stars) {
        this.stars = stars;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }
}
