package superalarm.firsttry;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageButton;

public class masters_activity extends AppCompatActivity {

    private ImageButton  btPeopleMaster,btInviteMaster;
    private Button btAddEventMaster, btReviseMaster;
    private TextView tvmGroupName,tvmGroupPeopleJoin,tvmGroupDetails;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.master_group_event);

        //赋值组群情况
        tvmGroupName = (TextView)findViewById(R.id.masterTextFillName);
        tvmGroupPeopleJoin = (TextView)findViewById(R.id.masterTextFillJoinPeople);
        tvmGroupDetails = (TextView)findViewById(R.id.masterTextFillDetails);

        //Revise按钮、Event按钮、PeopleJoined按钮、Invite按钮的链接
        btReviseMaster = (Button)findViewById(R.id.buttonReviseInfoMaster);
        btReviseMaster.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(masters_activity.this, MainActivity.class);
                startActivity(intent);
                masters_activity.this.finish();
            }
        });

        btAddEventMaster = (Button)findViewById(R.id.buttonAddEventMaster);
        btAddEventMaster.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(masters_activity.this,MainActivity.class);
                startActivity(intent);
                masters_activity.this.finish();
            }
        });

        btPeopleMaster = (ImageButton)findViewById(R.id.masterImageButton_person);
        btPeopleMaster.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(masters_activity.this,MainActivity.class);
                startActivity(intent);
                masters_activity.this.finish();
            }
        });

        btInviteMaster = (ImageButton)findViewById(R.id.masterImageButton_invite);
        btInviteMaster.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(masters_activity.this,MainActivity.class);
                startActivity(intent);
                masters_activity.this.finish();
            }
        });
    }


}
