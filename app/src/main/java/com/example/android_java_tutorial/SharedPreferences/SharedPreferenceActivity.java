package com.example.android_java_tutorial.SharedPreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android_java_tutorial.R;

public class SharedPreferenceActivity extends AppCompatActivity {

    // Các kiểu lưu trữ dữ liệu trong Android
    // Shared Preferences: Lưu trữ dữ liệu dạng Key-Value.
    // Internal Storage: Lưu trữ dữ liệu vào vùng nhớ của thiết bị.
    // External Storage: Lưu trữ dữ liệu vào vùng nhớ ngoài được chia sẻ.
    // SQLite Database: Lưu trữ dữ liệu vào cơ sở dữ liệu được tích hợp trong Android. Cơ sở dữ liệu này là SQLite.
    // Network: Lưu trữ dữ liệu trên server riêng của bạn, truy cập và lấy về qua API của server.


    //    SharedPreferences là một Framework, nói đúng hơn là một tính năng giúp bạn lưu giữ liệu dưới dạng khoá-giá trị.
    //    Mỗi SharedPreferences đều đi kèm với một Context.
    //    Gọi hàm edit() để tạo ra một object của SharedPreferences.Editor()
    //    Thêm dữ liệu bằng các phương thức như putString / putBoolean,…
    //    Thực thi chỉnh sửa bằng phương thức commit().

    // SharedPreferences lưu giá trị trong máy của người dùng, nên nó sẽ không bị xoá khi ứng dụng bị tắt hoàn toàn.

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    EditText etData;
    Button btnSave;
    Button btnClear;

    
    private void initPreferences() {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = sharedPreferences.edit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);

        initPreferences();
        etData = (EditText) findViewById(R.id.et_data);
        btnSave = (Button) findViewById(R.id.btn_save);
        btnClear = (Button) findViewById(R.id.btn_clear);

        String savedData = sharedPreferences.getString("DATA", "");
        etData.setText(savedData);

        btnSave.setOnClickListener(v -> {
            // Nếu click vào nút Save, ta sẽ lưu dữ liệu lại.
            String data = etData.getText().toString();
            // "DATA" là key, data tham số thứ 2 là value.
            editor.putString("DATA", data);
            editor.commit();

        });

        btnClear.setOnClickListener(v -> {
            // Nếu click vào nút Clear, ta sẽ xoá dữ liệu đi.
            etData.setText("");
            editor.clear();
            editor.commit();

        });
    }
}