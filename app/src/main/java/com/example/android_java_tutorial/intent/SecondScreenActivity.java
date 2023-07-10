package com.example.android_java_tutorial.Intent;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android_java_tutorial.R;

public class SecondScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);

        // TODO: switch FirstScreenActivity
        findViewById(R.id.BtnSecondScreen).setOnClickListener(v -> {
            Intent intentActivity = new Intent(SecondScreenActivity.this, FirstScreenActivity.class);
            startActivity(intentActivity);
            finish();
        });
    }
}