package com.example.inventorymanagement;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ContactUsActivity extends AppCompatActivity {
    private ImageView btnWhatsapp, btnFacebook, btnInstagram,btnTwitter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        init();


        btnWhatsapp.setOnClickListener(v -> {
            whatsapp();
        });

        btnFacebook.setOnClickListener(v -> {
            facebook();
        });

        btnTwitter.setOnClickListener(v -> {
            twitter();
        });

    }

    private void twitter()
    {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/"+getString(R.string.twitter_username))));
    }



    private void facebook()
    {
        String url = "fb://page/"+getString(R.string.facebook_username);
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        } catch(Exception e) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/"+getString(R.string.facebook_username))));
        }
    }

    private void whatsapp()
    {
        String contact = getString(R.string.owner_whatsapp_number);
        String url = "https://api.whatsapp.com/send?phone="+contact;
        try {
            PackageManager packageManager = getPackageManager();
            packageManager.getPackageInfo("com.whatsapp",PackageManager.GET_ACTIVITIES);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);
        }
        catch (PackageManager.NameNotFoundException e)
        {
            Toast.makeText(getApplicationContext(), "Whatsapp not installed in your phone", Toast.LENGTH_SHORT).show();
        }
    }


    private void init()
    {
        btnWhatsapp = findViewById(R.id.btnWhatsapp);
        btnFacebook = findViewById(R.id.btnFacebook);
        btnTwitter = findViewById(R.id.btnTwitter);


    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}


