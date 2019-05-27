package com.example.amazon_app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price &&
                Objects.equals(photoUrl, product.photoUrl) &&
                Objects.equals(title, product.title) &&
                Objects.equals(stars, product.stars) &&
                Objects.equals(options, product.options) &&
                Objects.equals(detail, product.detail) &&
                Objects.equals(maker, product.maker);
    }

    @Override
    public int hashCode() {
        return Objects.hash(photoUrl, title, price, stars, options, detail, maker);
    }
}
