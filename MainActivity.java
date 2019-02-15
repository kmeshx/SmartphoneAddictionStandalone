package com.example.notiftest;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

public class MainActivity extends AppCompatActivity {
    public int globalCount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*final Button button1 = findViewById(R.id.test_not);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Close activity, continue using cur app (maybe?)
                globalCount+=1;
                Log.d("CountIncreased", "index=" + globalCount);

                if (globalCount > 5){
                    Log.d("NotifCond", "wut");
                    String time_spent = "testTime909";
                    String app_used = "testAppName";
                    RemoteViews timeOut = new RemoteViews(getPackageName(), R.layout.activity_timeout1);
                    timeOut.setTextViewText(R.id.timeSpent, time_spent);
                    timeOut.setTextViewText(R.id.curApp, app_used);

                    Intent pendIntTO = new Intent(getApplicationContext(), TimeOutActivity.class);
                    //add time spent and app info data to intent
                    pendIntTO.putExtra("timeAndCurApp", "testTime909,testAppName");

                    // use System.currentTimeMillis() to have a unique ID for the pending intent
                    PendingIntent finPendInt = PendingIntent.getActivity(getApplicationContext(), (int) System.currentTimeMillis(), pendIntTO , 0);


                    NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getApplicationContext())
                            .setContent(timeOut).setAutoCancel(true);
                    mBuilder.setPriority(Notification.PRIORITY_MAX);
                    mBuilder.setFullScreenIntent(finPendInt, true);
                    //timeOutIntent has same layout as timeOut remote view

                    Notification notification = mBuilder.build();
                    notification.flags |= Notification.FLAG_AUTO_CANCEL;
                    notification.defaults |= Notification.DEFAULT_SOUND;
                    notification.defaults |= Notification.DEFAULT_VIBRATE;


                }

            }
        });*/
    }


    public void notifTest(View view) {
        // Do something in response to button click
        globalCount+=1;
        if(globalCount%5 == 0){
            //int timeAtStart = (int) System.currentTimeMillis();
            Intent servInt = new Intent(this, OverlayService.class);
            servInt.putExtra("timeAndCurrentApp", "testTime909,testAppName");
            startService(servInt);
            //Intent intentOA = new Intent(getApplicationContext(), OverlayActivity.class);
            //startActivity(intentOA);

        }


        /*
        globalCount+=1;
        //System.out.print(globalCount);
        Log.d("CountIncreased", "index=" + globalCount);

        if (globalCount > 5){
            Log.d("NotifCond", "wut");
            String time_spent = "testTime909";
            String app_used = "testAppName";
            //RemoteViews timeOut = new RemoteViews(getPackageName(), R.layout.activity_timeout1);
            //timeOut.setTextViewText(R.id.timeSpent, time_spent);
            //timeOut.setTextViewText(R.id.curApp, app_used);

            Intent pendIntTO = new Intent(MainActivity.this, TimeOutActivity.class);
            Log.d("Intent initialized", "intentStart");
            //add time spent and app info data to intent
            pendIntTO.putExtra("timeAndCurrentApp", "testTime909,testAppName");
            //startActivity(pendIntTO);
            Log.d("Intent Activity Starter", "can you see toact?");
            pendIntTO.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

            // use System.currentTimeMillis() to have a unique ID for the pending intent
            PendingIntent finPendInt = PendingIntent.getActivity(getApplicationContext(), 0, pendIntTO , 0);

            Log.d("PIntentActivityStarter", "PIGA");
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getApplicationContext(), "notifTestChannel");
            //NotificationCompat.Builder mBuilder;
            mBuilder.setSmallIcon(R.drawable.ic_launcher_foreground).setContentTitle("This is title of notification").setContentText("This is a notification Text");
            //mBuilder.setCustomContentView(timeOut).setCustomBigContentView(timeOut).setContent(timeOut).setAutoCancel(true);
            mBuilder.setContentIntent(finPendInt);
            mBuilder.setPriority(Notification.PRIORITY_MAX);
            mBuilder.setFullScreenIntent(finPendInt, true);
            mBuilder.setAutoCancel(true);
            //timeOutIntent has same layout as timeOut remote view


            NotificationManager mNotificationManager;
            mNotificationManager =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                String channelId = "notifTestChannel";
                NotificationChannel channel = new NotificationChannel(channelId,
                        "Channel for NT",
                        NotificationManager.IMPORTANCE_HIGH);
                mNotificationManager.createNotificationChannel(channel);
                mBuilder.setChannelId(channelId);
            }

            mNotificationManager.notify(0, mBuilder.build());




        }*/
    }
}
