package superalarm.firsttry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class SelfInfoActivity extends AppCompatActivity {
    public static SelfInfoActivity instance = null;
    private ImageButton male,female,non_sex;
    private Button sureinFo;
    private EditText niName;
    boolean isMale,isFemale,isSecret;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_self_info);
        instance = this;

        sureinFo=(Button)findViewById(R.id.EInfo);
        male=(ImageButton)findViewById(R.id.smale);
        female=(ImageButton)findViewById(R.id.sfemale);
        non_sex=(ImageButton)findViewById(R.id.snone);

        niName=(EditText)findViewById(R.id.EtxtName);

        sureinFo.setOnClickListener(EInfo_listener);
        male.setOnClickListener(smale_listener);
        female.setOnClickListener(sfemale_listener);
        non_sex.setOnClickListener(snone_listener);
    }
    private Button.OnClickListener EInfo_listener= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent it = new Intent();
            it.setClass(SelfInfoActivity.this, AvatarActivity.class);
            startActivity(it);
//            finish();
        }
    };
    //ImageButton写函数，处理性别三选一，取代RadioGroup;
    private ImageButton.OnClickListener smale_listener=new View.OnClickListener(){
        @Override
        public void onClick(View v) {
               boolean isMale=true;
        }
    };
    private ImageButton.OnClickListener sfemale_listener=new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            boolean isFemale=true;
        }
    };
    private ImageButton.OnClickListener snone_listener=new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            boolean isSecret=true;
        }
    };

}
