package superalarm.firsttry;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.widget.Button;
import android.widget.ImageButton;

public class type_set_activity extends AppCompatActivity {

    public static type_set_activity instance = null;
    private Button bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.type_setter);
        instance = this;

        bt1 = (Button) findViewById(R.id.button1);
        bt1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(type_set_activity.this, event_start_activity.class);
                intent.putExtra("typeConvey",bt1.getText());
                startActivity(intent);
//                type_set_activity.this.finish();
            }
        });

        bt2 = (Button) findViewById(R.id.button2);
        bt2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(type_set_activity.this, event_start_activity.class);
                intent.putExtra("typeConvey",bt2.getText());
                startActivity(intent);
//                type_set_activity.this.finish();
            }
        });

        bt3 = (Button) findViewById(R.id.button3);
        bt3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(type_set_activity.this, event_start_activity.class);
                intent.putExtra("typeConvey",bt3.getText());
                startActivity(intent);
//                type_set_activity.this.finish();
            }
        });

        bt4 = (Button) findViewById(R.id.button4);
        bt4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(type_set_activity.this, event_start_activity.class);
                intent.putExtra("typeConvey",bt4.getText());
                startActivity(intent);
//                type_set_activity.this.finish();
            }
        });

        bt5 = (Button) findViewById(R.id.button5);
        bt5.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(type_set_activity.this, event_start_activity.class);
                intent.putExtra("typeConvey",bt5.getText());
                startActivity(intent);
//                type_set_activity.this.finish();
            }
        });

        bt6 = (Button) findViewById(R.id.button6);
        bt6.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(type_set_activity.this, event_start_activity.class);
                intent.putExtra("typeConvey",bt6.getText());
                startActivity(intent);
//                type_set_activity.this.finish();
            }
        });

        bt7 = (Button) findViewById(R.id.button7);
        bt7.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(type_set_activity.this, event_start_activity.class);
                intent.putExtra("typeConvey",bt7.getText());
                startActivity(intent);
//                type_set_activity.this.finish();
            }
        });

        bt8 = (Button) findViewById(R.id.button8);
        bt8.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(type_set_activity.this, event_start_activity.class);
                intent.putExtra("typeConvey",bt8.getText());
                startActivity(intent);
//                type_set_activity.this.finish();
            }
        });

        Button bt9 = (Button)findViewById(R.id.button9);
        bt9.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setClass(type_set_activity.this,MainActivity.class);
//                startActivity(intent);
                type_set_activity.this.finish();
            }
        });
    }
}