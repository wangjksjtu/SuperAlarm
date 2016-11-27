package superalarm.firsttry;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageButton;

public class not_yet_activity extends AppCompatActivity {

    private ImageButton  btPeopleNotYet;
    private Button btJoinGroupNotYet;
    private TextView tvnyGroupName,tvnyGroupMaster,tvnyGroupPeopleJoin,tvnyGroupDetails;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.not_join_yet_group_event);

        //赋值组群情况
        tvnyGroupName = (TextView)findViewById(R.id.notYetTextFillName);
        tvnyGroupMaster = (TextView)findViewById(R.id.notYetTextFillMaster);
        tvnyGroupPeopleJoin = (TextView)findViewById(R.id.notYetTextFillJoinPeople);
        tvnyGroupDetails = (TextView)findViewById(R.id.notYetTextFillDetails);

        //JoinGroup按钮和PeopleJoined按钮的链接
        btJoinGroupNotYet = (Button)findViewById(R.id.buttonJoinNotYet);
        btJoinGroupNotYet.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(not_yet_activity.this, joined_activity.class);
                startActivity(intent);
                not_yet_activity.this.finish();
            }
        });

        btPeopleNotYet = (ImageButton)findViewById(R.id.notYetImageButton_person);
        btPeopleNotYet.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(not_yet_activity.this,MainActivity.class);
                startActivity(intent);
                not_yet_activity.this.finish();
            }
        });
    }


}
