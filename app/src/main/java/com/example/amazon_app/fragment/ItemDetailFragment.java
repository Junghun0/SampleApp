package com.example.amazon_app.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.amazon_app.R;
import com.example.amazon_app.databinding.FragmentItemDetailBinding;
import com.example.amazon_app.databinding.ItemPhotoBinding;
import com.example.amazon_app.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ItemDetailFragment extends Fragment {

    public static final String KEY_PRODUCT = "PRODUCT";
    private Product mProduct;

    public ItemDetailFragment() {
        //메뉴를 가지고 있다고 알려준다.
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null){
            mProduct = (Product) getArguments().getSerializable(KEY_PRODUCT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_item_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FragmentItemDetailBinding binding = DataBindingUtil.bind(view);

        PhotoAdapter adapter = new PhotoAdapter(mProduct.getPhotoUrl());
        binding.viewPager.setAdapter(adapter);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.cart, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    private static class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder> {

        private List<String> mItems = new ArrayList<>();

        public PhotoAdapter(List<String> mItems) {
            this.mItems = mItems;
        }

        @NonNull
        @Override
        public PhotoAdapter.PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photo, parent, false);
            return new PhotoViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull PhotoAdapter.PhotoViewHolder holder, int position) {
            holder.binding.setImageUrl(mItems.get(position));
        }

        @Override
        public int getItemCount() {
            return mItems.size();
        }

        public class PhotoViewHolder extends RecyclerView.ViewHolder {
            ItemPhotoBinding binding;

            public PhotoViewHolder(@NonNull View itemView) {
                super(itemView);
                binding = DataBindingUtil.bind(itemView);
            }
        }
    }
}
