package superalarm.firsttry;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import basic_class.Item;
import basic_class.ItemManager;


public class event_start_activity extends TitleActivity {

    public static event_start_activity instance;
    private EditText textEventName, textEventDetails;
    private RatingBar ratingBar;
    private Button btOkEvent, btCancelEvent;
    private TextView typeTitle;
    private RadioGroup annoyMode;
    private RadioButton annoySingle, annoyFrequent;
    private boolean key;
    private int item_num = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        ItemManager itemManager = new ItemManager();
        Item item = new Item();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_starter);
        instance = this;

        setTitle("设置事项内容");
        showBackwardView(R.id.button_backward,true);

        //intent接收事项类型
        String eventType;
        Intent intent_receive = getIntent();
        key = intent_receive.getBooleanExtra("key",false);
        if (!key) {
            eventType = intent_receive.getStringExtra("typeConvey");
        }
        else {
            item_num = intent_receive.getIntExtra("value",-1);
            itemManager.read(event_start_activity.this);
            item = itemManager.itemArr.get(item_num);
            eventType = item.getModule();
        }
        typeTitle = (TextView) findViewById(R.id.textTitleMid);
        typeTitle.setText(eventType);


        //赋值项目名称、重要性、备注组件
        textEventName = (EditText)findViewById(R.id.textFillName);
        textEventDetails = (EditText)findViewById(R.id.textFillDetails);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                //此处做系统默认事件
            }
        });

        if (key){
            textEventName.setText(item.getTitle());
            textEventDetails.setText(item.getContent());
        }

        //单选按钮的定义
        annoyMode = (RadioGroup) findViewById(R.id.RadioGroupAnnoy);
        annoySingle = (RadioButton) findViewById(R.id.RadioButtonSingle);
        annoyFrequent = (RadioButton) findViewById(R.id.RadioButtonFrequency);

        //设置单选按钮默认值
        if (key){
            String deadline = item.getDeadline();
            int length = deadline.length();
            if (length > 6) annoySingle.setChecked(true);
            else annoyFrequent.setChecked(true);
        }

        //OK按钮和CANCEL按钮的链接
        btOkEvent = (Button)findViewById(R.id.buttonOkEvent);
        btOkEvent.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textEventName.getText().toString().length() > 9){
                    Toast.makeText(event_start_activity.this,"名称不能超过九个字",Toast.LENGTH_LONG).show();
                }else{
                    if ( annoyMode.getCheckedRadioButtonId() == annoySingle.getId() ) {
                        Intent intent_send = new Intent(event_start_activity.this, time_set_activity.class);
                        intent_send.putExtra("key",key);
                        intent_send.putExtra("num",item_num);
                        intent_send.putExtra("eventName",textEventName.getText().toString());
                        intent_send.putExtra("eventDetail",textEventDetails.getText().toString());
                        intent_send.putExtra("eventType",typeTitle.getText().toString());
                        intent_send.putExtra("eventRating",ratingBar.getRating());
                        startActivity(intent_send);
                    }
                    else if ( annoyMode.getCheckedRadioButtonId() == annoyFrequent.getId() ) {
                        Intent intent_send = new Intent(event_start_activity.this, time_frequency_activity.class);
                        intent_send.putExtra("key",key);
                        intent_send.putExtra("num",item_num);
                        intent_send.putExtra("eventName",textEventName.getText().toString());
                        intent_send.putExtra("eventDetail",textEventDetails.getText().toString());
                        intent_send.putExtra("eventType",typeTitle.getText().toString());
                        intent_send.putExtra("eventRating",ratingBar.getRating());
                        startActivity(intent_send);
                }}
            }
        });
    }

    @Override
    protected void onBackward(View backwardView) {
        finish();
    }


}
