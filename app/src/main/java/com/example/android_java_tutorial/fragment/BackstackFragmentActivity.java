package com.example.android_java_tutorial.fragment;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.android_java_tutorial.R;

public class BackstackFragmentActivity extends AppCompatActivity {

    // demo fragment backstack -> khi switch qua lại giữa các fragment thì khi back thì nó back lại fragment trước đó
    // Backstack (nút back màn hình) chỉ có tác dụng với activity
    // mà fragment lại nằm trong activity nên khi back nó chỉ back activity chứ không back lại fragment
    // Activity a có nhiều fragment 1 2, khi chuyển từ fragment 1 -> fragment 2  thì khi back nó back lại trước Activity a chứ không có back lại fragment 1
    // vì trong Activity a khi switch qua lại giữa các fragment thì activity không có load mới hay tạo mới  và nó chỉ nó mỗi Activity a duy nhất
    // để back lại fragment 1 thì phải có thêm -> ft.addToBackStack(fragment.getClass().getSimpleName()); -> thì mới backstack lại fragment 1 được

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backstack_fragment);

        findViewById(R.id.btn_replace_fragment).setOnClickListener(v -> {
            // ! có BackStack
            replaceFragmentContent(new Fragment3());
            Log.e("replace fragment", "3");
        });

        findViewById(R.id.btn_fragment_1).setOnClickListener(v -> {
            // ! không có BackStack
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container_body, new Fragment1())
                    .commit();
            Log.e("add fragment", "1");
        });

        findViewById(R.id.btn_fragment_2).setOnClickListener(v -> {
            // ! có BackStack
            addFragment(new Fragment2());
            Log.e("add fragment", "2");
        });

        findViewById(R.id.btn_fragment_3).setOnClickListener(v -> {
            // ! có BackStack
            addFragment(new Fragment3());
            Log.e("add fragment", "3");
        });

        initFragment();
    }

    private void initFragment() {
        Fragment1 firstFragment = new Fragment1();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        // TODO: replace nó thay thế hết tất cả view của container_body bằng Fragment1
        ft.replace(R.id.container_body, firstFragment);
        ft.commit();
    }

    protected void replaceFragmentContent(Fragment fragment) {
        if (fragment != null) {
            FragmentManager fmgr = getSupportFragmentManager();
            FragmentTransaction ft = fmgr.beginTransaction();
            // TODO: replace nó thay thế hết tất cả view của container_body bằng fragment
            ft.replace(R.id.container_body, fragment);
            ft.addToBackStack(fragment.getClass().getSimpleName());
            ft.commit();
        }
    }

    protected void addFragment(Fragment fragment) {
        FragmentManager fmgr = getSupportFragmentManager();
        FragmentTransaction ft = fmgr.beginTransaction();
        // TODO: add nó thêm vào container_body 1 fragment mới và nó không làm mất view cũ của container_body
        ft.add(R.id.container_body, fragment);
        // TODO: do có addToBackStack nên khi add sau đó back nó sẽ back lại fragment trước đó
        ft.addToBackStack(fragment.getClass().getSimpleName());
        ft.commit();
    }
}