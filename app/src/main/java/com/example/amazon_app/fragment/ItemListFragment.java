package com.example.amazon_app.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.example.amazon_app.R;
import com.example.amazon_app.databinding.FragmentItemListBinding;
import com.example.amazon_app.databinding.ItemProductBinding;
import com.example.amazon_app.model.Product;
import com.example.amazon_app.model.viewmodels.MainViewModel;

import java.util.ArrayList;
import java.util.List;


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
        FragmentItemListBinding binding = DataBindingUtil.bind(view);
        MainViewModel viewModel = ViewModelProviders.of(requireActivity()).get(MainViewModel.class);
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
//            Bundle bundle = new Bundle();
//            bundle.putSerializable(ItemDetailFragment.KEY_PRODUCT, product);
//
//            //마찬가지로 nav_graph.xml 에 ItemDetailFragment()와 연결시켜두었다.필요없는 코드
//            /*requireActivity().getSupportFragmentManager()
//                    .beginTransaction()
//                    .replace(R.id.container, new ItemDetailFragment())
//                    .addToBackStack(null)
//                    .commit();*/
//
//            //navigation code!!
//            Navigation.findNavController(view).navigate(R.id.action_itemListFragment_to_itemDetailFragment, bundle);
        ProductAdapter adapter = new ProductAdapter(item -> {
            viewModel.addCart(item);
        });
        recyclerView.setAdapter(adapter);

        /*->databinding adapter 를 사용해 마찬가지로 코드를 줄였다.
        //Data set
        viewModel.products.observe(this, products -> {
            adapter.setItems(products);
        });
        ->databinding adapter를 사용해 xml에서 isrefreshing을 observe 하고 있다.
        viewModel.isRefreshing.observe(this, isRefreshing -> {
            binding.swipeRefreshLayout.setRefreshing(isRefreshing);
        });*/

        //swiperefreshlayout
        binding.swipeRefreshLayout.setOnRefreshListener(() -> {
            viewModel.fetch();//-> data의 변경이 있을 때 새로고침 끔
        });

        //searchView
        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //searchView의 내용으로 검색을 수행할 때 호출됨
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //서치뷰의 글자가 변경될 때마다 호출됨
                viewModel.search(newText);
                return true;
            }
        });

        //Data 받아오기
        viewModel.fetch();

    }

    public static class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>{
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
