package superalarm.firsttry;

import android.app.Activity;
import android.content.Intent;;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Button;

public class LoginActivity extends Activity {
    Button insure;
    EditText inEmail, inPassword, rePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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
            //finish();
        }
    };
}