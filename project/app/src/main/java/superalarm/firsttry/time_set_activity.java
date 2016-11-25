package superalarm.firsttry;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import basic_class.Item;
import basic_class.ItemManager;
import basic_class.NotExistException;
import basic_class.RepeatedAddtionException;


public class time_set_activity extends AppCompatActivity {

    public static time_set_activity instance = null;
    private Spinner yearSpinner, monthSpinner, daySpinner, hourSpinner, minuteSpinner;
    private Spinner[] timeAhead = new Spinner[5];
    private Button btCancelTime, btOkTime;
    private String[] eventData = new String[3];
    private float eventRating;
    private boolean key = false;
    private int item_num = -1;
    private String deadline;
    private Item item = new Item();
    private ItemManager itemManager = new ItemManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_setter);
        instance = this;

        //intent接收事项类型
        Intent intent_receive = getIntent();
        key = intent_receive.getBooleanExtra("key",false);
        item_num = intent_receive.getIntExtra("num",-1);
        eventData[0] = intent_receive.getStringExtra("eventName");
        eventData[1] = intent_receive.getStringExtra("eventType");
        eventData[2] = intent_receive.getStringExtra("eventDetail");
        eventRating = intent_receive.getFloatExtra("eventRating",-1f);

        itemManager.read(time_set_activity.this);

        if (key){
            item = itemManager.itemArr.get(item_num);
            deadline = item.getDeadline();
        }

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
            if (i < 10){ month_list.add("0" + i + "月");}
            else {month_list.add(i + "月");}
        }
        for (i = 1;i  < 32; i++){
            if (i < 10){ day_list.add("0" + i + "日");}
            else {day_list.add(i + "日");}
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

        //设置默认值
        if (key) {
            yearSpinner.setSelection(Integer.valueOf(deadline.substring(0, 4)) - 2016, key);
            monthSpinner.setSelection(Integer.valueOf(deadline.substring(5, 7)) - 1, key);
            daySpinner.setSelection(Integer.valueOf(deadline.substring(8, 10)) - 1, key);
            hourSpinner.setSelection(Integer.valueOf(deadline.substring(11, 13)), key);
            minuteSpinner.setSelection(Integer.valueOf(deadline.substring(14, 16)), key);
        }
        //5个提前量Spinner的定义，2345初始不可见
        int[] Ahead_id_list = {R.id.spinnerAd1,R.id.spinnerAd2,R.id.spinnerAd3,R.id.spinnerAd4,R.id.spinnerAd5};
        for (i = 0;i < 5;i++){
            timeAhead[i] = (Spinner) findViewById(Ahead_id_list[i]);
        }
        for (i = 1;i < 5;i++){
            timeAhead[i].setVisibility(View.INVISIBLE);
        }


        //提前量spinner的选择事件处理
        timeAhead[0].setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String tmpTH = timeAhead[0].getSelectedItem().toString();
                if (tmpTH.compareTo("None") != 0){
                    timeAhead[1].setVisibility(View.VISIBLE);
                }
            }
            public void  onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        timeAhead[1].setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String tmpTH = timeAhead[1].getSelectedItem().toString();
                if (tmpTH.compareTo("None") != 0){
                    timeAhead[2].setVisibility(View.VISIBLE);
                }
                else {
                    timeAhead[1].setVisibility(View.INVISIBLE);
                    timeAhead[2].setVisibility(View.INVISIBLE);
                    timeAhead[3].setVisibility(View.INVISIBLE);
                    timeAhead[4].setVisibility(View.INVISIBLE);
                }
            }
            public void  onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        timeAhead[2].setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String tmpTH = timeAhead[2].getSelectedItem().toString();
                if (tmpTH.compareTo("None") != 0){
                    timeAhead[3].setVisibility(View.VISIBLE);
                }
                else {
                    timeAhead[2].setVisibility(View.INVISIBLE);
                    timeAhead[3].setVisibility(View.INVISIBLE);
                    timeAhead[4].setVisibility(View.INVISIBLE);
                }
            }
            public void  onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        timeAhead[3].setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String tmpTH = timeAhead[3].getSelectedItem().toString();
                if (tmpTH.compareTo("None") != 0){
                    timeAhead[4].setVisibility(View.VISIBLE);
                }
                else {
                    timeAhead[3].setVisibility(View.INVISIBLE);
                    timeAhead[4].setVisibility(View.INVISIBLE);
                }
            }
            public void  onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        timeAhead[4].setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String tmpTH = timeAhead[4].getSelectedItem().toString();
                if (tmpTH.compareTo("None") == 0){
                    timeAhead[4].setVisibility(View.INVISIBLE);
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
                time_set_activity.this.finish();
            }
        });

        btOkTime = (Button)findViewById(R.id.buttonOkTime);
        btOkTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建事项
                Item item_new = new Item();
                item_new.setModule(eventData[1]);
                item_new.setContent(eventData[2]);
                item_new.setDeadline(getDeadline());
                item_new.setTitle(eventData[0]);
                item_new.setImportance((int)eventRating);

                if (key){
                try {
                    itemManager.delete(item);
                } catch (NotExistException e) {
                    e.printStackTrace();
                }}
                try {
                    itemManager.add(item_new);
                    UpdateItems updateItems = new UpdateItems();
                    updateItems.postItems(item_new);
                } catch (RepeatedAddtionException e) {
                    e.printStackTrace();
                }
                itemManager.sortByDeadline();
                itemManager.write(time_set_activity.this);

                MainActivity.instance.finish();
                Intent intent = new Intent(time_set_activity.this, MainActivity.class);
                startActivity(intent);
                time_set_activity.this.finish();
                if (!key)type_set_activity.instance.finish();
                else Detail.instance.finish();
                event_start_activity.instance.finish();
            }
        });
    }

    public String getDeadline() {
        String yearData = ((String)yearSpinner.getSelectedItem()).substring(0,4);
        String monthData = ((String)monthSpinner.getSelectedItem()).substring(0,2);
        String dayData = ((String)daySpinner.getSelectedItem()).substring(0,2);
        String hourData = (String)hourSpinner.getSelectedItem();
        String minuteData = (String)minuteSpinner.getSelectedItem();
        return (yearData + ":" + monthData + ":" + dayData + ":"  + hourData + ":" + minuteData);
    }

    public String AheadConvert() {
        String[] AheadData = new String[5];
        String feedback = "";
        String[] AheadChoices = {"None", "准时", "提前 2 分钟", "提前 5 分钟",
        "提前 10 分钟", "提前 15 分钟", "提前 30 分钟", "提前 1 小时", "提前 2 小时", "提前 5 小时",
        "提前 24 小时", "提前 2 天", "提前 5 天", "提前 30 天"};
        String[] AheadConvertChoices = {"x", "0,m", "2,m", "5,m",
                "10,m", "15,m", "30,m", "1,h", "2,h", "5,h",
                "1,d", "2,d", "5,d", "30,d"};
        int i,j;
        for (i = 0; i < 5; i++){
            AheadData[i] = timeAhead[i].getSelectedItem().toString();
        }//读取选项
        i = 0;
        while (AheadData[i].compareTo("None") != 0 && i < 5 ){
            for (j = 0; j < 12 ; j++){
                if (AheadData[i].compareTo(AheadChoices[j]) == 0){break;}
            }
            if (feedback.compareTo("") == 0){feedback += AheadConvertChoices[j];}
            else {feedback = feedback + ":" + AheadConvertChoices[j];}
            i++;
        }//改写选项
        if (feedback.compareTo("") == 0) {feedback = "0,m";}//Default为准时
        return feedback;
    }

    public String getEventName() {return eventData[0];}
    public String getEventType() {return eventData[1];}
    public String getEventDetail() {return eventData[2];}
    public float getRating() {return eventRating;}


}
