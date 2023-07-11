package com.example.android_java_tutorial.listview;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android_java_tutorial.R;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        // * listview chỉ có thể hiện danh sach theo hàng dọc , không thể hiện theo hàng ngang, card , grid ,...
        // * để hiện thị theo hàng ngang , card , grid ,... thì phải dùng recyclerview
        String[] items = {"Doan Ngoc Giau", "Pham Kim Long", "123456"};
        ListView listView = (ListView) findViewById(R.id.listview);
        DataAdapter adapter = new DataAdapter(this, items);
        listView.setAdapter(adapter);

    }
}