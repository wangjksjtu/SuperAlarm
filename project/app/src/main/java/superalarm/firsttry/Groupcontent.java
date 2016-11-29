package superalarm.firsttry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class Groupcontent extends TitleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groupcontent);

        setTitle("小组群");
        showBackwardView(R.id.button_backward,true);

        //为两个listview分别添加基础提示信息
        ListView lvSet = (ListView)findViewById(R.id.set);
        ArrayList<HashMap<String, Object>> listItem1 = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> map1 = new HashMap<String, Object>();
        map1.put("text","去创建你的小组群吧");
        listItem1.add(map1);
        SimpleAdapter mSimpleAdaptr = new SimpleAdapter(this, listItem1, R.layout.nothing,
                new String[]{"text"}, new int[]{R.id.textView});
        lvSet.setAdapter(mSimpleAdaptr);

        ListView lvJoin = (ListView)findViewById(R.id.join);
        ArrayList<HashMap<String, Object>> listItem2 = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> map2 = new HashMap<String, Object>();
        map2.put("text","你还没有加入小组群哦");
        listItem2.add(map2);
        SimpleAdapter mSimpleAdaptr2 = new SimpleAdapter(this, listItem2, R.layout.nothing,
                new String[]{"text"}, new int[]{R.id.textView});
        lvJoin.setAdapter(mSimpleAdaptr2);

        //创建，加入和退回mainactivity的按钮定义
        Button btnset = (Button)findViewById(R.id.BtnSet);
        btnset.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Groupcontent.this,group_start_activity.class);
                startActivity(intent);
            }
        });

        Button btnjoin = (Button)findViewById(R.id.BtnJoin);
        btnjoin.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Groupcontent.this,Groupsearch.class);
                startActivity(intent);
            }
        });

        Button btnQuitGroup = (Button)findViewById(R.id.buttonQuitGroup);
        btnQuitGroup.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Groupcontent.this,MainActivity.class);
                startActivity(intent);
                Groupcontent.this.finish();
            }
        });
    }

    @Override
    protected void onBackward(View backwardView){finish();}
}
