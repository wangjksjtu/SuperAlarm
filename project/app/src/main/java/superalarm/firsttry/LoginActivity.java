package superalarm.firsttry;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {
    public static LoginActivity instance = null;
    Button insure;
    EditText inEmail, inPassword, rePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        instance = this;

        insure = (Button) findViewById(R.id.ToRegister);
        inEmail = (EditText) findViewById(R.id.InputEmail);
        inPassword = (EditText) findViewById(R.id.InputPassWord);
        rePassword = (EditText) findViewById(R.id.RePassWord);
        insure.setOnClickListener(ToRegister_listener);
    }

    private Button.OnClickListener ToRegister_listener=new Button.OnClickListener(){
        @Override
        public void onClick(View v) {
            Intent it = new Intent();
            it.setClass(LoginActivity.this, SelfInfoActivity.class);
            startActivity(it);
//            finish();
        }
    };
}