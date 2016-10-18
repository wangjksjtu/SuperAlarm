package com.example.asus.myapplication;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class time_set_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_setter);

        Button btCancelTime = (Button)findViewById(R.id.buttonCancelTime);
        btCancelTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(time_set_activity.this,event_start_activity.class);
                startActivity(intent);
            }
        });
        Button btOkTime = (Button)findViewById(R.id.buttonOkTime);
        btOkTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(time_set_activity.this,type_set_activity.class);
                startActivity(intent);
            }
        });

        Spinner Year_spinner = (Spinner) findViewById(R.id.spinnerYear);
        Spinner Month_spinner = (Spinner) findViewById(R.id.spinnerMonth);
        Spinner Day_spinner = (Spinner) findViewById(R.id.spinnerDay);
        Spinner Hour_spinner = (Spinner) findViewById(R.id.spinnerHour);
        Spinner Minute_spinner = (Spinner) findViewById(R.id.spinnerMinute);
        //数据
        List<String> year_list = new ArrayList<String>();
        List<String> month_list = new ArrayList<String>();
        List<String> day_list = new ArrayList<String>();
        List<String> hour_list = new ArrayList<String>();
        List<String> minute_list = new ArrayList<String>();
        int i;
        for (i = 2016; i < 2046; i++) {
            year_list.add(i+"年");
        }
        for (i = 1;i  < 13; i++){
            month_list.add(i+"月");
        }
        for (i = 1;i  < 32; i++){
            day_list.add(i+"日");
        }
        for (i = 0;i  < 10; i++){
            hour_list.add("0"+ i);
            minute_list.add("0"+ i);
        }
        for (i = 10;i  < 24; i++){
            hour_list.add(i+"");
        }
        for (i = 10;i  < 60; i++){
            minute_list.add(i+"");
        }
        //适配器
        ArrayAdapter<String> arr_adapter_year= new ArrayAdapter<String>(this, android.R.layout.preference_category, year_list);
        ArrayAdapter<String> arr_adapter_month= new ArrayAdapter<String>(this, android.R.layout.preference_category, month_list);
        ArrayAdapter<String> arr_adapter_day= new ArrayAdapter<String>(this, android.R.layout.preference_category, day_list);
        ArrayAdapter<String> arr_adapter_hour= new ArrayAdapter<String>(this, R.layout.spinnerlayout_min, hour_list);
        ArrayAdapter<String> arr_adapter_minute= new ArrayAdapter<String>(this, R.layout.spinnerlayout_min, minute_list);
        //设置样式
        arr_adapter_year.setDropDownViewResource(android.R.layout.preference_category);
        arr_adapter_month.setDropDownViewResource(android.R.layout.preference_category);
        arr_adapter_day.setDropDownViewResource(android.R.layout.preference_category);
        arr_adapter_hour.setDropDownViewResource(R.layout.spinnerlayout_min_down);
        arr_adapter_minute.setDropDownViewResource(R.layout.spinnerlayout_min_down);
        //加载适配器
        Year_spinner.setAdapter(arr_adapter_year);
        Month_spinner.setAdapter(arr_adapter_month);
        Day_spinner.setAdapter(arr_adapter_day);
        Hour_spinner.setAdapter(arr_adapter_hour);
        Minute_spinner.setAdapter(arr_adapter_minute);
    }
}
