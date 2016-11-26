package superalarm.firsttry;

import android.app.NotificationManager;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextClock;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import basic_class.Item;
import basic_class.ItemManager;

public class MainActivity extends AppCompatActivity {

    public static MainActivity instance = null;
    private TextClock hTextClock;
    private TextClock dTextClock;
    private boolean have_login;
    private ListView lv;
    private ItemManager items = new ItemManager();


public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        items.read(MainActivity.this);



        lv = (ListView) findViewById(R.id.list);

        instance = this;
        makeItemList();

        hTextClock = (TextClock) findViewById(R.id.textClock3);
        dTextClock = (TextClock) findViewById(R.id.textClock4);
        AssetManager mgr = getAssets();
        Typeface tf = Typeface.createFromAsset(mgr, "fonts/FZLTCXHJW.TTF");
        hTextClock.setTypeface(tf);
        dTextClock.setTypeface(tf);

        ImageButton btn_person = (ImageButton) findViewById(R.id.imageButton_person);
        btn_person.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, PersonalInformation.class);
                startActivity(intent);
//                finish();
            }
        });

        ImageButton btn_group = (ImageButton) findViewById(R.id.imageButton_group);
        btn_group.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent();
                //intent.putExtra("key",false);
                //startActivity(intent);
                Toast.makeText(MainActivity.this,"No Service",Toast.LENGTH_LONG).show();
            }
        });

        ImageButton btn_new = (ImageButton) findViewById(R.id.imageButton_add);
        btn_new.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, type_set_activity.class);
                startActivity(intent);
//                finish();
            }
        });

    }

    private void clearNotification(int nId) {
        NotificationManager notificationManager = (NotificationManager) this
                .getSystemService(NOTIFICATION_SERVICE);
        notificationManager.cancel(nId);

    }

    private void makeItemList() {
        ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();/*在数组中存放数据*/
        ItemManager itemManager = new ItemManager();
        itemManager.read(this);
        itemManager.write(this);
        ArrayList<Item> itemArrayList = itemManager.getItemArr();
        if (itemManager.getLength() != 0) {
            Toast.makeText(this, "已经设置好所有闹钟！", Toast.LENGTH_SHORT).show();
        }
        for (int i = 0; i < itemManager.getLength(); ++i) {
            final String title = itemArrayList.get(i).getTitle();
            final String deadline = itemArrayList.get(i).getDeadline();
            final String module = itemArrayList.get(i).getModule();
//            int y , m , d , h, min;
//            y = Integer.valueOf(deadline.substring(0,4));
//            m = Integer.valueOf(deadline.substring(5,7));
//            d = Integer.valueOf(deadline.substring(8,10));
//            h = Integer.valueOf(deadline.substring(11,13));
//            min = Integer.valueOf(deadline.substring(14,16));
            HashMap<String, Object> map = new HashMap<String, Object>();
//            startRemind(y, m, d, h, min, i);
            switch (module) {
                case "交际":
                    map.put("ItemImage", R.drawable.communication);
                    break;
                case "娱乐":
                    map.put("ItemImage", R.drawable.entertainment);
                    break;
                case "学习":
                    map.put("ItemImage", R.drawable.study);
                    break;
                case "运动":
                    map.put("ItemImage", R.drawable.exercise);
                    break;
                case "餐饮":
                    map.put("ItemImage", R.drawable.food);
                    break;
                default:
                    map.put("ItemImage", R.drawable.clock1);
            }
            map.put("ItemTitle", title);
            map.put("ItemText", deadline);
            listItem.add(map);
        }

        SimpleAdapter mSimpleAdaptr = new SimpleAdapter(this, listItem, R.layout.listitem,
                new String[]{"ItemImage", "ItemTitle", "ItemText"}, new int[]{R.id.ItemImage, R.id.ItemTitle, R.id.ItemText});
        lv.setAdapter(mSimpleAdaptr);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                Intent intent = new Intent(MainActivity.this, Detail.class);
                intent.putExtra("num", arg2);
                startActivity(intent);
            }
        });

        instance = this;
    }

}
