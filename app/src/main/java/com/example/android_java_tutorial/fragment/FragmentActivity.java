package com.example.android_java_tutorial.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.android_java_tutorial.R;

public class FragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
    }
}