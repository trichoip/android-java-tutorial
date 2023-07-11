package com.example.android_java_tutorial;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.android_java_tutorial.Animation.AnimationActivity;
import com.example.android_java_tutorial.Intent.FirstScreenActivity;
import com.example.android_java_tutorial.RecyclerView.RecyclerViewActivity;
import com.example.android_java_tutorial.SQLite.SQLiteActivity;
import com.example.android_java_tutorial.SharedPreferences.SharedPreferenceActivity;
import com.example.android_java_tutorial.WebApiJson.WebApiActivity;
import com.example.android_java_tutorial.fragment.BackstackFragmentActivity;
import com.example.android_java_tutorial.fragment.FragmentActivity;
import com.example.android_java_tutorial.listview.ListViewActivity;
import com.example.android_java_tutorial.service.ServiceExample;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // TODO: Log
        Log.e(TAG, "Hello World");
        Log.v(TAG, "Hello World");
        Log.d(TAG, "Hello World");
        Log.i(TAG, "Hello World");
        Log.w(TAG, "Hello World");
        Log.wtf(TAG, "Hello World");


        // TODO: setContentView
        // * setContentView trên 1 thì nó lấy cái cuối cùng
        // * R.layout.view_linear_layout -> R là folder res -> layout là folder layout -> view_linear_layout là file xml
        setContentView(R.layout.activity_main);


        // TODO: chạy Service
        Intent intentService = new Intent(this, ServiceExample.class);
        startService(intentService);
//         stopService(intentService);


        // TODO: Event Click
        // ! lưu ý nếu muốn lấy id nào thì phải setContentView chứa id đó trước
        findViewById(R.id.btn_click_log).setOnClickListener(v -> {
            Log.e(TAG, "Button Clicked");
        });


        // TODO: Intent
        findViewById(R.id.BtnIntent).setOnClickListener(v -> {
            // * chuyển từ Activity này sang Activity khác
            Intent intentActivity = new Intent(MainActivity.this, FirstScreenActivity.class);
            startActivity(intentActivity);
            // * finish là kết thúc Activity hiện tại -> nếu finish() Activity hiện tại thì sẽ không quay lại (nút back trên màn hình) Activity hiện tại được
            // * nếu Activity a switch qua Activity b mà trong Activity a finish() thì khi ở Activity b nhấn nút back thì sẽ không quay lại Activity a được
            // * nếu Activity b switch qua Activity c mà trong Activity b không finish() thì khi ở Activity c nhấn nút back thì sẽ quay lại Activity b được
            // finish();
        });


        // TODO: Toast
        findViewById(R.id.BtnToast).setOnClickListener(v -> {
            // * Toast là một thông báo ngắn gọn hiển thị lên màn hình
            Toast.makeText(this, "This is Toast", Toast.LENGTH_SHORT).show();
        });

        // TODO: Fragment
        findViewById(R.id.btn_fragment).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FragmentActivity.class);
            startActivity(intent);
            // finish();
        });


        // TODO: Backstack Fragment
        findViewById(R.id.btn_backstack_fragment).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, BackstackFragmentActivity.class);
            startActivity(intent);
            // finish();
        });

        // TODO: listview
        findViewById(R.id.button_listview).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
            startActivity(intent);
            // finish();
        });

        // TODO: RecyclerView
        findViewById(R.id.button_recyclerview).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
            startActivity(intent);
            // finish();
        });

        // TODO: Animation
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        findViewById(R.id.button_animation).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AnimationActivity.class);
            startActivity(intent);
            // finish();
        });

        // TODO: WebApi json
        findViewById(R.id.button_webapi_json).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, WebApiActivity.class);
            startActivity(intent);
            // finish();
        });

        // TODO: Shared Preferences
        findViewById(R.id.button_shared_preferences).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SharedPreferenceActivity.class);
            startActivity(intent);
            // finish();
        });

        // TODO: SQLite
        findViewById(R.id.button_sqlite).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SQLiteActivity.class);
            startActivity(intent);
            // finish();
        });

        // value có thể là String, int, boolean, double, float, ...Object class
        intentService.putExtra("key", "value");


    }

    @Override
    protected void onStart() {
        super.onStart();
        // onStart() -> onResume() -> onPause() -> onStop() -> onDestroy()
        Log.e(TAG, "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart");
    }

    @Override
    public void recreate() {
        super.recreate();
        Log.e(TAG, "recreate");
    }

    @Override
    public void finish() {
        super.finish();
        Log.e(TAG, "finish");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.e(TAG, "onRestoreInstanceState");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        // lưu lại trạng thái của Activity
        Log.e(TAG, "onSaveInstanceState");
    }
}

