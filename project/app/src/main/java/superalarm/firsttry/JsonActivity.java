package superalarm.firsttry;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by wangjksjtu on 2016/11/19.
 */

public class JsonActivity extends AppCompatActivity {

    private TextView tvData;

    @Override
    protected void onCreate(Bundle savedInstaceState) {
        super.onCreate(savedInstaceState);
        setContentView(R.layout.json);

        Button btnHit = (Button)findViewById(R.id.btnHit);
        tvData = (TextView)findViewById(R.id.tvJsonItem);

        btnHit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new JsonTask().execute("http://www.wangjksjtu.com.cn:2117/items/8/","PUT");
            }
        });

    }

    private class JsonTask extends superalarm.firsttry.JsonTask {
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            tvData.setText(result);
        }
    }
}
