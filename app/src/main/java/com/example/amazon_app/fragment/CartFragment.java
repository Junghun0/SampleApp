package com.example.amazon_app.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.example.amazon_app.R;
import com.example.amazon_app.databinding.FragmentCartBinding;
import com.example.amazon_app.databinding.ItemCartBinding;
import com.example.amazon_app.model.CartItem;
import com.example.amazon_app.model.viewmodels.MainViewModel;

import java.util.ArrayList;
import java.util.List;

public class CartFragment extends Fragment {

    public CartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MainViewModel model = ViewModelProviders.of(requireActivity()).get(MainViewModel.class);
        FragmentCartBinding binding = DataBindingUtil.bind(view);
        binding.setViewModel(model);
        binding.setLifecycleOwner(this);

        CartAdapter adapter = new CartAdapter(null);
        binding.recyclerView.setAdapter(adapter);
    }

    public static class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder>{

        interface OnCartItemClickListener{
            void onItemClick(CartItem cartItem);
        }
        private OnCartItemClickListener mListener;

        public CartAdapter(OnCartItemClickListener listener){
            mListener = listener;
        }

        private List<CartItem> mItems = new ArrayList<>();

        public void setItems(List<CartItem> items){
            mItems = items;
            notifyDataSetChanged();
        }

        @NonNull
        @Override
        public CartAdapter.CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart,parent,false);
            CartViewHolder viewHolder = new CartViewHolder(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null){
                        CartItem item = mItems.get(viewHolder.getAdapterPosition());
                        mListener.onItemClick(item);
                    }
                }
            });
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull CartAdapter.CartViewHolder holder, int position) {
            CartItem cartItem = mItems.get(position);
            holder.binding.setCartItem(cartItem);
        }

        @Override
        public int getItemCount() {
            return mItems.size();
        }

        public class CartViewHolder extends RecyclerView.ViewHolder {
            ItemCartBinding binding;
            public CartViewHolder(@NonNull View itemView) {
                super(itemView);
                binding = DataBindingUtil.bind(itemView);
            }
        }
    }
}
