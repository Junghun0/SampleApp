package com.example.amazon_app.utils;

import androidx.room.TypeConverter;

import java.util.ArrayList;

public class MyTypeConverts {
    @TypeConverter
    public String fromPhotoUrls(ArrayList<String> photoUrls){
        String genreIds = "";
        for (String i : photoUrls){
            genreIds += " " + i;
        }
        return genreIds;
    }

    @TypeConverter
    public ArrayList<String> stringToArrayList(String photoUrls){
        ArrayList<String> list = new ArrayList<>();

        String[] array = photoUrls.split(",");

        for (String s : array){
            if (!s.isEmpty()){
                list.add(s);
            }
        }
        return list;
    }
}
