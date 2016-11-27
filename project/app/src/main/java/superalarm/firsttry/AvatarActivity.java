package superalarm.firsttry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;

import static android.R.attr.bitmap;

public class AvatarActivity extends AppCompatActivity {
    private Button yesTo;
    private ImageButton Head;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_avatar);

        yesTo=(Button)findViewById(R.id.Ensure);
        Head=(ImageButton)findViewById(R.id.RandomAvatar);

        yesTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AvatarActivity.this,PresonalInformationHaveLogin.class);
                startActivity(intent);
                AvatarActivity.this.finish();
                WelcomeActivity.instance.finish();
                LoginActivity.instance.finish();
            }
        });
        Head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(AvatarActivity.this,ChooseActivity.class);
                startActivity(intent);
            }
        });
    }
}

