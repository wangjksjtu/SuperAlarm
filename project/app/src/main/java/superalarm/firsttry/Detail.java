package superalarm.firsttry;

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

public class Detail extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String data = intent.getStringExtra("string_key");

        TextView title = (TextView)findViewById(R.id.textView2);
        TextView info = (TextView)findViewById(R.id.textView4);

        title.setText(data);
        info.setText(data+data);

        ImageButton btn_revert = (ImageButton)findViewById(R.id.imageButton_revert);
        btn_revert.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

