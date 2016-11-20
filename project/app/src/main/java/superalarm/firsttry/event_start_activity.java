package superalarm.firsttry;


import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;


public class event_start_activity extends AppCompatActivity {

    public static event_start_activity instance;
    private EditText textEventName, textEventDetails;
    private RatingBar ratingBar;
    private Button btOkEvent, btCancelEvent;
    private TextView typeTitle;
    private RadioGroup annoyMode;
    private RadioButton annoySingle, annoyFrequent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_starter);
        instance = this;

        //intent接收事项类型
        Intent intent_receive = getIntent();
        String eventType = intent_receive.getStringExtra("typeConvey");
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

        //单选按钮的定义
        annoyMode = (RadioGroup) findViewById(R.id.RadioGroupAnnoy);
        annoySingle = (RadioButton) findViewById(R.id.RadioButtonSingle);
        annoyFrequent = (RadioButton) findViewById(R.id.RadioButtonFrequency);

        //OK按钮和CANCEL按钮的链接
        btOkEvent = (Button)findViewById(R.id.buttonOkEvent);
        btOkEvent.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( annoyMode.getCheckedRadioButtonId() == annoySingle.getId() ) {
                    Intent intent_send = new Intent(event_start_activity.this, time_set_activity.class);
                    intent_send.putExtra("eventName",textEventName.getText().toString());
                    intent_send.putExtra("eventDetail",textEventDetails.getText().toString());
                    intent_send.putExtra("eventType",typeTitle.getText().toString());
                    intent_send.putExtra("eventRating",ratingBar.getRating());
                    startActivity(intent_send);
                }
                else if ( annoyMode.getCheckedRadioButtonId() == annoyFrequent.getId() ) {
                    Intent intent = new Intent(event_start_activity.this, time_frequency_activity.class);
                    startActivity(intent);
                }
            }
        });
        btCancelEvent = (Button)findViewById(R.id.buttonCancelEvent);
        btCancelEvent.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(event_start_activity.this,type_set_activity.class);
//                startActivity(intent);
                event_start_activity.this.finish();
            }
        });
    }


}
