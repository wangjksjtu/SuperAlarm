package superalarm.firsttry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class Groupsearch extends TitleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groupsearch);

        setTitle("搜索小组");
        showBackwardView(R.id.button_backward,true);

        Button btnsearch = (Button)findViewById(R.id.search);
        btnsearch.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Groupsearch.this,"功能尚未完善",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Groupsearch.this,not_yet_activity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onBackward(View backwardView){finish();}
}
