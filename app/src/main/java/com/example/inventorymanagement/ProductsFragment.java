package com.example.inventorymanagement;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.shimmer.ShimmerFrameLayout;



public class ProductsFragment extends Fragment {

    private RecyclerView recyclerView;
    private EditText inputSearch;
    private ShimmerFrameLayout shimmerProduct;
    private CardView cvSearchProduct;



    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_products, container, false);
        inputSearch = view.findViewById(R.id.inputSearchProduct);
        recyclerView = view.findViewById(R.id.rvProducts);
        shimmerProduct = view.findViewById(R.id.shimmerProduct);
        cvSearchProduct = view.findViewById(R.id.cvSearchProduct);
        cvSearchProduct.setVisibility(View.GONE);
        shimmerProduct.startShimmer();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        String arr[]={"Iphone 13 pro", "Ipad 7", "Oppo a53"};

        recyclerView.setAdapter(new AdapterProduct(arr));

        shimmerProduct.stopShimmer();
        shimmerProduct.setVisibility(View.GONE);

        setHasOptionsMenu(true);

        return view;
    }
}