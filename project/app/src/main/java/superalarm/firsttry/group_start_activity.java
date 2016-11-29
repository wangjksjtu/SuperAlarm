package superalarm.firsttry;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;



public class group_start_activity extends TitleActivity {

    private EditText groupTextName, groupTextDetails ,groupTextMaxPeople;
    private Button btOkGroup, btCancelGroup;
    private boolean key;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_starter);

        setTitle("创建小组");
        showBackwardView(R.id.button_backward,true);

        //赋值项目名称、最大人数、备注组件
        groupTextName = (EditText)findViewById(R.id.groupTextFillName);
        groupTextDetails = (EditText)findViewById(R.id.groupTextFillDetails);
        groupTextMaxPeople = (EditText)findViewById(R.id.groupTextFillMaxPeople);

        //OK按钮的链接
        btOkGroup = (Button)findViewById(R.id.buttonOkGroup);
        btOkGroup.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(group_start_activity.this, masters_activity.class);
                startActivity(intent);
                group_start_activity.this.finish();
            }
        });
    }
    @Override
    protected void onBackward(View backwardView){finish();}


}
