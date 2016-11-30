package superalarm.firsttry;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

import basic_class.AlarmReminder;
import basic_class.ItemManager;

;

public class WelcomeActivity extends Activity {
    public static WelcomeActivity instance = null;
    private EditText aUserName, aPassWord;
    private Button aLogin, aRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        instance = this;

        aUserName = (EditText) findViewById(R.id.EtxtUserName);
        aPassWord = (EditText) findViewById(R.id.EtxtPassWord);
        aLogin = (Button) findViewById(R.id.BtnLogin);
        aRegister = (Button) findViewById(R.id.BtnRegister);

        aLogin.setOnClickListener(BtnLoginOnClick);
        aRegister.setOnClickListener(BtnRegisterOnClick);
        }

        //点击“登录”按钮，接收讯息：用户名+密码
        private View.OnClickListener BtnLoginOnClick=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String thisUserName = aUserName.getText().toString();
                String thisPassWord = aPassWord.getText().toString();

                logIn(thisUserName, thisPassWord);
            }
        };
            //点击“注册”按钮，跳转至注册信息填写界面
            private View.OnClickListener BtnRegisterOnClick = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent it = new Intent();
                    it.setClass(WelcomeActivity.this, LoginActivity.class);
                    startActivity(it);
                    //finish();
                }
            };

    public void logIn(String username, String password) {
        JsonTask2 jsonTask = new JsonTask2();
        jsonTask.execute("http://www.wangjksjtu.com.cn:2117/items/","GET", "User", username,
                password);
    }

    class JsonTask2 extends JsonTask{
        @Override
        protected void onPostExecute(String result) {
            if (Objects.equals(result, "success")) {
                finish();

                ItemManager itemManager = new ItemManager();
                itemManager.read(MainActivity.instance);
                for (int i = 0; i < itemManager.getLength(); ++i) {
                    final String deadline = itemManager.getItemArr().get(i).getDeadline();
                    int y, m, d, h, min;
                    y = Integer.valueOf(deadline.substring(0, 4));
                    m = Integer.valueOf(deadline.substring(5, 7));
                    d = Integer.valueOf(deadline.substring(8, 10));
                    h = Integer.valueOf(deadline.substring(11, 13));
                    min = Integer.valueOf(deadline.substring(14, 16));
                    AlarmReminder alarmReminder = new AlarmReminder(y, m, d, h, min,
                            itemManager.getItemArr().get(i).getId());
                    alarmReminder.stopRemind(false);
                }

                UpdateItems updateItems = new UpdateItems();
                updateItems.getItems();

                MainActivity.instance.finish();
                Intent in = new Intent();
                in.setClass(WelcomeActivity.this, MainActivity.class);
                startActivity(in);

                Toast.makeText(WelcomeActivity.this, "数据同步成功", Toast.LENGTH_SHORT).show();
                Intent it = new Intent();
                it.setClass(WelcomeActivity.this, PresonalInformationHaveLogin.class);
                startActivity(it);
            }
            else if (Objects.equals(result, "failure")) {
                Toast.makeText(WelcomeActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(WelcomeActivity.this, "网络无连接", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
