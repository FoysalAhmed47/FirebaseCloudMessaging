package com.example.firebasecloudmessaging;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import static android.content.Context.NOTIFICATION_SERVICE;

public class MyNotificationManager  {

    private Context mCtx;
    private static MyNotificationManager mInstance;

    private MyNotificationManager(Context context){
        mCtx = context;

    }
    public static synchronized MyNotificationManager getInstance(Context context){
        if (mInstance == null){
            mInstance = new MyNotificationManager(context);
        }
        return mInstance;
    }
    public void displayNotification(String title, String body){

        new NotificationCompat.Builder(mCtx, Constants.CHANNEL_ID)
                .setSmallIcon(R.drawable.icon)
                .setContentTitle(title)
                .setContentText(body);
        Intent resultIntent = new Intent(mCtx, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(mCtx, 0, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        Notification.Builder mBuilder = null;
        Notification.Builder builder = mBuilder.setContentIntent(pendingIntent);

        NotificationManager mNotificationManager =
                (NotificationManager) mCtx.getSystemService(Context.NOTIFICATION_SERVICE);

        if (mNotificationManager != null) {
            mNotificationManager.notify(1, mBuilder.build());
        }

    }
}
