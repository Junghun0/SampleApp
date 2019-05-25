package com.example.amazon_app.model;

import java.util.List;
import java.util.Map;

public class Product {
    private List<String> photoUrl;
    private String title;
    private int price;
    private Map<String, Integer> stars;
    private List<String> options;
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

    public List<String> getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(List<String> photoUrl) {
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

    public void setStars(Map<String, Integer> stars) {
        this.stars = stars;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
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
