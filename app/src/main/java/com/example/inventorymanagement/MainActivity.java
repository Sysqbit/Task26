package com.example.inventorymanagement;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private boolean doublePressToExit = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        Fragment fragment = new DashboardFragment();
        setFragment(fragment);


        bottomNavigationView.setItemIconTintList(null);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Dashboard");

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        navigationView.setItemIconTintList(null);

        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            Fragment fragment1;
            switch (id){

                case R.id.miAddProduct:
                    fragment1 = new AddProductFragment();
                    setFragment(fragment1);
                    actionBar.setTitle("Add Product");
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;

                case R.id.miDashboard:
                    fragment1 = new DashboardFragment();
                    setFragment(fragment1);
                    actionBar.setTitle("Dashboard");
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;

                case R.id.miAboutUs:
                    sendToAboutUsActivity();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;

                case R.id.miProducts:
                    fragment1 = new ProductsFragment();
                    setFragment(fragment1);
                    actionBar.setTitle("Products");
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;

                case R.id.miContactUs:
                    sendToContactUsActivity();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;

                case R.id.miSellers:
                    fragment1 = new SellersFragment();
                    setFragment(fragment1);
                    actionBar.setTitle("Sellers");
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;

                case R.id.miAddSeller:
                    fragment1 = new AddSellerFragment();
                    setFragment(fragment1);
                    actionBar.setTitle("Add Seller");
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;

                case R.id.miLogout:
                    doLogout();
                    break;

                default:
                    Toast.makeText(this, "working on it", Toast.LENGTH_SHORT).show();

            }
            return false;

        });
    }


    public void setFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment).commit();
    }

    private void sendToAboutUsActivity() {
        startActivity(new Intent(getApplicationContext(), AboutUsActivity.class));
    }

    private void sendToContactUsActivity() {
        startActivity(new Intent(getApplicationContext(), ContactUsActivity.class));
    }

    @Override
    public void onBackPressed() {
        if (doublePressToExit)
            super.onBackPressed();
        Toast.makeText(this, "Press Again To Exit", Toast.LENGTH_SHORT).show();
        this.doublePressToExit = true;

        Handler handler = new Handler();
        handler.postDelayed(() -> doublePressToExit = false,2000);
    }

    private void doLogout()
    {
        sendToLogin();
    }

    public void sendToLogin()
    {
        Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finishAffinity();
    }

}