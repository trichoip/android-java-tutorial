package com.example.android_java_tutorial.Intent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android_java_tutorial.R;

public class FirstScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);
        // ! lưu ý nếu muốn lấy id nào thì phải setContentView chứa id đó trước
        Button button = findViewById(R.id.BtnFirstScreen);


        // TODO: switch SecondScreenActivity
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // * nên dùng kiểu này -> FirstScreenActivity.this
                // * nếu ở ngoài hàm onClick() thì có thể dùng this hoặc FirstScreenActivity.this
                // * nếu ở trong hàm onClick() thì chỉ có thể dùng FirstScreenActivity.this vì this ở trong onClick() là View.OnClickListener()
                Intent intent = new Intent(FirstScreenActivity.this, SecondScreenActivity.class);
                startActivity(intent);
                finish();
            }
        });


        // TODO: open Url
        findViewById(R.id.BtnUrl).setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.fb.com/"));
            startActivity(intent);
            finish();
        });


    }
}