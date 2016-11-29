package superalarm.firsttry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class user_search_activity extends TitleActivity {

    Button btnUserSearch,btnUserSearchResult;
    TextView tmpUserResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_user_search);

        setTitle("邀请用户加入小组群");
        showBackwardView(R.id.button_backward,true);

        //查询结果框预先设为不可见，待查询后读取信息后可见
        tmpUserResult = (TextView)findViewById(R.id.textUserSearchResult);
        tmpUserResult.setVisibility(View.INVISIBLE);

        //增加查询按钮的响应
        btnUserSearchResult = (Button)findViewById(R.id.buttonInviteUser);
        btnUserSearchResult.setVisibility(View.INVISIBLE);
        btnUserSearchResult.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(user_search_activity.this,"邀请成功(功能尚未完善)",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(user_search_activity.this,Groupcontent.class);
                startActivity(intent);
//                user_search_activity.this.finish();
            }
        });

        btnUserSearch = (Button)findViewById(R.id.searchUser);
        btnUserSearch.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnUserSearchResult.setVisibility(View.VISIBLE);
                tmpUserResult.setVisibility(View.VISIBLE);
                Toast.makeText(user_search_activity.this,"测试用搜索结果",Toast.LENGTH_SHORT).show();
            }
        });



    }
    @Override
    protected void onBackward(View backwardView){finish();}
}