package superalarm.firsttry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class AvatarActivity extends AppCompatActivity {
    private Button yesTo;
    private ImageButton Head;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avatar);

        yesTo=(Button)findViewById(R.id.Ensure);
        Head=(ImageButton)findViewById(R.id.RandomAvatar);

        yesTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AvatarActivity.this,PersonalInformation.class);
                startActivity(intent);
                AvatarActivity.this.finish();
            }
        });
        //Head.setOnClickListener(RandomAvatarOnClick);
    }
}

