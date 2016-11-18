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
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

import static android.widget.Toast.makeText;


public class time_frequency_activity extends AppCompatActivity {

    public static time_frequency_activity instance = null;
    private Spinner  hourSpinner_f, minuteSpinner_f;
    private Button btCancelTime_f, btOkTime_f;
    private RadioGroup frequencyMode;
    private Button[] Btn_week = new Button[7];
    private boolean[] week_btn_pressed = {false,false,false,false,false,false,false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_frequency);
        instance = this;


        //时间属性下拉表Spinner变量
        hourSpinner_f = (Spinner) findViewById(R.id.spinnerHour_f);
        minuteSpinner_f = (Spinner) findViewById(R.id.spinnerMinute_f);

        //两个下拉表的内部选项数据
        List<String> hour_list_f = new ArrayList<String>();
        List<String> minute_list_f = new ArrayList<String>();
        int i,tag;
        for (i = 0;i  < 10; i++){
            hour_list_f.add("0"+ i);
            minute_list_f.add("0"+ i);
        }
        for (i = 10;i  < 24; i++){
            hour_list_f.add(i+"");
        }
        for (i = 10;i  < 60; i++){
            minute_list_f.add(i+"");
        }

        //适配器
        ArrayAdapter<String> arr_adapter_hour_f = new ArrayAdapter<String>(this, R.layout.spinnerlayout_min, hour_list_f);
        ArrayAdapter<String> arr_adapter_minute_f = new ArrayAdapter<String>(this, R.layout.spinnerlayout_min, minute_list_f);

        //设置样式
        arr_adapter_hour_f.setDropDownViewResource(R.layout.spinnerlayout_min_down);
        arr_adapter_minute_f.setDropDownViewResource(R.layout.spinnerlayout_min_down);

        //加载适配器
        hourSpinner_f.setAdapter(arr_adapter_hour_f);
        minuteSpinner_f.setAdapter(arr_adapter_minute_f);


        //提醒频率按钮的定义
        frequencyMode = (RadioGroup) findViewById(R.id.RadioGroupFrequency);

        //提醒频率监听器
        frequencyMode.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int radioButtonId = group.getCheckedRadioButtonId();
                if (radioButtonId == R.id.RadioButtonFrequencyWeek){
                    for (int j = 0; j < 7; j++)  {
                        Btn_week[j].setVisibility(View.VISIBLE);
                    }
                }
                else if (radioButtonId == R.id.RadioButtonFrequencyDay){
                    for (int j = 0; j < 7; j++)  {
                        Btn_week[j].setVisibility(View.INVISIBLE);
                    }
                }
            }
        });

        //日期按钮的定义;
        int[] week_btn_list = {R.id.button_mon,R.id.button_tue,R.id.button_wed,R.id.button_thu,
                                        R.id.button_fri,R.id.button_sat,R.id.button_sun};
        for (tag = 0; tag < 7; tag++){
            Btn_week[tag] = (Button)findViewById(week_btn_list[tag]);
            Btn_week[tag].setVisibility(View.INVISIBLE);
            Btn_week[tag].setTag(tag);
            Btn_week[tag].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int tag = (Integer) v.getTag();
                    if (week_btn_pressed[tag]) {
                        Btn_week[tag].setBackgroundResource(R.drawable.btn_week);
                        week_btn_pressed[tag] = false;
                    }
                    else{
                        Btn_week[tag].setBackgroundResource(R.drawable.btn_week_selected);
                        week_btn_pressed[tag] = true;
                    }
                }
            });
        }


        //OK按钮和CANCEL按钮的链接
        btCancelTime_f = (Button)findViewById(R.id.buttonCancelTime_f);
        btCancelTime_f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time_frequency_activity.this.finish();
            }
        });

        btOkTime_f = (Button)findViewById(R.id.buttonOkTime_f);
        btOkTime_f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.instance.finish();
                Intent intent = new Intent(time_frequency_activity.this,MainActivity.class);
                startActivity(intent);
                time_frequency_activity.this.finish();
                type_set_activity.instance.finish();
                event_start_activity.instance.finish();
            }
        });

    }

    public String getDeadline() {
        String hourData_f = (String)hourSpinner_f.getSelectedItem();
        String minuteData_f = (String)minuteSpinner_f.getSelectedItem();
        return (hourData_f + ":" + minuteData_f);
    }


}
