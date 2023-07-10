package com.example.android_java_tutorial.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class ServiceExample extends Service {
    
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("ServiceExample", "onBind");
        return null;
    }

    @Override
    public void onCreate() {
        Log.e("ServiceExample", "onCreate ServiceExample");
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Log.e("ServiceExample", "onDestroy ServiceExample");
        super.onDestroy();
    }
}
