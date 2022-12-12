package com.example.inventorymanagement;

import android.Manifest;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


public class AddSellerFragment extends Fragment {
    private ImageView ivSeller;
    private EditText inputSellerName, inputSellerEmail, inputSellerMobile, inputSellerMobile1, inputSellerAddress;
    private Button btnAddSeller;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_seller, container, false);
        init(view);
        btnAddSeller.setOnClickListener(v -> validateData());
        return view;
    }



    private void validateData() {
        String sellerName = inputSellerName.getText().toString().trim();
        String sellerEmail = inputSellerEmail.getText().toString().trim();
        String sellerContact = inputSellerMobile.getText().toString().trim();
        String sellerContact1 = inputSellerMobile1.getText().toString().trim();
        String sellerAddress = inputSellerAddress.getText().toString().trim();
        if (sellerName.isEmpty()) {
            inputSellerName.setError("Enter Name");
            inputSellerName.requestFocus();
            Helper.playVibrate();
            return;
        }
        if (sellerName.length() < 4) {
            inputSellerName.setError("Name Should Be Up To 4 Character");
            inputSellerName.requestFocus();
            Helper.playVibrate();
            return;
        }
        if (sellerContact.isEmpty()) {
            inputSellerMobile.setError("Enter Mobile Number");
            inputSellerMobile.requestFocus();
            Helper.playVibrate();
            return;
        }
        if (sellerContact.length() != 10) {
            inputSellerMobile.setError("Enter Valid Mobile Number");
            inputSellerMobile.requestFocus();
            Helper.playVibrate();
            return;
        }
        if (sellerAddress.isEmpty()) {
            inputSellerAddress.setError("Enter Address");
            inputSellerAddress.requestFocus();
            Helper.playVibrate();
            return;
        }
        if (sellerAddress.length() < 7) {
            inputSellerAddress.setError("Address Should Be Up To 7 Character");
            inputSellerAddress.requestFocus();
            Helper.playVibrate();
            return;
        }
        else {
            addSeller(sellerName, sellerEmail, sellerContact, sellerContact1, sellerAddress);
        }

    }

    private void addSeller(String sellerName, String sellerEmail, String sellerContact, String sellerContact1, String sellerAddress) {
        Toast.makeText(getContext(), "seller added successfully", Toast.LENGTH_SHORT).show();
    }




        private void init(View view) {
        ivSeller = view.findViewById(R.id.ivSeller);
        inputSellerName = view.findViewById(R.id.inputSellerName);
        inputSellerEmail = view.findViewById(R.id.inputSellerEmail);
        inputSellerMobile = view.findViewById(R.id.inputSellerMobile);
        inputSellerMobile1 = view.findViewById(R.id.inputSellerMobile1);
        inputSellerAddress = view.findViewById(R.id.inputSellerAddress);
        btnAddSeller = view.findViewById(R.id.btnAddSeller);

    }



}
