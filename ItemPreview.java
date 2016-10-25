package com.example.admin.superalarm;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by admin on 2016/10/25.
 */

public class ItemPreview extends LinearLayout {
    private int buttoncolor;
    private int buttontextcolor;
    private CharSequence buttontext;
    private int textcolor;
    private CharSequence titletext;
    private CharSequence timetext;
    private int titlesize;
    private int timesize;
    private Button btn;
    private TextView title;
    private TextView time;
    public ItemPreview(Context context) {
        super(context);
    }

    public ItemPreview(Context context, AttributeSet attrs){
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.ItemPreview, this, true);

        btn = (Button) view.findViewById(R.id.itemBtn);
        title = (TextView) view.findViewById(R.id.titleText);
        time = (TextView) view.findViewById(R.id.timeText);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.itempreview);
        int n = a.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = a.getIndex(i);
            switch (attr) {
                case R.styleable.itempreview_buttoncolor:
                    buttoncolor = a.getColor(attr,0xffffffff);
                    break;
                case R.styleable.itempreview_buttontext:
                    buttontext = a.getText(attr);
                    break;
                case R.styleable.itempreview_buttontextcolor:
                    buttontextcolor = a.getColor(attr,0x00000000);
                    break;
                case R.styleable.itempreview_textcolor:
                    textcolor = a.getColor(attr,0x00000000);
                    break;
                case R.styleable.itempreview_titletext:
                    titletext = a.getText(attr);
                    break;
                case R.styleable.itempreview_timetext:
                    timetext = a.getText(attr);
                    break;
                case R.styleable.itempreview_titlesize:
                    titlesize = a.getDimensionPixelSize(
                            attr, (int) TypedValue.applyDimension(
                                    TypedValue.COMPLEX_UNIT_SP, 25, getResources().getDisplayMetrics()));//默认标题字体大小25sp
                    break;
                case R.styleable.itempreview_timesize:
                    timesize = a.getDimensionPixelSize(
                            attr, (int) TypedValue.applyDimension(
                                    TypedValue.COMPLEX_UNIT_SP, 25, getResources().getDisplayMetrics()));//默认标题字体大小25sp
                    break;

            }
            btn.setBackgroundColor(buttoncolor);
            if (buttontext!=null){
                btn.setText(buttontext);
                btn.setTextColor(buttontextcolor);
            }
            if (titletext!=null){
                title.setText(titletext);
                title.setTextColor(textcolor);
                title.setTextSize(titlesize);
            }
            if (timetext!=null){
                time.setText(timetext);
                time.setTextColor(textcolor);
                time.setTextSize(timesize);
            }
            a.recycle();

    }
}
    public void setTitle(String text) {
        title.setText(text);
    }

    public void setTime(String text) {
        time.setText(text);
    }

}
