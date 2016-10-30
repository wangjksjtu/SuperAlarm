package superalarm.firsttry;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class time_set_activity extends AppCompatActivity {

    public static time_set_activity instance = null;
    private Spinner yearSpinner, monthSpinner, daySpinner, hourSpinner, minuteSpinner;
    private Spinner timeAhead1, timeAhead2, timeAhead3, timeAhead4, timeAhead5;
    private Button btCancelTime, btOkTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_setter);
        instance = this;


        //时间属性下拉表Spinner变量
        yearSpinner = (Spinner) findViewById(R.id.spinnerYear);
        monthSpinner = (Spinner) findViewById(R.id.spinnerMonth);
        daySpinner = (Spinner) findViewById(R.id.spinnerDay);
        hourSpinner = (Spinner) findViewById(R.id.spinnerHour);
        minuteSpinner = (Spinner) findViewById(R.id.spinnerMinute);

        //五个下拉表的内部选项数据
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
        yearSpinner.setAdapter(arr_adapter_year);
        monthSpinner.setAdapter(arr_adapter_month);
        daySpinner.setAdapter(arr_adapter_day);
        hourSpinner.setAdapter(arr_adapter_hour);
        minuteSpinner.setAdapter(arr_adapter_minute);

        //5个提前量Spinner的定义，2345初始不可见
        timeAhead1 = (Spinner) findViewById(R.id.spinnerAd1);
        timeAhead2 = (Spinner) findViewById(R.id.spinnerAd2);
        timeAhead3 = (Spinner) findViewById(R.id.spinnerAd3);
        timeAhead4 = (Spinner) findViewById(R.id.spinnerAd4);
        timeAhead5 = (Spinner) findViewById(R.id.spinnerAd5);
        timeAhead2.setVisibility(View.INVISIBLE);
        timeAhead3.setVisibility(View.INVISIBLE);
        timeAhead4.setVisibility(View.INVISIBLE);
        timeAhead5.setVisibility(View.INVISIBLE);
        String tmpTH = timeAhead1.getSelectedItem().toString();
        int test = tmpTH.compareTo("None");
        System.out.println(test);


        //提前量spinner的选择事件处理
        timeAhead1.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String tmpTH = timeAhead1.getSelectedItem().toString();
                if (tmpTH.compareTo("None") != 0){
                    timeAhead2.setVisibility(View.VISIBLE);
                }
            }
            public void  onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        timeAhead2.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String tmpTH = timeAhead2.getSelectedItem().toString();
                if (tmpTH.compareTo("None") != 0){
                    timeAhead3.setVisibility(View.VISIBLE);
                }
                else {
                    timeAhead2.setVisibility(View.INVISIBLE);
                    timeAhead3.setVisibility(View.INVISIBLE);
                    timeAhead4.setVisibility(View.INVISIBLE);
                    timeAhead5.setVisibility(View.INVISIBLE);
                }
            }
            public void  onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        timeAhead3.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String tmpTH = timeAhead3.getSelectedItem().toString();
                if (tmpTH.compareTo("None") != 0){
                    timeAhead4.setVisibility(View.VISIBLE);
                }
                else {
                    timeAhead3.setVisibility(View.INVISIBLE);
                    timeAhead4.setVisibility(View.INVISIBLE);
                    timeAhead5.setVisibility(View.INVISIBLE);
                }
            }
            public void  onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        timeAhead4.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String tmpTH = timeAhead4.getSelectedItem().toString();
                if (tmpTH.compareTo("None") != 0){
                    timeAhead5.setVisibility(View.VISIBLE);
                }
                else {
                    timeAhead4.setVisibility(View.INVISIBLE);
                    timeAhead5.setVisibility(View.INVISIBLE);
                }
            }
            public void  onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        timeAhead5.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String tmpTH = timeAhead5.getSelectedItem().toString();
                if (tmpTH.compareTo("None") == 0){
                    timeAhead5.setVisibility(View.INVISIBLE);
                }
            }
            public void  onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });


        //OK按钮和CANCEL按钮的链接
        btCancelTime = (Button)findViewById(R.id.buttonCancelTime);
        btCancelTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(time_set_activity.this,event_start_activity.class);
//                startActivity(intent);
                time_set_activity.this.finish();
            }
        });

        btOkTime = (Button)findViewById(R.id.buttonOkTime);
        btOkTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.instance.finish();
                Intent intent = new Intent(time_set_activity.this,MainActivity.class);
                startActivity(intent);
                time_set_activity.this.finish();
                type_set_activity.instance.finish();
                event_start_activity.instance.finish();
            }
        });
    }

    public String getDeadline() {
        String yearData = (String)yearSpinner.getSelectedItem();
        String monthData = (String)monthSpinner.getSelectedItem();
        String dayData = (String)daySpinner.getSelectedItem();
        String hourData = (String)hourSpinner.getSelectedItem();
        String minuteData = (String)minuteSpinner.getSelectedItem();
        return (yearData + ":" + monthData + ":" + dayData + ":"  + hourData + ":" + minuteData);
    }

}
