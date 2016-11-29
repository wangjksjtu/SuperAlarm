package superalarm.firsttry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class Groupcontent extends TitleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groupcontent);

        setTitle("小组");
        showBackwardView(R.id.button_backward,true);

        Button btnset = (Button)findViewById(R.id.BtnSet);
        btnset.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Groupcontent.this,group_start_activity.class);
                startActivity(intent);
            }
        });

        Button btnjoin = (Button)findViewById(R.id.BtnJoin);
        btnjoin.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Groupcontent.this,Groupsearch.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onBackward(View backwardView){finish();}
}
