package superalarm.firsttry;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.Toast;
import android.widget.ImageButton;
import android.view.View;
import android.view.View.OnClickListener;
import android.app.Activity;
import android.content.Intent;

import superalarm.firsttry.PersonalInformation;
import superalarm.firsttry.R;

public class MainActivity extends AppCompatActivity {

    private TextClock hTextClock;
    private TextClock dTextClock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                finish();
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
                finish();
            }
        });
    }
}
