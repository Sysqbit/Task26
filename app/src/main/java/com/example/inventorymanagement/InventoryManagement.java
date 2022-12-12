package com.example.inventorymanagement;

import android.app.Application;

public class InventoryManagement extends Application {
    private static InventoryManagement instance;

    @Override
    public void onCreate() {
        super.onCreate();

        if (instance==null)
            instance = this;
    }

    public static InventoryManagement getInstance()
    {
        return instance;
    }
}
