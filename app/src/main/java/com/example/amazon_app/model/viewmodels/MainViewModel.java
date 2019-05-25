package com.example.amazon_app.model.viewmodels;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.amazon_app.model.Product;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

public class MainViewModel extends ViewModel {
    public MutableLiveData<List<Product>> products = new MutableLiveData<>();
    private static final String TAG = "FirebaseFireStore!";

    public Product selectedProduct;

    public void fetch(){
        FirebaseFirestore.getInstance().collection("item")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful() && task.getResult() != null) {
                        List<Product> productList = task.getResult().toObjects(Product.class);
                        products.setValue(productList);
                    } else {
                        Log.w(TAG, "Error getting documents.", task.getException());
                    }
                });
    }

}
