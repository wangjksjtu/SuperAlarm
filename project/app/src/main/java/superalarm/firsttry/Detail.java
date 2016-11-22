package superalarm.firsttry;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.view.View;
import android.view.View.OnClickListener;
import android.app.Activity;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import basic_class.ItemManager;
import basic_class.NotExistException;
import basic_class.RepeatedAddtionException;



public class Detail extends AppCompatActivity {

    private ItemManager items = new ItemManager();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        items.read(Detail.this);

        Intent intent = getIntent();
        final int data = intent.getIntExtra("num",-1);

        TextView info = (TextView)findViewById(R.id.textView4);
        TextView time = (TextView)findViewById(R.id.textView5);

        String title = items.itemArr.get(data).title;
        String content = items.itemArr.get(data).content;
        String deadline = items.itemArr.get(data).deadline;

        setTitle(title);
        info.setText(content);
        time.setText(deadline);

        Button btn_delete = (Button)findViewById(R.id.button);
        btn_delete.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    items.delete(items.itemArr.get(data));
                    items.write(Detail.this);
                } catch (NotExistException e) {
                    e.printStackTrace();
                }
                MainActivity.instance.finish();
                Intent intent_jump = new Intent(Detail.this,MainActivity.class);
                startActivity(intent_jump);
                finish();
            }
        });

        ImageButton btn_revert = (ImageButton)findViewById(R.id.imageButton_revert);
        btn_revert.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ImageButton btn_edit = (ImageButton)findViewById(R.id.imageButton_edit);
        btn_edit.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_send = new Intent(Detail.this, event_start_activity.class);
                intent_send.putExtra("key",true);
                intent_send.putExtra("value",data);
                startActivity(intent_send);
            }
        });
    }
}

