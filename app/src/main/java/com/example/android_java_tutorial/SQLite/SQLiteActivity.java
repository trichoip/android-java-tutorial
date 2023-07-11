package com.example.android_java_tutorial.SQLite;

import android.app.ListActivity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.android_java_tutorial.R;

import java.util.List;
import java.util.Random;

public class SQLiteActivity extends ListActivity {

    private PeopleDataSource datasource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        datasource = new PeopleDataSource(this);
        datasource.open();


        Log.e("Path", Environment.getDataDirectory().toString());

        List<Person> values = datasource.getAllPeople();


        // use the SimpleCursorAdapter to show the
        // elements in a listview
        // nó lấy giá trị toString() trong class person để hiển thị value
        ArrayAdapter<Person> adapter = new ArrayAdapter<Person>(this, android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);
    }

    // Tạo sự kiện khi click vào các nút trong activity_main.xml
    public void onClick(View view) {
        @SuppressWarnings("unchecked")
        ArrayAdapter<Person> adapter = (ArrayAdapter<Person>) getListAdapter();
        Person person = null;

        if (view.getId() == R.id.add) {
            // Thêm người vào danh sách.
            String[] people = new String[]{"Alice", "Bob", "Mallory"};
            int nextInt = new Random().nextInt(3);
            person = datasource.createPerson(people[nextInt]);
            adapter.add(person);
        }
        if (view.getId() == R.id.delete) {
            // Xóa người đầu tiên khỏi danh sách.
            if (getListAdapter().getCount() > 0) {
                person = (Person) getListAdapter().getItem(0);
                datasource.deletePerson(person);
                adapter.remove(person);
            }
        }

        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        datasource.open();
        super.onResume();
    }

    @Override
    protected void onPause() {
        datasource.close();
        super.onPause();
    }

}