package com.example.amazon_app.model.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Room;

import com.example.amazon_app.model.CartItem;
import com.example.amazon_app.model.Product;
import com.example.amazon_app.room.AppDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private static final String TAG = "FirebaseFireStore!";
    private List<Product> products = new ArrayList<>();
    public MutableLiveData<List<Product>> filteredProducts = new MutableLiveData<>();
    public MutableLiveData<Boolean> isRefreshing = new MutableLiveData<>();
    public MutableLiveData<List<CartItem>> cart = new MutableLiveData<>();

    private AppDatabase mDb;

    public MainViewModel(@NonNull Application application) {
        super(application);
        isRefreshing.setValue(false);
        mDb = Room.databaseBuilder(application,
                AppDatabase.class, "database-name")
                .allowMainThreadQueries() // MainThread에서 DB 사용 가능
                .build();

        cart.setValue(mDb.cartItemDao().getCartItems());
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
            product1.setPhotoUrl1("https://m.media-amazon.com/images/I/61iVOmuO1pL._AC_UL872_QL65_.jpg");
            product1.setPhotoUrl2("https://images-na.ssl-images-amazon.com/images/I/614XgOF31AL._SL1024_.jpg");
            product1.setPhotoUrl3("https://images-na.ssl-images-amazon.com/images/I/51OjlqFbhTL._SL1024_.jpg");
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
        /*
        cart.getValue().add(new CartItem(item,1));
        cart.setValue(cart.getValue());
        */
        CartItem cartItem = new CartItem();
        cartItem.setCount(1);
        //room 사용한 코드!
        mDb.cartItemDao().insertAll(cartItem);
        cart.setValue(mDb.cartItemDao().getCartItems());
    }

//    public void removeCart(Product item){
//        cart.getValue().remove(item);
//        cart.setValue(cart.getValue());
//    }

    //viewModel 이 파괴될때 호출되는 함
    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
