package superalarm.firsttry;

/**
 * Created by wangjksjtu on 2016/11/19.
 */

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle= intent.getExtras();
        //Toast.makeText(context, "attention!" +  bundle.getInt("Id"),Toast.LENGTH_LONG).show();
        NotificationCompat.Builder mBuilder;
        mBuilder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("SuperAlarm")
                .setContentText("您有事项到期啦")
                .setDefaults(Notification.DEFAULT_ALL)
                .setTicker("事项到期提醒")
                .setWhen(System.currentTimeMillis())        //通知产生的时间，在通知信息里显示
                .setPriority(Notification.PRIORITY_MAX);    //设置该通知优先级;
        Intent resultIntent = new Intent(context, MainActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        bundle.getInt("Id"),
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(bundle.getInt("Id"), mBuilder.build());
    }

}
