package com.example.amazon_app.model.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.amazon_app.model.Product;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends ViewModel {
    public MutableLiveData<List<Product>> products = new MutableLiveData<>();
    private static final String TAG = "FirebaseFireStore!";

    public void fetch(){
        ArrayList<Product> dummyList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            Product product1 = new Product();
            ArrayList<String> photoUrls = new ArrayList<>();
            photoUrls.add("https://m.media-amazon.com/images/I/61iVOmuO1pL._AC_UL872_QL65_.jpg");
            photoUrls.add("https://images-na.ssl-images-amazon.com/images/I/614XgOF31AL._SL1024_.jpg");
            photoUrls.add("https://images-na.ssl-images-amazon.com/images/I/51OjlqFbhTL._SL1024_.jpg");
            product1.setPrice(2990000);
            dummyList.add(product1);
        }
        products.setValue(dummyList);
//        FirebaseFirestore.getInstance().collection("item")
//                .get()
//                .addOnCompleteListener(task -> {
//                    if (task.isSuccessful() && task.getResult() != null) {
//                        List<Product> productList = task.getResult().toObjects(Product.class);
//                        products.setValue(productList);
//                    } else {
//                        Log.w(TAG, "Error getting documents.", task.getException());
//                    }
//                });
    }

}
