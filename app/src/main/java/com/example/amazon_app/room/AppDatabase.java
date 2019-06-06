package com.example.amazon_app.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.amazon_app.model.CartItem;
import com.example.amazon_app.utils.MyTypeConverts;

@Database(entities = {CartItem.class}, version = 1, exportSchema = false)
@TypeConverters({MyTypeConverts.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract CartItemDao cartItemDao();
}
