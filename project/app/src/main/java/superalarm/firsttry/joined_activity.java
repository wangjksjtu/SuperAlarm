package superalarm.firsttry;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageButton;

public class joined_activity extends AppCompatActivity {

    private ImageButton  btPeopleJoined;
    private Button btEventJoined, btQuitGroupJoined;
    private TextView tvjGroupName,tvjGroupMaster,tvjGroupPeopleJoin,tvjGroupDetails;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joined_group_event);

        //赋值组群情况
        tvjGroupName = (TextView)findViewById(R.id.joinedTextFillName);
        tvjGroupMaster = (TextView)findViewById(R.id.joinedTextFillMaster);
        tvjGroupPeopleJoin = (TextView)findViewById(R.id.joinedTextFillJoinPeople);
        tvjGroupDetails = (TextView)findViewById(R.id.joinedTextFillDetails);

        //GroupJoined按钮、Event按钮、PeopleJoined按钮的链接
        btQuitGroupJoined = (Button)findViewById(R.id.buttonQuitJoined);
        btQuitGroupJoined.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(joined_activity.this, MainActivity.class);
                startActivity(intent);
                joined_activity.this.finish();
            }
        });

        btEventJoined = (Button)findViewById(R.id.buttonEventJoined);
        btEventJoined.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(joined_activity.this,MainActivity.class);
                startActivity(intent);
                joined_activity.this.finish();
            }
        });

        btPeopleJoined = (ImageButton)findViewById(R.id.joinedImageButton_person);
        btPeopleJoined.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(joined_activity.this,masters_activity.class);
                startActivity(intent);
                joined_activity.this.finish();
            }
        });
    }


}
