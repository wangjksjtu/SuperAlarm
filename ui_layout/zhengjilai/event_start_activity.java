package com.example.asus.myapplication;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.widget.Button;


public class event_start_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_starter);
        Button btOkEvent = (Button)findViewById(R.id.buttonOkEvent);
        btOkEvent.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(event_start_activity.this,time_set_activity.class);
                startActivity(intent);
            }
        });
        Button btCancelEvent = (Button)findViewById(R.id.buttonCancelEvent);
        btCancelEvent.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(event_start_activity.this,type_set_activity.class);
                startActivity(intent);
            }
        });
    }
}
