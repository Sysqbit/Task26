package com.example.inventorymanagement;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.shimmer.ShimmerFrameLayout;


public class SellersFragment extends Fragment {
    private RecyclerView recyclerView;
    private Menu menu;
    private ShimmerFrameLayout shimmerFrameLayout;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_sellers, container, false);
        init(view);


        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        String arr[]={"haseeb", "malik", "sultan"};

        recyclerView.setAdapter(new AdapterSeller(arr));

        shimmerFrameLayout.stopShimmer();
        shimmerFrameLayout.setVisibility(View.GONE);

        setHasOptionsMenu(true);
        return view;
    }

    private void init(View view)
    {
        recyclerView = view.findViewById(R.id.rvSeller);
        shimmerFrameLayout = view.findViewById(R.id.shimmerFrameLayout);
    }

}
