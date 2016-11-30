package superalarm.firsttry;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import basic_class.UserManager;

public class PresonalInformationHaveLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_presonal_information_have_login);

        final ImageView btn_close = (ImageView) findViewById(R.id.imageButton_close);
        btn_close.setOnClickListener(new ImageView.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(PresonalInformationHaveLogin.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


//        Button btn = (Button) findViewById(R.id.btn);
//        btn.setOnClickListener(new Button.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = getIntent();
//                if (intent != null) {
//                    Bitmap bitmap = intent.getParcelableExtra("bitmap");
//                    Matrix matrix = new Matrix(); //接收图片之后放大 1.5倍
//                    matrix.postScale(1.5f, 1.5f);
//                    Bitmap bit = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(),
//                            bitmap.getHeight(), matrix, true);
//                    btn_close.setImageBitmap(bit);
//                }
//                finish();
//            }
//        });

        Button btn2 = (Button) findViewById(R.id.btn_login);
        btn2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserManager userManager = new UserManager();
                userManager.write(MainActivity.instance);
                Intent intent = new Intent();
                intent.setClass(PresonalInformationHaveLogin.this, WelcomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }}
