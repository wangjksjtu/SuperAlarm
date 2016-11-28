package superalarm.firsttry;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {
    public static LoginActivity instance = null;
    public boolean isEmail;
    private Button insure;
    private EditText inEmail, inPassword, rePassword, inName, inAge;
    private String upassword, repass, uName, uemail;
    private boolean flag = true;

//    private RadioGroup ugender;
//    private RadioButton male, female, secret;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        instance = this;

        insure = (Button) findViewById(R.id.ToRegister);
        insure.setOnClickListener(ToRegister_listener);

        inEmail = (EditText) findViewById(R.id.InputEmail);
        inPassword = (EditText) findViewById(R.id.InputPassWord);
        rePassword = (EditText) findViewById(R.id.RePassWord);
        inName = (EditText) findViewById(R.id.InputName);

    }

    protected OnClickListener ToRegister_listener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            //正则表达式判断邮箱地址是否正确；

            uemail = inEmail.getText().toString();
            uName = inName.getText().toString();
            upassword = inPassword.getText().toString();
            repass = rePassword.getText().toString();

            flag = true;

            Pattern pattern=Pattern.compile("\\w+@(\\w+.)+[a-z]{2,3}");//\w表示a-z，A-Z，0-9(\\转义符)
            Matcher matcher=pattern.matcher(uemail);
            boolean mailIsValid =matcher.matches();

            if(!mailIsValid) {
                Toast.makeText(LoginActivity.this, R.string.errormail, Toast.LENGTH_SHORT).show();
                flag = false;
            }

//            if (!checkEmail(uemail)) {
//                Toast.makeText(LoginActivity.this, R.string.errormail, Toast.LENGTH_SHORT).show();
//                flag = false;
//            }

            if ((uName.length()) > 20) {
                Toast.makeText(LoginActivity.this, R.string.longname, Toast.LENGTH_SHORT).show();
                flag = false;
            }
            if ((upassword.length()) < 8) {
                Toast.makeText(LoginActivity.this, R.string.shortpass, Toast.LENGTH_SHORT).show();
                flag = false;
            }
            if (isAllNums(upassword)) {
                Toast.makeText(LoginActivity.this, "密码不能全为数字", Toast.LENGTH_SHORT).show();
                flag = false;
            }

            if (!(upassword.equals(repass))){
                Toast.makeText(LoginActivity.this, R.string.differpass, Toast.LENGTH_SHORT).show();
                flag = false;
            }

            if (flag) {
                UserSignUp userLogInSignUp = new UserSignUp(uName, upassword, uemail);
                userLogInSignUp.signUp();
//                    Intent it = new Intent();
//                    it.setClass(LoginActivity.this, AvatarActivity.class);
//                    startActivity(it);
//                    finish();
//                }
//                else {
//                    Toast.makeText(LoginActivity.this, "用户名已经有人注册", Toast.LENGTH_SHORT).show();
//                }
            }
        }
    };

    public static boolean checkEmail(String email)
    {// 验证邮箱的正则表达式
        String format = "\\w{2,15}[@][a-z0-9]{3,}[.]\\p{Lower}{2,}";
        //p{Alpha}:内容是必选的，和字母字符[\p{Lower}\p{Upper}]等价。如：200896@163.com不是合法的。
        //w{2,15}: 2~15个[a-zA-Z_0-9]字符；w{}内容是必选的。 如：dyh@152.com是合法的。
        //[a-z0-9]{3,}：至少三个[a-z0-9]字符,[]内的是必选的；如：dyh200896@16.com是不合法的。
        //[.]:'.'号时必选的； 如：dyh200896@163com是不合法的。
        //p{Lower}{2,}小写字母，两个以上。如：dyh200896@163.c是不合法的。
        if (email.matches(format))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    //检查一个字符串是否全部是数字
    private boolean isAllNums(String prefix) {
        char[] array = prefix.toCharArray();
        for (Character ch : array) {
            if (ch < '0' || ch > '9') return false;
        }
        return true;
    }

    private class UserSignUp {

        private String username;
        private String password;
        private String email;

        public UserSignUp(String username, String password, String email) {
            this.username = username;
            this.password = password;
            this.email = email;
        }

//    public boolean logIn() {
//        JsonTask jsonTask = new JsonTask();
//        jsonTask.execute("http://www.wangjksjtu.com.cn:2117/users/","GET", "User", username,
//                password);
//        return jsonTask.isOK();
//    }

        public void signUp() {
            JsonTask2 jsonTask = new JsonTask2();
            jsonTask.execute("http://www.wangjksjtu.com.cn:2117/users/","POST", "User", username,
                    password, email);
        }

        class JsonTask2 extends JsonTask{
            @Override
            protected void onPostExecute(String result) {
                if (result == "success") {
                    Intent it = new Intent();
                    it.setClass(LoginActivity.this, AvatarActivity.class);
                    startActivity(it);
                    finish();
                }
                else if (result == "failure") {
                    Toast.makeText(LoginActivity.this, "用户名已经有人注册", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(LoginActivity.this, "网络无服务", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

}