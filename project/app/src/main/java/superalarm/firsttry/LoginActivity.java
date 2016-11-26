package superalarm.firsttry;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {
    public static LoginActivity instance = null;
    public boolean isEmail;
    private Button insure;
    private EditText inEmail, inPassword, rePassword, inName, inAge;
    private String upassword, repass, uName, uAge, str, email;
    public boolean flag;

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
//        inAge = (EditText) findViewById(R.id.InputAge);

//        uemail = inEmail.getText().toString();
//        uAge = inAge.getText().toString();
//        ugender = (RadioGroup) findViewById(R.id.Cgender);
//        male = (RadioButton) findViewById(R.id.Btnmale);
//        female = (RadioButton) findViewById(R.id.Btnfemale);
//        secret = (RadioButton) findViewById(R.id.BtnSecret);
        uName = inName.getText().toString();
        upassword = inPassword.getText().toString();
        repass = rePassword.getText().toString();

    }

//    public void onClick(View v) {
//        String str = "保密";
//        if (male.isChecked()) {
//            str = male.getText().toString();
//        } else if (female.isChecked()) {
//            str = female.toString();
//        }
//    }

    protected OnClickListener ToRegister_listener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            //正则表达式判断邮箱地址是否正确；

//            if (!(isEmail(uemail))) {
//                Toast.makeText(LoginActivity.this, R.string.errormail, Toast.LENGTH_SHORT).show();
//            } else if (uAge.compareTo("999") > 0) {
//               Toast.makeText(LoginActivity.this, R.string.errorage, Toast.LENGTH_SHORT).show();
//            } else
            flag = true;
            uName = inName.getText().toString();
            upassword = inPassword.getText().toString();
            repass = rePassword.getText().toString();
            if ((uName.length()) > 8) {
                Toast.makeText(LoginActivity.this, R.string.longname, Toast.LENGTH_SHORT).show();
                flag = false;
            }
//            if ((upassword.length()) < 8) {
//                Toast.makeText(LoginActivity.this, R.string.shortpass, Toast.LENGTH_SHORT).show();
//                flag = false;
//            }
//            if (repass.length() < 8) {
//                Toast.makeText(LoginActivity.this, R.string.shortpass, Toast.LENGTH_SHORT).show();
//                flag = false;
            //}

            if (!(upassword.equals(repass))){
                Toast.makeText(LoginActivity.this, R.string.differpass, Toast.LENGTH_SHORT).show();
                flag = false;
            }
            if (flag) {
                Intent it = new Intent();
                it.setClass(LoginActivity.this, AvatarActivity.class);
                startActivity(it);
                finish();
            }
        }
    };

    public boolean isEmail(String email) {
        //正则表达式
  /*
    String regex = "^[A-Za-z]{1,40}@[A-Za-z0-9]{1,40}\\.[A-Za-z]{2,3}$";
    return email.matches(regex);
   */
        //不适用正则
        if (email == null || "".equals(email)) return false;
        if (!containsOneWord('@', email) || !containsOneWord('.', email)) return false;
        String prefix = email.substring(0, email.indexOf("@"));
        String middle = email.substring(email.indexOf("@") + 1, email.indexOf("."));
        String subfix = email.substring(email.indexOf(".") + 1);
        System.out.println("prefix=" + prefix + "  middle=" + middle + "  subfix=" + subfix);

        if (prefix == null || prefix.length() > 40 || prefix.length() == 0) return false;
        if (!isAllWords(prefix)) return false;
        if (middle == null || middle.length() > 40 || middle.length() == 0) return false;
        if (!isAllWordsAndNo(middle)) return false;
        if (subfix == null || subfix.length() > 3 || subfix.length() < 2) return false;
        if (!isAllWords(subfix)) return false;
        return true;
    }

    //判断字符串只包含指定的一个字符c
    private boolean containsOneWord(char c, String word) {
        char[] array = word.toCharArray();
        int count = 0;
        for (Character ch : array) {
            if (c == ch) {
                count++;
            }
        }
        return count == 1;
    }

    //检查一个字符串是否全部是字母
    private boolean isAllWords(String prefix) {
        char[] array = prefix.toCharArray();
        for (Character ch : array) {
            if (ch < 'A' || ch > 'z' || (ch < 'a' && ch > 'Z')) return false;
        }
        return true;
    }

    //检查一个字符串是否包含字母和数字
    private boolean isAllWordsAndNo(String middle) {
        char[] array = middle.toCharArray();
        for (Character ch : array) {
            if (ch < '0' || ch > 'z') return false;
            else if (ch > '9' && ch < 'A') return false;
            else if (ch > 'Z' && ch < 'a') return false;
        }
        return true;
    }}