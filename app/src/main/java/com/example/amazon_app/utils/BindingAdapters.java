package com.example.amazon_app.utils;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bumptech.glide.Glide;
import com.example.amazon_app.fragment.ItemListFragment;
import com.example.amazon_app.model.Product;

import java.util.List;

public class BindingAdapters {

    @BindingAdapter("photoUrl")
    public static void loadImage(ImageView imageView, String imageUrl){
        Glide.with(imageView)
                .load(imageUrl)
                .into(imageView);
    }

    @BindingAdapter("refresh")
    public static void refresh(SwipeRefreshLayout swipeRefreshLayout, boolean isRefreshing){
        swipeRefreshLayout.setRefreshing(isRefreshing);
    }

    @BindingAdapter("items")
    public static void items(RecyclerView recyclerView, List<Product> products){
       ItemListFragment.ProductAdapter adapter = (ItemListFragment.ProductAdapter)recyclerView.getAdapter();
       adapter.setItems(products);
    }
}
