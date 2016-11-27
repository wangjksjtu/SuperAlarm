package superalarm.firsttry;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;



public class group_start_activity extends AppCompatActivity {

    private EditText groupTextName, groupTextDetails ,groupTextMaxPeople;
    private Button btOkGroup, btCancelGroup;
    private boolean key;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_starter);

        //赋值项目名称、最大人数、备注组件
        groupTextName = (EditText)findViewById(R.id.groupTextFillName);
        groupTextDetails = (EditText)findViewById(R.id.groupTextFillDetails);
        groupTextMaxPeople = (EditText)findViewById(R.id.groupTextFillMaxPeople);

        //OK按钮和CANCEL按钮的链接
        btOkGroup = (Button)findViewById(R.id.buttonOkGroup);
        btOkGroup.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(group_start_activity.this, not_yet_activity.class);
                startActivity(intent);
                group_start_activity.this.finish();
            }
        });
        btCancelGroup = (Button)findViewById(R.id.buttonCancelGroup);
        btCancelGroup.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(group_start_activity.this,MainActivity.class);
                startActivity(intent);
                group_start_activity.this.finish();
            }
        });
    }


}
