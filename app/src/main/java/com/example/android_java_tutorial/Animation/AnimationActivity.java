package com.example.android_java_tutorial.Animation;

import android.animation.LayoutTransition;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android_java_tutorial.MainActivity;
import com.example.android_java_tutorial.R;

public class AnimationActivity extends AppCompatActivity {
    boolean clicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);


        // TODO: switch to MainActivity
        findViewById(R.id.btn_change).setOnClickListener(v -> {
            Intent changeActivity = new Intent(this, MainActivity.class);
            startActivity(changeActivity);
        });


        // TODO: switch right to left , left to right
        Button btnMove = (Button) findViewById(R.id.btn_move);
        findViewById(R.id.btn_move).setOnClickListener(v -> {
            if (!clicked) {
                btnMove.animate().translationX(400).withLayer();
                clicked = true;
            } else {
                btnMove.animate().translationX(0).withLayer();
                clicked = false;
            }
        });


        // TODO: add button
        LinearLayout container = (LinearLayout) findViewById(R.id.activity_main);
        LayoutTransition l = new LayoutTransition();
        l.enableTransitionType(LayoutTransition.CHANGING);
        container.setLayoutTransition(l);


        findViewById(R.id.btn_add).setOnClickListener(v -> {
            container.addView(new Button(this));
        });
    }
}