package superalarm.firsttry;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button nexT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nexT=(Button)findViewById(R.id.BtnnexT);
        nexT.setOnClickListener(BtnnexTOnClick);
    }
    private View.OnClickListener BtnnexTOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent it = new Intent();
            it.setClass(MainActivity.this, WelcomeActivity.class);
            startActivity(it);
            //finish();
        }
    };
    }
