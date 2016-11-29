package superalarm.firsttry;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;

public class type_set_activity extends AppCompatActivity {

    public static type_set_activity instance = null;
    private Button[] bt_type_list = new Button[9];
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.type_setter);
        instance = this;

        //利用一个循环完成所有按钮的设置
        int tag;
        int[] type_btn_list = {R.id.button_type_1,R.id.button_type_2,R.id.button_type_3,
                R.id.button_type_4,R.id.button_type_5,R.id.button_type_6,
                R.id.button_type_7,R.id.button_type_8,R.id.button_type_9};
        for (tag = 0; tag < 8; tag++) {
            bt_type_list[tag] = (Button) findViewById(type_btn_list[tag]);
            bt_type_list[tag].setTag(tag);//向监听器函数内部传递参数
            bt_type_list[tag].setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    int tag = (Integer) v.getTag();//对上面tag的接收
                    Intent intent_send = new Intent(type_set_activity.this, event_start_activity.class);
                    intent_send.putExtra("typeConvey",bt_type_list[tag].getText());
                    startActivity(intent_send);
                }
            });
        }

        //返回键
        bt_type_list[8] = (Button)findViewById(R.id.button_type_9);
        bt_type_list[8] .setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                type_set_activity.this.finish();
            }
        });
    }
}