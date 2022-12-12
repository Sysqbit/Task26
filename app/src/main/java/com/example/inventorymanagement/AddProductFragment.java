package com.example.inventorymanagement;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.inventorymanagement.models.ModelBrand;
import com.example.inventorymanagement.models.ModelCategory;
import com.example.inventorymanagement.models.ModelLocation;
import com.example.inventorymanagement.models.ModelSize;
import com.google.android.material.textfield.TextInputLayout;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.util.ArrayList;
import java.util.List;

public class AddProductFragment extends Fragment {
    private List<ModelBrand> modelBrandList;
    private List<ModelCategory> modelCategoryList;
    private List<ModelSize> modelSizeList;
    private List<ModelLocation> modelLocationList;
    private List<ModelItem> modelItemList;
    private SearchableSpinner spinnerItem, spinnerBrand, spinnerCategory, spinnerSize, spinnerLocation, spinnerManufactureMonth, spinnerManufactureYear, spinnerExpireMonth, spinnerExpireYear;
    private EditText inputProductPrice, inputProductQuantity, inputProductBarcode;
    private TextInputLayout tilBarcode;
    private String itemName, brandName, categoryName, sizeName, locationName, price, quantity, barCode, manMonthName, manYearName, expMonthName, expYearName = "";
    private Button btnAddProduct;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_product, container, false);
        init(view);


        spinnerBrand.setTitle("Select Brand");
        spinnerCategory.setTitle("Select Category");
        spinnerSize.setTitle("Select Size");
        spinnerLocation.setTitle("Select Location");
        spinnerItem.setTitle("Select Item");
        spinnerManufactureMonth.setTitle("Select Manufacture Month");
        spinnerManufactureYear.setTitle("Select Manufacture Year");
        spinnerExpireMonth.setTitle("Select Expire Month");
        spinnerExpireYear.setTitle("Select Expire Year");


        setSpinner();

        btnAddProduct.setOnClickListener(v->validateData());

        return view;

    }



    private void init(View view) {
        modelBrandList = new ArrayList<>();
        modelCategoryList = new ArrayList<>();
        modelSizeList = new ArrayList<>();
        modelLocationList = new ArrayList<>();
        modelItemList = new ArrayList<>();
        spinnerBrand = view.findViewById(R.id.spinnerBrand);
        spinnerCategory = view.findViewById(R.id.spinnerCategory);
        spinnerSize = view.findViewById(R.id.spinnerSize);
        spinnerLocation = view.findViewById(R.id.spinnerLocation);
        spinnerItem = view.findViewById(R.id.spinnerItem);
        spinnerManufactureMonth = view.findViewById(R.id.spinnerManufactureMonth);
        spinnerManufactureYear = view.findViewById(R.id.spinnerManufactureYear);
        spinnerExpireMonth = view.findViewById(R.id.spinnerExpireMonth);
        spinnerExpireYear = view.findViewById(R.id.spinnerExpireYear);
        inputProductPrice = view.findViewById(R.id.inputProductPrice);
        inputProductQuantity = view.findViewById(R.id.inputProductQuantity);
        inputProductBarcode = view.findViewById(R.id.inputProductBarcode);
        tilBarcode = view.findViewById(R.id.tilBarcode);
        btnAddProduct = view.findViewById(R.id.btnAddProduct);
    }

    private void validateData() {
        price = inputProductPrice.getText().toString().trim();
        quantity = inputProductQuantity.getText().toString().trim();
        if (brandName==null || brandName.isEmpty()) {
            Toast.makeText(getContext(), "Select Brand", Toast.LENGTH_SHORT).show();
            Helper.playVibrate();
            return;
        }
        if (categoryName==null || categoryName.isEmpty()) {
            Toast.makeText(getContext(), "Select Category", Toast.LENGTH_SHORT).show();
            Helper.playVibrate();
            return;
        }
        if (sizeName==null || sizeName.isEmpty()) {
            Toast.makeText(getContext(), "Select Size", Toast.LENGTH_SHORT).show();
            Helper.playVibrate();
            return;
        }
        if (locationName==null || locationName.isEmpty()) {
            Toast.makeText(getContext(), "Select Location", Toast.LENGTH_SHORT).show();
            Helper.playVibrate();
            return;
        }
        if (itemName==null || itemName.isEmpty()) {
            Toast.makeText(getContext(), "Select Product Name", Toast.LENGTH_SHORT).show();
            Helper.playVibrate();
            return;
        }
        if (price.isEmpty()) {
            inputProductPrice.setError("Enter Price");
            inputProductPrice.requestFocus();
            Helper.playVibrate();
            return;
        }
        if (quantity.isEmpty()) {
            inputProductQuantity.setError("Enter Quantity");
            inputProductQuantity.requestFocus();
            Helper.playVibrate();
            return;
        }
        if (manMonthName==null || manMonthName.isEmpty()) {
            Toast.makeText(getContext(), "Select Manufacture Month", Toast.LENGTH_SHORT).show();
            Helper.playError();
            Helper.playVibrate();
            return;
        }
        if (manYearName==null || manYearName.isEmpty()) {
            Toast.makeText(getContext(), "Select Manufacture Year", Toast.LENGTH_SHORT).show();
            Helper.playVibrate();
            return;
        }
        if (expMonthName==null || expMonthName.isEmpty()) {
            Toast.makeText(getContext(), "Select Expire Month", Toast.LENGTH_SHORT).show();
            Helper.playVibrate();
            return;
        }
        if (expYearName==null || expYearName.isEmpty()) {
            Toast.makeText(getContext(), "Select Expire Year", Toast.LENGTH_SHORT).show();
            Helper.playVibrate();
        }
        else
        {
            Toast.makeText(getContext(), "product added successfully", Toast.LENGTH_SHORT).show();
        }
    }







    private void setSpinner() {
        ArrayList<String> manMonth = new ArrayList<>();
        ArrayList<String> manYear = new ArrayList<>();
        ArrayList<String> expMonth = new ArrayList<>();
        ArrayList<String> expYear = new ArrayList<>();
        ArrayList<String> selBrand = new ArrayList<>();
        ArrayList<String> selCategory = new ArrayList<>();
        ArrayList<String> selSize = new ArrayList<>();
        ArrayList<String> selLoc = new ArrayList<>();
        ArrayList<String> selProductName = new ArrayList<>();

        manMonth.add("January");
        manMonth.add("February");
        manMonth.add("March");
        manMonth.add("April");
        manMonth.add("May");
        manMonth.add("June");
        manMonth.add("July");
        manMonth.add("August");
        manMonth.add("September");
        manMonth.add("October");
        manMonth.add("November");
        manMonth.add("December");

        manYear.add("2024");
        manYear.add("2023");
        manYear.add("2022");
        manYear.add("2021");
        manYear.add("2020");
        manYear.add("2019");
        manYear.add("2018");
        manYear.add("2017");
        manYear.add("2016");
        manYear.add("2015");
        manYear.add("2014");
        manYear.add("2013");
        manYear.add("2012");

        expMonth.add("January");
        expMonth.add("February");
        expMonth.add("March");
        expMonth.add("April");
        expMonth.add("May");
        expMonth.add("June");
        expMonth.add("July");
        expMonth.add("August");
        expMonth.add("September");
        expMonth.add("October");
        expMonth.add("November");
        expMonth.add("December");


        expYear.add("2027");
        expYear.add("2026");
        expYear.add("2025");
        expYear.add("2024");
        expYear.add("2023");
        expYear.add("2022");
        expYear.add("2021");
        expYear.add("2020");
        expYear.add("2019");
        expYear.add("2018");
        expYear.add("2017");
        expYear.add("2016");
        expYear.add("2015");
        expYear.add("2014");
        expYear.add("2013");
        expYear.add("2012");


        selBrand.add("nokia");
        selBrand.add("iphone");
        selBrand.add("oppo");
        selBrand.add("ikea");


        selCategory.add("electronics");
        selCategory.add("mobile");
        selCategory.add("hardware");
        selCategory.add("furniture");


        selSize.add("up to 5 lbs");
        selSize.add("5-8 lbs");
        selSize.add("8-12 lbs");
        selSize.add("12-16 lbs");
        selSize.add("up to 16 lbs");
        selSize.add("16-20 lbs");
        selSize.add("20-24 lbs");
        selSize.add("24-28 lbs");
        selSize.add("28-32 lbs");


        selLoc.add("USA");
        selLoc.add("Serbia");
        selLoc.add("Greece");
        selLoc.add("Pakistan");
        selLoc.add("UAE");
        selLoc.add("Korea");
        selLoc.add("Kenya");


        selProductName.add("iphone 13pro");
        selProductName.add("iphone 13");
        selProductName.add("iphone X");
        selProductName.add("iphone XS MAX");
        selProductName.add("Nokia 11 12");
        selProductName.add("juicer machine");



        try {
            spinnerManufactureMonth.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, manMonth));
            spinnerManufactureYear.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, manYear));
            spinnerExpireMonth.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, expMonth));
            spinnerExpireYear.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, expYear));
            spinnerBrand.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item,selBrand));
            spinnerCategory.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item,selCategory));
            spinnerSize.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item,selSize));
            spinnerLocation.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item,selLoc));
            spinnerItem.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item,selProductName));

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        spinnerItem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                itemName = String.valueOf(adapterView.getItemAtPosition(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });


        spinnerLocation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                locationName =String.valueOf(adapterView.getItemAtPosition(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });


        spinnerSize.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                sizeName = String.valueOf(adapterView.getItemAtPosition(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });


        spinnerCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                categoryName = String.valueOf(adapterView.getItemAtPosition(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });


        spinnerBrand.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                brandName = String.valueOf(adapterView.getItemAtPosition(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinnerManufactureMonth.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                manMonthName = String.valueOf(adapterView.getItemAtPosition(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinnerManufactureYear.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                manYearName = String.valueOf(adapterView.getItemAtPosition(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinnerExpireMonth.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                expMonthName = String.valueOf(adapterView.getItemAtPosition(i));
            }
            @Override

            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinnerExpireYear.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                expYearName = String.valueOf(adapterView.getItemAtPosition(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


}
