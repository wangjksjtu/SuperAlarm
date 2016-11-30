package superalarm.firsttry;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

import basic_class.AlarmReminder;
import basic_class.Item;
import basic_class.ItemManager;
import basic_class.NotExistException;



public class Detail extends TitleActivity {

    private ItemManager items = new ItemManager();
    public static Detail instance = null;
    private ListView list;
    private Item item = new Item();
    private int data;
    ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        list = (ListView)findViewById(R.id.list);

        items.read(this);

        instance = this;

        Intent intent = getIntent();
        data = intent.getIntExtra("num",-1);

        item = items.itemArr.get(data);

        setTitle(item.getTitle());
        showBackwardView(R.id.button_backward,true);
        showForwardView(R.id.button_forward,true);

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("title","重要性");
        map.put("text",item.getImportance());
        listItem.add(map);

        map = new HashMap<String, Object>();
        map.put("title","期限");
        map.put("text",item.getDeadline());
        listItem.add(map);

        map = new HashMap<String, Object>();
        map.put("title","详情");
        map.put("text",item.getContent());
        listItem.add(map);


        SimpleAdapter mSimpleAdaptr = new SimpleAdapter(this, listItem, R.layout.listitem2,
                new String[]{"title", "text"}, new int[]{R.id.title, R.id.text});
        list.setAdapter(mSimpleAdaptr);

        Button btn_delete = (Button)findViewById(R.id.button);
        btn_delete.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String deadline = item.getDeadline();
                    int y, m, d, h, min;
                    y = Integer.valueOf(deadline.substring(0, 4));
                    m = Integer.valueOf(deadline.substring(5, 7));
                    d = Integer.valueOf(deadline.substring(8, 10));
                    h = Integer.valueOf(deadline.substring(11, 13));
                    min = Integer.valueOf(deadline.substring(14, 16));

                    items.delete(item);
                    UpdateItems updateItems = new UpdateItems();
                    updateItems.deleteItems(item);
                    items.write(Detail.this);
                    AlarmReminder alarmReminder = new AlarmReminder(y, m, d, h, min,
                            item.getId());
                    alarmReminder.stopRemind();
                } catch (NotExistException e) {
                    e.printStackTrace();
                }
//                MainActivity.instance.finish();
//                Intent intent_jump = new Intent(Detail.this,MainActivity.class);
//                startActivity(intent_jump);
                finish();
            }
        });
    }
    @Override
    protected void onForward(View forwardView) {
        Intent intent_send = new Intent(Detail.this, event_start_activity.class);
        intent_send.putExtra("key",true);
        intent_send.putExtra("value",data);
        startActivity(intent_send);
    }
    @Override
    protected void onBackward(View backwardView) {
        finish();
    }
}

