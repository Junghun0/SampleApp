package com.example.amazon_app.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.amazon_app.model.CartItem;

import java.util.List;

@Dao
public interface CartItemDao {
    @Query("SELECT * FROM cartitem")
    List<CartItem> getCartItems();

    @Insert
    void insertAll(CartItem ... cartItems);
}
