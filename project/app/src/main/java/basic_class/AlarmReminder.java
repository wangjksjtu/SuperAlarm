package basic_class;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.widget.Toast;

import java.util.Calendar;
import java.util.TimeZone;

import superalarm.firsttry.AlarmReceiver;
import superalarm.firsttry.MainActivity;

import static android.content.Context.ALARM_SERVICE;

/**
 * Created by 靖康 on 2016/11/23.
 */

public class AlarmReminder {
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private int Id;

    public AlarmReminder(int y, int m, int d, int h, int min, int id) {
        year = y; month = m;
        day = d; hour = h;
        minute = min; Id = id;

    }

    public String getDateInfo() {
        String str = String.valueOf(year) + "年" + String.valueOf(month) + "月" +  String.valueOf(day) + "日"
                + String.valueOf(hour) + "点" + String.valueOf(minute) + "分";
        return str;
    }

    public void startRemind() {
        startRemind(true);
    }

    public void stopRemind() {
        stopRemind(true);
    }

    public void startRemind(boolean isReminding) {
        Calendar mCalendar = Calendar.getInstance();
        mCalendar.setTimeInMillis(System.currentTimeMillis());

        //获取当前毫秒值
        long systemTime = System.currentTimeMillis();

        //设置日历的时间，让日历的年月日和当前同步
        mCalendar.setTimeInMillis(System.currentTimeMillis());
        //时区设置
        mCalendar.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        mCalendar.set(Calendar.YEAR, year);
        mCalendar.set(Calendar.MONTH, month - 1);
        mCalendar.set(Calendar.DAY_OF_MONTH, day);
        mCalendar.set(Calendar.HOUR_OF_DAY, hour);
        mCalendar.set(Calendar.MINUTE, minute);
        mCalendar.set(Calendar.SECOND, 0);
        mCalendar.set(Calendar.MILLISECOND, 0);

        long selectTime = mCalendar.getTimeInMillis();

        if (systemTime > selectTime) {
//            Toast.makeText(MainActivity.instance, "闹钟设置时间过期啦", Toast.LENGTH_LONG).show();
            return;
        }


        //AlarmReceiver.class为广播接受者
        Intent intent = new Intent(MainActivity.instance, AlarmReceiver.class);
        intent.putExtra("Id", Id);
        PendingIntent pi = PendingIntent.getBroadcast(
                MainActivity.instance, Id, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        //得到AlarmManager实例
        AlarmManager am = (AlarmManager) MainActivity.instance.getSystemService(ALARM_SERVICE);

        if (isReminding) Toast.makeText(MainActivity.instance, "闹钟时间："+ getDateInfo(), Toast.LENGTH_LONG).show();
        am.setExact(AlarmManager.RTC_WAKEUP, mCalendar.getTimeInMillis(), pi);
    }

    public void stopRemind(boolean isReminding) {
        Intent intent = new Intent(MainActivity.instance, AlarmReceiver.class);
        intent.putExtra("Id", Id);
        PendingIntent pi = PendingIntent.getBroadcast(MainActivity.instance, Id,
                intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager am = (AlarmManager) MainActivity.instance.getSystemService(ALARM_SERVICE);

        Calendar mCalendar = Calendar.getInstance();
        mCalendar.setTimeInMillis(System.currentTimeMillis());
        mCalendar.setTimeInMillis(System.currentTimeMillis());
        //时区设置
        mCalendar.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        mCalendar.set(Calendar.YEAR, year);
        mCalendar.set(Calendar.MONTH, month - 1);
        mCalendar.set(Calendar.DAY_OF_MONTH, day);
        mCalendar.set(Calendar.HOUR_OF_DAY, hour);
        mCalendar.set(Calendar.MINUTE, minute);
        long selectTime = mCalendar.getTimeInMillis();
        long systemTime = System.currentTimeMillis();
        if (systemTime < selectTime && isReminding) {
            Toast.makeText(MainActivity.instance, "关闭闹钟", Toast.LENGTH_SHORT).show();
            am.cancel(pi);
            return;
        }
        //取消警报
        am.cancel(pi);
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
