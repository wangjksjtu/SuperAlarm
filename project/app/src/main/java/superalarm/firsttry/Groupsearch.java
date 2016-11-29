package superalarm.firsttry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Groupsearch extends TitleActivity {

    Button btnSearch,btnSearchResult;
    TextView tmpGroupResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groupsearch);

        setTitle("搜索小组");
        showBackwardView(R.id.button_backward,true);

        //查询结果对应控件（同user查询）
        tmpGroupResult = (TextView)findViewById(R.id.textGroupSearchResult);
        tmpGroupResult.setVisibility(View.INVISIBLE);

        //增加查询按钮的响应
        btnSearchResult = (Button)findViewById(R.id.buttonLookUpGroup);
        btnSearchResult.setVisibility(View.INVISIBLE);
        btnSearchResult.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Groupsearch.this,"功能尚未完善",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Groupsearch.this,not_yet_activity.class);
                startActivity(intent);
//                Groupsearch.this.finish();
            }
        });

        btnSearch = (Button)findViewById(R.id.searchGroup);
        btnSearch.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnSearchResult.setVisibility(View.VISIBLE);
                tmpGroupResult.setVisibility(View.VISIBLE);
                Toast.makeText(Groupsearch.this,"测试用小组Button",Toast.LENGTH_SHORT).show();
            }
        });



    }
    @Override
    protected void onBackward(View backwardView){finish();}
}
