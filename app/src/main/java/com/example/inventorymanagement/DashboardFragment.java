package com.example.inventorymanagement;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment implements View.OnClickListener{
    private BarChart barDailySales;
    private ArrayList<BarEntry> listDailySales;
    private String token;
    private TextView tvProductsCount,tvMoreProducts,tvTodaysSaleCount,tvMoreTodaysSale,tvBrandsCount,tvMoreBrands,tvNoticeCount,tvMoreNotice,tvExpiringCount,tvMoreExpiring,tvExpiredCount,tvMoreExpired;
    private ActionBar actionBar;
    private Toolbar toolbar;


    @SuppressLint("MissingInflatedId")
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_dashborad, container, false);
        init(view);
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        tvMoreProducts.setOnClickListener(this);
        tvMoreTodaysSale.setOnClickListener(this);
        tvMoreBrands.setOnClickListener(this);
        tvMoreNotice.setOnClickListener(this);
        tvMoreExpiring.setOnClickListener(this);
        tvMoreExpired.setOnClickListener(this);

        return view;
    }

    private void init(View view)
    {
        barDailySales = view.findViewById(R.id.barDailySales);
        tvProductsCount = view.findViewById(R.id.tvProductsCount);
        tvMoreProducts = view.findViewById(R.id.tvMoreProducts);
        tvTodaysSaleCount = view.findViewById(R.id.tvTodaysSaleCount);
        tvMoreTodaysSale = view.findViewById(R.id.tvMoreTodaysSale);
        tvBrandsCount = view.findViewById(R.id.tvBrandsCount);
        tvMoreBrands = view.findViewById(R.id.tvMoreBrands);
        tvNoticeCount = view.findViewById(R.id.tvNoticeCount);
        tvMoreNotice = view.findViewById(R.id.tvMoreNotice);
        tvExpiringCount = view.findViewById(R.id.tvExpiringCount);
        tvMoreExpiring = view.findViewById(R.id.tvMoreExpiring);
        tvExpiredCount = view.findViewById(R.id.tvExpiredCount);
        tvMoreExpired = view.findViewById(R.id.tvMoreExpired);


    }


    @Override
    public void onClick(View view) {
        /*int id = view.getId();
        Fragment fragment;
        switch (id)
            {
                case R.id.tvMoreProducts:
                    fragment = new ProductsFragment();
                    actionBar.setTitle("Products");
                    setFragment(fragment);
                    break;
                case R.id.tvMoreTodaysSale:
                    fragment = new SalesTodayFragment();
                    actionBar.setTitle("Today Sales");
                    setFragment(fragment);
                    break;
                case R.id.tvMoreNotice:
                    fragment = new ProductsNoticeFragment();
                    actionBar.setTitle("Products Notice");
                    setFragment(fragment);
                    break;
                case R.id.tvMoreExpiring:
                    fragment = new ExpiringProductsFragment();
                    actionBar.setTitle("Expiring Products");
                    setFragment(fragment);
                    break;
                case R.id.tvMoreExpired:
                    fragment = new ExpiredProductsFragment();
                    actionBar.setTitle("Expired Products");
                    setFragment(fragment);
                    break;
            }*/
        }



    private void setFragment(Fragment fragment)
    {
        getChildFragmentManager().beginTransaction().replace(R.id.frameLayout,fragment).commit();
    }
}
