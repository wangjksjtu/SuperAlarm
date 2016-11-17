package superalarm.firsttry;

import android.app.ListActivity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextClock;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public  static MainActivity instance = null;
    private TextClock hTextClock;
    private TextClock dTextClock;
    private boolean have_login;
    private int mId = 0;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView)findViewById(R.id.list);
        ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String,Object>>();/*在数组中存放数据*/
        for (int i = 0;i<=20;i++){
            HashMap<String,Object> map = new HashMap<String,Object>();
            map.put("ItemImage",R.drawable.btn_add_press);
            map.put("ItemTitle","第"+i+"行");
            map.put("ItemText","这是第"+i+"行");
            listItem.add(map);
        }

        SimpleAdapter mSimpleAdaptr = new SimpleAdapter(this,listItem,R.layout.listitem,
                new String[]{"ItemImage","ItemTitle","ItemText"},new int[]{R.id.ItemImage,R.id.ItemTitle,R.id.ItemText});
        lv.setAdapter(mSimpleAdaptr);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                   long arg3) {
                Intent intent = new Intent(MainActivity.this,Detail.class);
                Bundle bundle = new Bundle();
                intent.putExtra("string_key","0"+arg2);
                startActivity(intent);
            }
        });

        instance = this;

        hTextClock = (TextClock)findViewById(R.id.textClock3);
        dTextClock = (TextClock)findViewById(R.id.textClock4);
        AssetManager mgr = getAssets();
        Typeface tf = Typeface.createFromAsset(mgr, "fonts/FZLTCXHJW.TTF");
        hTextClock.setTypeface(tf);
        dTextClock.setTypeface(tf);

        ImageButton btn_person = (ImageButton)findViewById(R.id.imageButton_person);
        btn_person.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,PersonalInformation.class);
                startActivity(intent);
//                finish();
            }
        });

        ImageButton btn_group = (ImageButton)findViewById(R.id.imageButton_group);
        btn_group.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"No Service",Toast.LENGTH_LONG).show();
            }
        });

        ImageButton btn_new = (ImageButton)findViewById(R.id.imageButton_add);
        btn_new.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,type_set_activity.class);
                startActivity(intent);
//                finish();
            }
        });
        clearNotification();
    }

    private void showNotification() {
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.clock1)
                        .setContentTitle("SuperAlarm notification")
                        .setContentText("Hello World!");
        // Creates an explicit intent for MainActivity
        Intent resultIntent = new Intent(this, MainActivity.class);
        // The stack builder object will contain an artificial back stack for the started Activity.
        // It ensures that navigating backward from the Activity leads out of your application to the Home screen.
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        // Adds the back stack for the Intent (but not the Intent itself)
        stackBuilder.addParentStack(MainActivity.class);
        // Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        // mId allows are used to update the notification later on.
        mNotificationManager.notify(mId, mBuilder.build());
    }

    private void clearNotification(){
        NotificationManager notificationManager = (NotificationManager) this
                .getSystemService(NOTIFICATION_SERVICE);
        notificationManager.cancel(0);

    }

    @Override
    protected void onStop() {
        showNotification();
        super.onStop();
    }

    @Override
    protected void onStart() {
        clearNotification();
        super.onStart();
    }
}
