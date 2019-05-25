package com.example.amazon_app.model.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.amazon_app.model.Product;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends ViewModel {
    public MutableLiveData<List<Product>> products = new MutableLiveData<>();

    public MainViewModel(){
        List<Product> productList = new ArrayList<>();
        Product product = new Product();
        product.setDetail("detaildetaildetaildetaildetail");
        product.setMaker("makermakermakermakermakermaker");
        product.setPrice(1200000);
        product.setTitle("This is title!!This is title!!This is title!!This is title!!");
        productList.add(product);

        products.setValue(productList);
    }

}
