package com.example.android_java_tutorial.listview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.android_java_tutorial.R;

public class DataAdapter extends BaseAdapter {

    private Activity activity;
    private String[] items;

    public DataAdapter(Activity activity, String[] items) {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int position) {
        return items[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Gọi layoutInflater ra để bắt đầu ánh xạ view và data.
        LayoutInflater inflater = activity.getLayoutInflater();

        // Đổ dữ liệu vào biến View
        convertView = inflater.inflate(R.layout.item_listview, null);


        // Đặt chữ cho từng view trong danh sách.
        TextView tvName = (TextView) convertView.findViewById(R.id.textview_item);
        tvName.setText(items[position]);

        ((Button) convertView.findViewById(R.id.button_item)).setText(items[position]);


        // Trả về view kết quả.
        return convertView;
    }
}
