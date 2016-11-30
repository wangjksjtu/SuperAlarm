package superalarm.firsttry;

import android.app.NotificationManager;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.KeyEvent;
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

import basic_class.AlarmReminder;
import basic_class.Item;
import basic_class.ItemManager;
import basic_class.UserManager;

public class MainActivity extends TitleActivity {

    public static MainActivity instance = null;
    private TextClock hTextClock;
    private TextClock dTextClock;
//    private boolean have_login;
    private ListView lv;
    private ItemManager items = new ItemManager();
    private long exitTime = 0;
    private boolean isLogin = false;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        items.read(MainActivity.this);

        setTitle("超级闹钟");

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
                UserManager userManager = new UserManager();
                userManager.read(MainActivity.this);
                if (userManager.getUserArr().size() == 0) {
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, PersonalInformation.class);
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, PresonalInformationHaveLogin.class);
                    startActivity(intent);
                }
                //                finish();
            }
        });

        ImageButton btn_group = (ImageButton) findViewById(R.id.imageButton_group);
        btn_group.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Groupcontent.class);
                startActivity(intent);
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

//        if (userManager.getUserArr().size() != 0) {
//            isLogin = true;
//        }

        ItemManager itemManager = new ItemManager();
        ArrayList<Item> itemArrayList = itemManager.getItemArr();
        itemManager.read(MainActivity.instance);
        for (int i = 0; i < itemManager.getLength(); ++i) {
            final String deadline = itemArrayList.get(i).getDeadline();
            int y, m, d, h, min;
            y = Integer.valueOf(deadline.substring(0, 4));
            m = Integer.valueOf(deadline.substring(5, 7));
            d = Integer.valueOf(deadline.substring(8, 10));
            h = Integer.valueOf(deadline.substring(11, 13));
            min = Integer.valueOf(deadline.substring(14, 16));
            AlarmReminder alarmReminder = new AlarmReminder(y, m, d, h, min,
                    itemManager.getItemArr().get(i).getId());
            alarmReminder.startRemind();
        }
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
        //itemManager.write(this);
        //itemManager.sortByDeadline();
        ArrayList<Item> itemArrayList = itemManager.getItemArr();
        if (itemManager.getLength() != 0) {
            //Toast.makeText(this, "已经设置好所有闹钟！", Toast.LENGTH_SHORT).show();
            for (int i = 0; i < itemManager.getLength(); ++i) {
                    final String title = itemArrayList.get(i).getTitle();
                    final String deadline = itemArrayList.get(i).getDeadline();
                    final String module = itemArrayList.get(i).getModule();
                HashMap<String, Object> map = new HashMap<String, Object>();

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
        else{
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("text","快来创建一个事项吧！");
            listItem.add(map);
            SimpleAdapter mSimpleAdaptr = new SimpleAdapter(this, listItem, R.layout.nothing,
                    new String[]{"text"}, new int[]{R.id.textView});
            lv.setAdapter(mSimpleAdaptr);
        }
    }
    @Override
    public void onResume(){
        super.onResume();
        UpdateItems updateItems = new UpdateItems();
        updateItems.getItems();
        makeItemList();
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if (keyCode == KeyEvent.KEYCODE_BACK&&event.getAction() == KeyEvent.ACTION_DOWN){
            if (System.currentTimeMillis() - exitTime > 2000){
                Toast.makeText(getApplicationContext(),"再按一次返回桌面",Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            }else {
                Intent backHome = new Intent(Intent.ACTION_MAIN);
                backHome.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                backHome.addCategory(Intent.CATEGORY_HOME);
                startActivity(backHome);
        }return true;}
        return super.onKeyDown(keyCode,event);
    }
}
