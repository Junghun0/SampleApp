package com.example.amazon_app.model;

import android.text.TextUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Product implements Serializable {
//    private ArrayList<String> photoUrl;
    private String photoUrl1;
    private String photoUrl2;
    private String photoUrl3;
    private String photoUrl4;
    private String photoUrl5;
    private String title;
    private int price;
//    private ArrayList<Integer> stars;
//    private int stars1;
//    private int stars2;
//    private int stars3;
//    private int stars4;
//    private int stars5;
//    @Ignore
//    private ArrayList<String> options;
    private String detail;
    private String maker;

    public List<String> getPhotoUrl() {
        List<String> photoUrls = new ArrayList<>();
        if (!TextUtils.isEmpty(photoUrl1)){
            photoUrls.add(photoUrl1);
        }
        if (!TextUtils.isEmpty(photoUrl2)){
            photoUrls.add(photoUrl2);
        }
        if (!TextUtils.isEmpty(photoUrl3)){
            photoUrls.add(photoUrl3);
        }
        if (!TextUtils.isEmpty(photoUrl4)){
            photoUrls.add(photoUrl4);
        }
        if (!TextUtils.isEmpty(photoUrl5)){
            photoUrls.add(photoUrl5);
        }
        return photoUrls;
    }

    public String getPhotoUrl1() {
        return photoUrl1;
    }

    public void setPhotoUrl1(String photoUrl1) {
        this.photoUrl1 = photoUrl1;
    }

    public String getPhotoUrl2() {
        return photoUrl2;
    }

    public void setPhotoUrl2(String photoUrl2) {
        this.photoUrl2 = photoUrl2;
    }

    public String getPhotoUrl3() {
        return photoUrl3;
    }

    public void setPhotoUrl3(String photoUrl3) {
        this.photoUrl3 = photoUrl3;
    }

    public String getPhotoUrl4() {
        return photoUrl4;
    }

    public void setPhotoUrl4(String photoUrl4) {
        this.photoUrl4 = photoUrl4;
    }

    public String getPhotoUrl5() {
        return photoUrl5;
    }

    public void setPhotoUrl5(String photoUrl5) {
        this.photoUrl5 = photoUrl5;
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
                Objects.equals(photoUrl1, product.photoUrl1) &&
                Objects.equals(photoUrl2, product.photoUrl2) &&
                Objects.equals(photoUrl3, product.photoUrl3) &&
                Objects.equals(photoUrl4, product.photoUrl4) &&
                Objects.equals(photoUrl5, product.photoUrl5) &&
                Objects.equals(title, product.title) &&
                Objects.equals(detail, product.detail) &&
                Objects.equals(maker, product.maker);
    }

    @Override
    public int hashCode() {
        return Objects.hash(photoUrl1, photoUrl2, photoUrl3, photoUrl4, photoUrl5, title, price, detail, maker);
    }

    @Override
    public String toString() {
        return "Product{" +
                "photoUrl1='" + photoUrl1 + '\'' +
                ", photoUrl2='" + photoUrl2 + '\'' +
                ", photoUrl3='" + photoUrl3 + '\'' +
                ", photoUrl4='" + photoUrl4 + '\'' +
                ", photoUrl5='" + photoUrl5 + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", detail='" + detail + '\'' +
                ", maker='" + maker + '\'' +
                '}';
    }
}
