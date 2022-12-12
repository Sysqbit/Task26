package com.example.inventorymanagement;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText inputEmail, inputPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Init
        inputEmail = findViewById(R.id.inputEmail);
        inputPassword = findViewById(R.id.inputPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(v->validateData());

    }

    private void validateData()
    {
        String email = inputEmail.getText().toString().trim();
        String password = inputPassword.getText().toString().trim();
        if (email.isEmpty())
        {
            inputEmail.setError("Enter Email");
            inputEmail.requestFocus();
            Helper.playVibrate();
            return;
        }
        if (password.isEmpty())
        {
            inputPassword.setError("Enter Password");
            inputPassword.requestFocus();
            Helper.playVibrate();
            return;
        }
        if (password.length()<7)
        {
            inputPassword.setError("Enter Valid Password");
            inputPassword.requestFocus();
            Helper.playVibrate();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            inputEmail.setError("Email is not Valid");
            inputEmail.requestFocus();
            Helper.playVibrate();
        }
        else
        {
            doLogin(email,password);
        }
    }

    private void doLogin(String email, String password) {
        btnLogin.setEnabled(false);
        sendToMain();

    }

        private void sendToMain(){
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finishAffinity();
        }



}
