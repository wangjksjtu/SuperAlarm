package superalarm.firsttry;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import basic_class.Item;
import basic_class.ItemManager;
import basic_class.NotExistException;
import basic_class.RepeatedAddtionException;


public class time_frequency_activity extends TitleActivity {

    public static time_frequency_activity instance = null;
    private Spinner  hourSpinner_f, minuteSpinner_f;
    private Button btCancelTime_f, btOkTime_f;
    private RadioGroup frequencyMode;
    private Button[] Btn_week = new Button[7];
    private boolean[] week_btn_pressed = {false,false,false,false,false,false,false};
    private String[] eventData = new String[3];
    private float eventRating;
    private Item item0 = new Item();
    private ItemManager itemManager = new ItemManager();
    private boolean key = false;
    private String deadline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_frequency);
        instance = this;

        setTitle("设置提醒周期");
        showBackwardView(R.id.button_backward,true);

        itemManager.read(time_frequency_activity.this);

        //intent接收事项类型
        Intent intent_receive = getIntent();
        key = intent_receive.getBooleanExtra("key",false);
        if (key){
            int num = intent_receive.getIntExtra("num",-1);
            item0 = itemManager.itemArr.get(num);
            deadline = item0.getDeadline();
        }
        eventData[0] = intent_receive.getStringExtra("eventName");
        eventData[1] = intent_receive.getStringExtra("eventType");
        eventData[2] = intent_receive.getStringExtra("eventDetail");
        eventRating = intent_receive.getFloatExtra("eventRating",-1f);

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

        if (key){
            hourSpinner_f.setSelection(Integer.valueOf(deadline.substring(0, 2)),key);
            minuteSpinner_f.setSelection(Integer.valueOf(deadline.substring(3, 5)),key);
        }else{
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
            Date curDate = new Date(System.currentTimeMillis());//获取当前时间
            String str = formatter.format(curDate);
            hourSpinner_f.setSelection(Integer.valueOf(str.substring(0, 2)),key);
            minuteSpinner_f.setSelection(Integer.valueOf(str.substring(3, 5)),key);
        }


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


        //OK按钮的链接
        btOkTime_f = (Button)findViewById(R.id.buttonOkTime_f);
        btOkTime_f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (okCheck()) {
                    //创建事项
//                    String circle;
                    Item item = new Item();
                    item.setModule(eventData[1]);
                    item.setContent(eventData[2]);
//                    switch (getCircle()){
//                        case 0:circle = "每天"+getDeadline();break;
//                        case 1:circle = "每周"+getDeadline();break;
//                        default:circle = "每月"+getDeadline();
//                    }
//                    item.setDeadline(circle);
                    item.setDeadline(getDeadline());
                    item.setTitle(eventData[0]);
                    item.setImportance((int)eventRating);

                    if (key){
                        try {
                            itemManager.modify(item0,item.getTitle(),item.getDeadline(),item.getImportance(),item.getContent());
                        } catch (NotExistException e) {
                            e.printStackTrace();
                        }
                    }
                    else{
                        try {
                            itemManager.add(item);
                        } catch (RepeatedAddtionException e) {
                            e.printStackTrace();
                        }
                    }

                    itemManager.sortByDeadline();
                    itemManager.write(time_frequency_activity.this);
//                    MainActivity.instance.finish();
//                    Intent intent = new Intent(time_frequency_activity.this, MainActivity.class);
//                    startActivity(intent);
                    time_frequency_activity.this.finish();
                    if (key)Detail.instance.finish();
                    else type_set_activity.instance.finish();
                    event_start_activity.instance.finish();
                }
            }
        });

    }
    private boolean okCheck(){
        int radioButtonId = frequencyMode.getCheckedRadioButtonId(),k;
        if (radioButtonId == R.id.RadioButtonFrequencyWeek){
            for (k = 0;k < 7; k++){
                if (week_btn_pressed[k]){break;}
            }
            if (k == 7) {return false;}
        }
        return true;
    }

    public String getDeadline() {
        String hourData_f = (String)hourSpinner_f.getSelectedItem();
        String minuteData_f = (String)minuteSpinner_f.getSelectedItem();
        return (hourData_f + ":" + minuteData_f);
    }

    public String getCircleType() {
        int radioButtonId = frequencyMode.getCheckedRadioButtonId();
        if (radioButtonId == R.id.RadioButtonFrequencyDay) {return "0";}
        else if (radioButtonId == R.id.RadioButtonFrequencyWeek) {return "1";}
        else  {return "2";}
    }
    //为了方便使用写了个重构
    public int getCircle() {
        int radioButtonId = frequencyMode.getCheckedRadioButtonId();
        if (radioButtonId == R.id.RadioButtonFrequencyDay) {return 0;}
        else if (radioButtonId == R.id.RadioButtonFrequencyWeek) {return 1;}
        else  {return 2;}
    }

    public String getWeekDetails() {
        String feedback = "";
        for (int k = 0; k < 7 ; k++){
            if (week_btn_pressed[k] ){feedback += (k + 1);}
        }
        return feedback;
    }

    public String getEventName() {return eventData[0];}
    public String getEventType() {return eventData[1];}
    public String getEventDetail() {return eventData[2];}
    public float getRating() {return eventRating;}
    @Override
    protected void onBackward(View backwardView) {
        finish();
    }
}
