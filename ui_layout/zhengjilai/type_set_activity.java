package com.example.asus.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.widget.Button;

public class type_set_activity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.type_setter);
        Button bt1 = (Button) findViewById(R.id.button1);
        bt1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(type_set_activity.this, event_start_activity.class);
                startActivity(intent);
            }
        });
        Button bt5 = (Button) findViewById(R.id.button5);
        bt5.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(type_set_activity.this, time_set_activity.class);
                startActivity(intent);
            }
        });
    }
}