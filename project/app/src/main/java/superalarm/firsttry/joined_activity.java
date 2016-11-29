package superalarm.firsttry;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageButton;
import android.widget.Toast;

public class joined_activity extends TitleActivity {

    private ImageButton  btPeopleJoined;
    private Button btEventJoined, btQuitGroupJoined;
    private TextView tvjGroupName,tvjGroupMaster,tvjGroupPeopleJoin,tvjGroupDetails;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joined_group_event);

        setTitle("小组id");
        showBackwardView(R.id.button_backward,true);

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
                Intent intent = new Intent(joined_activity.this, Groupcontent.class);
                startActivity(intent);
                joined_activity.this.finish();
            }
        });

        btEventJoined = (Button)findViewById(R.id.buttonEventJoined);
        btEventJoined.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(joined_activity.this,"功能尚未完善",Toast.LENGTH_SHORT).show();
            }
        });

        btPeopleJoined = (ImageButton)findViewById(R.id.joinedImageButton_person);
        btPeopleJoined.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(joined_activity.this,"查看组群人员(功能尚未完善)",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onBackward(View backwardView){finish();}


}
