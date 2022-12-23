package com.example.inventorymanagement;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;

public class AddAdminFragment extends Fragment {
    private ImageView ivAdmin;
    private EditText inputAdminName, inputPassword,inputAdminEmail;
    private Button btnAddAdmin;
    private String[] storagePermission;
    private Uri filePath;
    private ArrayList<String> list;
    private int positionId;
    private String currentAdminPassword,name,email,password;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_add_admin, container, false);

        init(view);

        list.add("Admin");
        list.add("Manager");
        list.add("Helper");


        ivAdmin.setOnClickListener(v->chooseImage());
        btnAddAdmin.setOnClickListener(v->validateData());
        return view;
    }

    private void chooseImage()
    {
        if (checkStoragePermission())
        {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent,200);
        }
        else
            requestStoragePermission();
    }

    private boolean checkStoragePermission()
    {
        boolean permission = ContextCompat.checkSelfPermission(getContext(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
        return permission;
    }

    private void requestStoragePermission()
    {
        ActivityCompat.requestPermissions(getActivity(),storagePermission,100);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length>0)
        {
            boolean permission = grantResults[0] == PackageManager.PERMISSION_GRANTED;
            if (permission)
            {
                Toast.makeText(getContext(), "Permission Granted", Toast.LENGTH_SHORT).show();
                chooseImage();
            }
            else
                Toast.makeText(getContext(), "Permission Declined", Toast.LENGTH_SHORT).show();
        }
    }

    private void validateData()
    {
        name = inputAdminName.getText().toString().trim();
        email = inputAdminEmail.getText().toString().trim();
        password = inputPassword.getText().toString().trim();
        if (name.isEmpty())
        {
            inputAdminName.setError("Enter Name");
            inputAdminName.requestFocus();
            Helper.playError();
            Helper.playVibrate();
            return;
        }
        if (name.length()<3 || name.length()> 30)
        {
            inputAdminName.setError("Invalid Name Length");
            inputAdminName.requestFocus();
            Helper.playVibrate();
            Helper.playError();
            return;
        }
        if (email.isEmpty())
        {
            inputAdminEmail.setError("Enter Email");
            inputAdminEmail.requestFocus();
            Helper.playError();
            Helper.playVibrate();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            inputAdminEmail.setError("Enter Valid Email");
            inputAdminEmail.requestFocus();
            Helper.playError();
            Helper.playVibrate();
            return;
        }
        if (password.isEmpty())
        {
            inputPassword.setError("Enter Password");
            inputPassword.requestFocus();
            Helper.playVibrate();
            Helper.playError();
            return;
        }
        if (password.length()<7)
        {
            inputPassword.setError("Password Should Be Greater Than 7 Character");
            inputPassword.requestFocus();
            Helper.playError();
            Helper.playVibrate();
            return;
        }
        if (positionId == -1 || positionId < 0 || String.valueOf(positionId).isEmpty())
        {
            Toast.makeText(getContext(),"Select Position",Toast.LENGTH_SHORT).show();
            Helper.playVibrate();
            Helper.playSuccess();
        }
        else
        {
            Toast.makeText(getContext(),"Field must be complete",Toast.LENGTH_SHORT).show();
        }
    }




    private void init(View view)
    {
        ivAdmin = view.findViewById(R.id.ivAdmin);
        inputAdminName = view.findViewById(R.id.inputAdminName);
        inputPassword = view.findViewById(R.id.inputPassword);
        inputAdminEmail = view.findViewById(R.id.inputAdminEmail);
        btnAddAdmin = view.findViewById(R.id.btnAddAdmin);
        storagePermission = new String[]{Manifest.permission.READ_EXTERNAL_STORAGE};
        list = new ArrayList<>();
    }



}
