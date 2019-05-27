package com.example.amazon_app.model.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.amazon_app.model.CartItem;
import com.example.amazon_app.model.Product;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends ViewModel {
    private static final String TAG = "FirebaseFireStore!";
    private List<Product> products = new ArrayList<>();
    public MutableLiveData<List<Product>> filteredProducts = new MutableLiveData<>();
    public MutableLiveData<Boolean> isRefreshing = new MutableLiveData<>();
    public MutableLiveData<List<CartItem>> cart = new MutableLiveData<>();

    public MainViewModel(){
        isRefreshing.setValue(false);
        cart.setValue(new ArrayList<>());
    }

    public void fetch(){
        isRefreshing.setValue(true);
        ArrayList<Product> dummyList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Product product1 = new Product();
            ArrayList<String> photoUrl = new ArrayList<>();
            photoUrl.add("https://m.media-amazon.com/images/I/61iVOmuO1pL._AC_UL872_QL65_.jpg");
            photoUrl.add("https://images-na.ssl-images-amazon.com/images/I/614XgOF31AL._SL1024_.jpg");
            photoUrl.add("https://images-na.ssl-images-amazon.com/images/I/51OjlqFbhTL._SL1024_.jpg");
            product1.setPrice(2990000);
            product1.setPhotoUrl(photoUrl);
            product1.setTitle("Test title");
            dummyList.add(product1);
        }
        products = dummyList;
        filteredProducts.setValue(dummyList);
        isRefreshing.setValue(false);
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

    public void search(String query) {
        List<Product> productList = products;

        List<Product> filteredList = new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            Product product = productList.get(i);
            if (product.getTitle().toLowerCase().trim().contains(query.toLowerCase().trim())){
                filteredList.add(product);
            }
        }
        filteredProducts.setValue(filteredList);
    }

    public void addCart(Product item){
        cart.getValue().add(new CartItem(item,1));
        cart.setValue(cart.getValue());
    }

    public void removeCart(Product item){
        cart.getValue().remove(item);
        cart.setValue(cart.getValue());
    }
}
