package com.example.amazon_app.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.example.amazon_app.R;
import com.example.amazon_app.databinding.ItemProductBinding;
import com.example.amazon_app.model.Product;
import com.example.amazon_app.model.viewmodels.MainViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ItemListFragment extends Fragment {


    public ItemListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_item_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        ProductAdapter adapter = new ProductAdapter(product -> {
            Toast.makeText(requireActivity(), "onclick!", Toast.LENGTH_SHORT).show();
        });
        recyclerView.setAdapter(adapter);

        MainViewModel viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        viewModel.products.observe(this, products -> adapter.setItems(products));
        viewModel.fetch();

    }

    private static class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>{
        private List<Product> mItems = new ArrayList<>();

        interface OnProductItemClickListener{
            void onProductItemClick(Product product);
        }
        OnProductItemClickListener mListener;


        public ProductAdapter(OnProductItemClickListener listener){
            mListener = listener;
        }

        public void setItems(List<Product> items){
            mItems = items;
            notifyDataSetChanged();
        }

        @NonNull
        @Override
        public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product,parent,false
            );
            ProductViewHolder productViewHolder = new ProductViewHolder(view);
            view.setOnClickListener(v -> mListener.onProductItemClick(mItems.get(productViewHolder.getAdapterPosition())));
            return productViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
            holder.binding.setProduct(mItems.get(position));
        }

        @Override
        public int getItemCount() {
            return mItems.size();
        }

        public static class ProductViewHolder extends RecyclerView.ViewHolder {
            ItemProductBinding binding;
            public ProductViewHolder(@NonNull View itemView) {
                super(itemView);
                binding = DataBindingUtil.bind(itemView);
            }
        }
    }


}
