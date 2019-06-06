package com.example.amazon_app.utils;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bumptech.glide.Glide;
import com.example.amazon_app.fragment.CartFragment;
import com.example.amazon_app.fragment.ItemListFragment;
import com.example.amazon_app.model.CartItem;
import com.example.amazon_app.model.Product;

import java.util.List;

public class BindingAdapters {

    @BindingAdapter("photoUrl")
    public static void loadImage(ImageView imageView, String imageUrl) {
        Glide.with(imageView)
                .load(imageUrl)
                .into(imageView);
    }

    @BindingAdapter("refresh")
    public static void refresh(SwipeRefreshLayout swipeRefreshLayout, boolean isRefreshing) {
        swipeRefreshLayout.setRefreshing(isRefreshing);
    }

    @BindingAdapter("items")
    public static void items(RecyclerView recyclerView, List<Product> products) {
        if (products != null){
            ItemListFragment.ProductAdapter adapter = (ItemListFragment.ProductAdapter) recyclerView.getAdapter();
            adapter.setItems(products);
        }
    }

    @BindingAdapter("cart")
    public static void cart(RecyclerView recyclerView, List<CartItem> items){
        if (items != null){
            CartFragment.CartAdapter adapter = (CartFragment.CartAdapter) recyclerView.getAdapter();
            adapter.setItems(items);
        }
    }

    @BindingAdapter("count")
    public static void count(TextView textView, List<CartItem> products) {
        textView.setText("수량 : " + products.size());
    }

    @BindingAdapter("price")
    public static void price(TextView textView, List<CartItem> products) {
        int sum = 0;
        for (CartItem cartItem : products) {
            sum += (cartItem.getProduct().getPrice() * cartItem.getCount());
        }
        textView.setText("가격 : " + sum);
    }
}
