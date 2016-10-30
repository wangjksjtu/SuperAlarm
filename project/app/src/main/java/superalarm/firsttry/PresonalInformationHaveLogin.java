package superalarm.firsttry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;

public class PresonalInformationHaveLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_presonal_information_have_login);


        ImageButton btn_close = (ImageButton)findViewById(R.id.imageButton_close);
        btn_close.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setClass(PresonalInformationHaveLogin.this,MainActivity.class);
//                startActivity(intent);
                finish();
            }
        });
    }
}
