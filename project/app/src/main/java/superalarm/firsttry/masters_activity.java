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

public class masters_activity extends TitleActivity {

    private ImageButton  btPeopleMaster,btInviteMaster;
    private Button btAddEventMaster, btReviseMaster;
    private TextView tvmGroupName,tvmGroupPeopleJoin,tvmGroupDetails;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.master_group_event);

        setTitle("小组id");
        showBackwardView(R.id.button_backward,true);

        //赋值组群情况
        tvmGroupName = (TextView)findViewById(R.id.masterTextFillName);
        tvmGroupPeopleJoin = (TextView)findViewById(R.id.masterTextFillJoinPeople);
        tvmGroupDetails = (TextView)findViewById(R.id.masterTextFillDetails);

        //Revise按钮、Event按钮、PeopleJoined按钮、Invite按钮的链接
        btReviseMaster = (Button)findViewById(R.id.buttonReviseInfoMaster);
        btReviseMaster.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(masters_activity.this,Groupcontent.class);
                startActivity(intent);
//                masters_activity.this.finish();
                Toast.makeText(masters_activity.this,"修改组群信息(功能尚未完善)",Toast.LENGTH_SHORT).show();
            }
        });

        btAddEventMaster = (Button)findViewById(R.id.buttonAddEventMaster);
        btAddEventMaster.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(masters_activity.this,MainActivity.class);
//                startActivity(intent);
//                masters_activity.this.finish();
                Toast.makeText(masters_activity.this,"功能尚未完善",Toast.LENGTH_SHORT).show();
            }
        });

        btPeopleMaster = (ImageButton)findViewById(R.id.masterImageButton_person);
        btPeopleMaster.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(masters_activity.this,MainActivity.class);
//                startActivity(intent);
//                masters_activity.this.finish();
                Toast.makeText(masters_activity.this,"查看组群人员(功能尚未完善)",Toast.LENGTH_SHORT).show();
            }
        });

        btInviteMaster = (ImageButton)findViewById(R.id.masterImageButton_invite);
        btInviteMaster.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(masters_activity.this,user_search_activity.class);
                startActivity(intent);
//                masters_activity.this.finish();
            }
        });
    }
    @Override
    protected void onBackward(View backwardView){finish();}


}
